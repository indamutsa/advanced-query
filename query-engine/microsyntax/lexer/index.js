const { IllegalCharacterError, InvalidToken } = require("../error/error.js");
const Token = require("./token.js");

// Convert the array to a Set for faster lookup
const specialCharsToEscape = new Set([
  "+",
  "-",
  "=",
  "&",
  "|",
  "!",
  "{",
  "}",
  "[",
  "]",
  "(",
  ")",
  "^",
  '"',
  "~",
  "*",
  "?",
  ":",
  "\\",
  "#",
]);

class Lexer {
  constructor(text) {
    this.text = this.trimAndReduceWhitespace(text); // The input text
    this.position = 0; // The current position in the text
    this.currentChar = this.text[this.position]; // The current character
    this.tokens = []; // The list of tokens to be returned
    this.error = null; // Add an error property to the lexer
  }

  // Move the `position` pointer to the next character in the text
  advance() {
    this.position++;
    if (this.position > this.text.length - 1) {
      this.currentChar = null; // We're at the end of the file
    } else {
      this.currentChar = this.text[this.position];
    }
  }

  // Add a method to handle errors
  handleError(type, message, token = null, tokenIndex = null) {
    if (type === "illegalCharacter") {
      this.error = new IllegalCharacterError(
        this.currentChar,
        this.position,
        message
      );
    } else if (type === "invalidToken") {
      this.error = new InvalidToken(token, tokenIndex, message);
    }
    throw this.error;
  }

  // Process a number (sequence of digits)
  number() {
    // const numberRegex = /^[0-9]+(\.[0-9]+)?$/;
    const isNumber = (str) => {
      return /^[0-9.]+$/.test(str);
    };

    let result = "";

    while (isNumber(this.currentChar)) {
      let testResult = result + this.currentChar;
      if (isNumber(testResult)) {
        result += this.currentChar;
        this.advance();
      } else {
        break;
      }
    }

    return result;
  }

  logicalOperator() {
    let result = this.currentChar;
    this.advance();

    // check if the next character could be part of a logical operator
    if (
      this.currentChar === "N" ||
      this.currentChar === "O" ||
      this.currentChar === "R"
    ) {
      result += this.currentChar;
      this.advance();

      // check if there is an extra character for AND and OR
      if (
        (result === "AN" && this.currentChar === "D") ||
        (result === "NO" && this.currentChar === "T")
      ) {
        result += this.currentChar;
        this.advance();
      }
    }

    return new Token(result);
  }

  getString() {
    let result = "";
    this.tokens.push(new Token("'")); // Push the opening quote
    // console.log(new Token("'"));
    this.advance();

    while (
      this.currentChar !== null &&
      this.currentChar !== "'" &&
      this.currentChar !== '"'
    ) {
      result += this.currentChar;
      this.advance();
    }

    // console.log(new Token({ type: "keyword", value: result.trim() }));
    this.tokens.push(new Token({ type: "keyword", value: result.trim() })); // Push the string

    // If this space, skip it
    if (this.currentChar === " ") {
      this.advance();
    }

    if (this.currentChar === "'" || this.currentChar === '"') {
      this.advance();
      return new Token("'"); // Push the closing quote
    }
  }

  // Process a keyword (sequence of non-whitespace characters)
  keyword() {
    let result = "";
    let wasPrevCharBackslash = false;

    const specialCharCheck = () => {
      if (!wasPrevCharBackslash && specialCharsToEscape.has(this.currentChar)) {
        return true;
      }
      return false;
    };

    while (/\S/.test(this.currentChar) && this.currentChar !== null) {
      if (this.currentChar === "\\" && wasPrevCharBackslash == false) {
        wasPrevCharBackslash = true;
        this.advance();
        continue;
      }

      if (wasPrevCharBackslash && specialCharsToEscape.has(this.currentChar)) {
        result += "\\" + this.currentChar;
        wasPrevCharBackslash = false;
      } else if (specialCharCheck()) {
        return result;
      } else if (isAlphanumeric(this.currentChar)) {
        if (
          // If the current character is a number and the previous result is a number or null
          isNumeric(this.currentChar) &&
          (isNumeric(result) || result === "")
        ) {
          let res = this.number();
          if (this.text[this.position] === " " || !this.text[this.position])
            return res;
          else {
            result += res;
            continue;
          }
        }
        result += this.currentChar;
      }
      this.advance();
    }

    let tokenType = new Token(result).type;
    return tokenType == "TT_TAG" ||
      tokenType == "TT_METRIC" ||
      tokenType == "TT_NUMERIC_TAG"
      ? new Token(result)
      : new Token({ type: "keyword", value: result });
  }

  // Get the next token from the input
  getNextToken() {
    try {
      while (this.currentChar !== null) {
        switch (this.currentChar) {
          case " ":
            this.advance();
            return new Token(this.text[this.position - 1]);
          case "+":
            this.advance();
            return new Token(this.text[this.position - 1]);

          case "-":
            this.advance();
            return new Token(this.text[this.position - 1]);

          case ":":
            this.advance();
            return new Token(this.text[this.position - 1]);

          case "~":
            this.advance();
            return new Token(this.text[this.position - 1]);

          case "(":
            this.advance();
            return new Token(this.text[this.position - 1]);

          case ")":
            this.advance();
            return new Token(this.text[this.position - 1]);

          case '"':
          case "'":
            return this.getString();

          case "A":
          case "O":
          case "N":
            return this.logicalOperator();

          case "=":
            this.advance();
            if (this.text[this.position] === "=") {
              this.advance();
              return new Token("==");
            }
            return new Token("=");

          case "<":
            this.advance();
            if (this.text[this.position] === "=") {
              this.advance();
              return new Token("<=");
            }
            return new Token("<");

          case ">":
            this.advance();
            if (this.text[this.position] === "=") {
              this.advance();
              return new Token(">=");
            }
            return new Token(">");

          default:
            const keyword = this.keyword();

            if (keyword instanceof Token) {
              return keyword;
            }

            return new Token(keyword).type == "TT_UNKNOWN"
              ? new Token({
                  type: "keyword",
                  value: keyword,
                })
              : new Token(keyword);
        }
      }

      return new Token("EOF"); // End Of File token
    } catch (error) {
      this.handleError(
        "illegalCharacter",
        `Invalid character ${this.currentChar} at position ${this.position}`
      );
    }
  }

  // Get all tokens from the input until the end
  makeTokens() {
    try {
      // console.log(this.text);
      let token = this.getNextToken();
      // console.log(token);
      while (token.type !== "TT_EOF") {
        this.tokens.push(token);
        token = this.getNextToken();
        // console.log(token);
      }

      if (token.type === "TT_EOF") {
        this.tokens.push(token);
      }

      this.cleanWhitespace();

      // console.log("-----------------------------------------");
      // this.tokens.forEach((token, index) => {
      // console.log("Token: ", token, "Index: ", index);
      // });

      return this.tokens; // Returns all tokens except the final EOF
    } catch (error) {
      // Handle the error
      console.error(error.toString());
    }
  }

  // Clean the whitespaces
  trimAndReduceWhitespace(text) {
    return text.replace(/\s+/g, " ").trim();
  }

  cleanWhitespace() {
    let noSpaceAfter = [
      "TT_FUZZ",
      "TT_PLUS",
      "TT_MINUS",
      "TT_LPARANTH",
      "TT_METRIC",
      "TT_TAG",
    ];
    let noSpaceBefore = ["TT_RPARANTH"];
    let noSpaceAround = [
      "TT_LOGICAL_OPERATOR",
      "TT_COMPARISON_OPERATOR",
      "TT_ASSIGNMENT_OPERATOR",
    ];

    let cleanedTokens = [];

    for (let i = 0; i < this.tokens.length; i++) {
      let prevToken = i > 0 ? this.tokens[i - 1] : null;
      let nextToken = i < this.tokens.length - 1 ? this.tokens[i + 1] : null;

      if (this.tokens[i].value === " ") {
        if (
          (nextToken &&
            (noSpaceBefore.includes(nextToken.type) ||
              noSpaceAround.includes(nextToken.type))) ||
          (prevToken &&
            (noSpaceAfter.includes(prevToken.type) ||
              noSpaceAround.includes(prevToken.type)))
        ) {
          continue;
        }
      }
      cleanedTokens.push(this.tokens[i]);
    }

    this.tokens = cleanedTokens;
  }
}

const isNumeric = (str) => {
  return /^[0-9]+$/.test(str);
};

const isAlphanumeric = (str) => {
  return /^[a-zA-Z0-9.]+$/.test(str);
};

module.exports = Lexer;

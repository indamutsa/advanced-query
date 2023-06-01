const Token = require("./token.js");
const { getTokenType, TT_KEYWORD } = require("./validTokens.js");

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
]);

class Lexer {
  constructor(text) {
    this.text = text; // The input text
    this.position = 0; // The current position in the text
    this.currentChar = this.text[this.position]; // The current character
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

  // Skip any whitespace characters
  skipWhitespace() {
    while (this.currentChar === " ") {
      this.advance();
    }
  }

  // Process a number (sequence of digits)
  number() {
    let result = "";
    while (this.currentChar !== null && !isNaN(this.currentChar)) {
      result += this.currentChar;
      this.advance();
    }
    return result;
  }

  // Process a keyword (sequence of non-whitespace characters)
  keyword() {
    let result = "";
    let wasPrevCharBackslash = false;

    if (this.currentChar !== null) {
      while (/\S/.test(this.currentChar) && this.currentChar !== null) {
        if (this.currentChar === "\\" && !wasPrevCharBackslash) {
          wasPrevCharBackslash = true;
        } else {
          if (
            wasPrevCharBackslash &&
            specialCharsToEscape.has(this.currentChar)
          ) {
            // If it was a backslash and the current character is a special char
            result += "\\" + this.currentChar;
            wasPrevCharBackslash = false;
          } else if (
            !wasPrevCharBackslash &&
            specialCharsToEscape.has(this.currentChar)
          ) {
            // If there wasn't a backslash and the current character is a special char
            return result;
          } else if (/[a-zA-Z0-9]/.test(this.currentChar)) {
            // If it's alphanumeric, add to result
            result += this.currentChar;
          }
        }

        this.advance();
      }

      return new Token({ type: "keyword", value: result });
    }
  }

  // Get the next token from the input
  getNextToken() {
    while (this.currentChar !== null) {
      switch (this.currentChar) {
        case " ":
          this.skipWhitespace();
          return new Token(this.currentChar);

        case "+":
          this.advance();
          return new Token(this.currentChar);

        case "-":
          this.advance();
          return new Token(this.currentChar);

        case ":":
          this.advance();
          return new Token(this.currentChar);

        case "~":
          this.advance();
          return new Token(this.currentChar);

        case "(":
          this.advance();
          return new Token(this.currentChar);

        case ")":
          this.advance();
          return new Token(this.currentChar);

        case '"':
        case "'":
          this.advance();
          return new Token(this.currentChar);

        case "A":
        case "O":
        case "N":
          this.advance();
          return new Token(this.currentChar);

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
          return keyword?.type === "TT_KEYWORD" ? keyword : new Token(keyword);
      }
    }

    return new Token("EOF"); // End Of File token
  }

  // Get all tokens from the input until the end
  makeTokens() {
    let tokens = [];
    let token = this.getNextToken();
    console.log(token);
    while (token.type !== "TT_EOF") {
      tokens.push(token);
      token = this.getNextToken();
      console.log(token);
    }

    if (token.type === "TT_EOF") {
      tokens.push(token);
    }

    return tokens; // Returns all tokens except the final EOF
  }
}

module.exports = Lexer;

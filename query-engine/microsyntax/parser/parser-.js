// Since we are buiding a parser, we need to define nodes for the AST.
const { InvalidToken } = require("../error/error");

// THe number node
class Node {
  constructor(token) {
    this.token = token;
  }

  toString() {
    return `Node =-> : (${this.token.value})`;
  }
}

class TagNode {
  constructor(tag = null, colon = null, value = null) {
    this.tag = tag;
    this.colon = colon;
    this.value = value;
  }

  toString() {
    return `Tag =-> : (${this.tag}), Colon: (${this.colon}), Value: (${this.value})`;
  }
}

class MetricNode {
  constructor(metric = null, operator = null, value = null) {
    this.metric = metric;
    this.operator = operator;
    this.value = value;
  }

  toString() {
    return `Metric =-> : (${this.metric}), Operator: (${this.operator}), Value: (${this.value})`;
  }
}

class ExactKeywordNode {
  constructor(startingQuote, str, endingQuote) {
    this.startingQuote = startingQuote;
    this.str = str;
    this.endingQuote = endingQuote;
  }

  toString() {
    return `ExactKeyword =-> : (StartingQuote: ${this.startingQuote}, Str: ${this.str}, EndingQuote: ${this.endingQuote})`;
  }
}

// The binary operator node
class BinaryOperatorNode {
  constructor(left, operator, right) {
    this.left = left;
    this.operator = operator;
    this.right = right;
  }

  toString() {
    return `Binary Operator Node, Left: (${this.left}), Operator: (${this.operator}), Right: (${this.right})`;
  }
}

class Parser {
  constructor(tokens) {
    this.tokens = tokens;
    this.token_index = -1;
    this.currentToken = null;
    this.operators = [
      "TT_AND",
      "TT_OR",
      "TT_NOT",
      "TT_SPACE",
      "TT_COLON",
      "TT_GREATER_THAN",
      "TT_LESS_THAN",
      "TT_EQUAL",
      "TT_GREATER_THAN_EQUAL",
      "TT_LESS_THAN_EQUAL",
    ];
    this.metricsOp = [
      "TT_GREATER_THAN",
      "TT_LESS_THAN",
      "TT_EQUAL",
      "TT_GREATER_THAN_EQUAL",
      "TT_LESS_THAN_EQUAL",
    ];
    this.advance();
  }

  advance() {
    // Check if the token at the start and at the end are valid
    this.token_index++;
    this.currentToken = this.tokens[this.token_index];
    this.checkIfValidToken();
    return this.currentToken;
  }

  checkIfValidToken() {
    if (this.token_index === 0) {
      if (
        ![
          "TT_SPACE",
          "TT_LBRAKET",
          "TT_RBRAKET",
          "TT_KEYWORD",
          "TT_NUMBER",
          "TT_TAG",
        ].includes(this.currentToken.type)
      ) {
        return new InvalidToken(
          this.currentToken,
          this.token_index,
          "Invalid starting token!"
        );
      }
    }

    if (
      ["TT_AND", "TT_OR", "TT_NOT"].includes(
        this.tokens[this.tokens.length - 2].type
      )
    ) {
      return new InvalidToken(
        this.tokens[this.tokens.length - 2],
        this.token_index,
        "Invalid ending token!"
      );
    }
  }

  parse() {
    let res = this.term();
    let { _, error } = res;

    if (error) return { result: null, error };
    if (this.currentToken.type !== "TT_EOF")
      return {
        result: null,
        error: new InvalidToken(
          this.currentToken,
          this.token_index,
          "Invalid ending or misplaced token!"
        ),
      };

    return res;
  }

  term() {
    let leftNode = this.factor();
    if (isInstanceOf(leftNode, InvalidToken))
      return { result: null, error: leftNode };

    while (this.operators.includes(this.currentToken.type)) {
      if (
        this.metricsOp.includes(this.currentToken.type) &&
        this.tokens[this.token_index + 1].type !== "TT_NUMBER"
      ) {
        return new InvalidToken(
          this.currentToken,
          this.token_index,
          "Conditional statement can be followed by a number!"
        );
      }
      let operator_token = this.currentToken;
      this.advance();

      let rightNode = this.factor();
      if (isInstanceOf(rightNode, InvalidToken))
        return { result: null, error: rightNode };
      leftNode = new BinaryOperatorNode(leftNode, operator_token, rightNode);
    }
    return { result: leftNode, error: null };
  }

  factor() {
    let token = this.currentToken;

    // Return a keyword node, it is the atomic unit of the parser
    if (token.type === "TT_NUMBER" || token.type === "TT_KEYWORD") {
      this.advance();
      return new Node(token);
    }
    // Return a tag node, it extracts the tag, colon and the value
    else if (token.type === "TT_TAG") {
      const tagNode = new TagNode();
      tagNode.tag = token;
      this.advance();

      if (this.currentToken.type === "TT_COLON") {
        tagNode.colon = this.currentToken;
        this.advance();
      } else
        return new InvalidToken(
          this.currentToken,
          this.token_index,
          "Expected colon!"
        );

      let value = this.getTagValue();
      if (isInstanceOf(value, InvalidToken))
        return { result: null, error: value };
      tagNode.value = value.result;
      return tagNode;
      // return new Node(token);
    }
    // Return a metric node, it extracts the metric, operator and the value
    else if (token.type === "TT_LBRAKET") {
      this.advance();
      // this.currentToken.value = "(" + this.currentToken.value;
      let node = this.term();
      node.paranthLeft = "(";
      if (isInstanceOf(node, InvalidToken))
        return { result: null, error: node };

      if (this.currentToken.type === "TT_RBRAKET") {
        node.paranthRight = ")";
      } else
        return new InvalidToken(
          this.currentToken,
          this.token_index,
          "Expected closing bracket!"
        );

      // this.currentToken = this.currentToken.value + ")";
      this.advance();

      return node;
    }
    // Return a metric node, it extracts the metric, operator and the value
    else if (token.type === "TT_METRIC") {
      let metric = token.value;
      let operator = null;
      let value = null;
      this.advance();
      if (this.metricsOp.includes(this.currentToken.type)) {
        operator = this.currentToken.value;
        this.advance();

        if (this.currentToken.type === "TT_NUMBER") {
          value = this.currentToken.value;
          this.advance();
          return new MetricNode(metric, operator, value);
        } else
          return new InvalidToken(
            this.currentToken,
            this.token_index,
            "Expected number!"
          );
      } else
        return new InvalidToken(
          this.currentToken,
          this.token_index,
          "Expected conditional operator!"
        );
    }
    // Return the exact match when defined, the string is enclosed in single quotes
    else if (token.type === "TT_QUOTE") {
      let startingQuote = "'";
      let str = "";
      this.advance();
      while (this.currentToken.type !== "TT_QUOTE") {
        str += this.currentToken.value;
        this.advance();
      }

      if (str.charAt(str.length - 1) === " ") str = str.slice(0, -1);

      let endingQuote = "'";
      this.advance();
      return new ExactKeywordNode(startingQuote, str, endingQuote);
    } else
      return new InvalidToken(
        this.currentToken,
        this.token_index,
        "Misplaced Token, please chech the syntax!"
      );
  }

  // A tag value can be a keyword, a number or an exact match, and can be grouped together. The get tag value function
  // ensures that the tag value is extracted correctly
  // But we have to ensure only considers keywords, numbers and exact matches when grouping....
  getTagValue() {
    let token = this.currentToken;
    if (token.type === "TT_NUMBER" || token.type === "TT_KEYWORD") {
      this.advance();
      return { result: new Node(token), error: null };
    } else if (token.type === "TT_QUOTE") {
      let startingQuote = "'";
      let str = "";
      this.advance();
      while (this.currentToken.type !== "TT_QUOTE") {
        str += this.currentToken.value;
        this.advance();
      }

      if (str.charAt(str.length - 1) === " ") str = str.slice(0, -1);

      let endingQuote = "'";
      this.advance();
      return {
        result: new ExactKeywordNode(startingQuote, str, endingQuote),
        error: null,
      };
    } else if (token.type === "TT_LBRAKET") {
      this.advance();
      let node = this.term();
      if (isInstanceOf(node, InvalidToken))
        return { result: null, error: node };

      if (this.currentToken.type !== "TT_RBRAKET") {
        return new InvalidToken(
          this.currentToken,
          this.token_index,
          "Expected closing bracket!"
        );
      }
      this.advance();
      return node;
    } else
      return new InvalidToken(
        this.currentToken,
        this.token_index,
        "Misplaced Token, please chech the syntax!"
      );
  }
}

function isInstanceOf(obj, instance) {
  return obj instanceof instance;
}

module.exports = {
  Parser,
  BinaryOperatorNode,
  Node,
  TagNode,
  MetricNode,
  ExactKeywordNode,
};

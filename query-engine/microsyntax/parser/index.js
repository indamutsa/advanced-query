// Since we are buiding a parser, we need to define nodes for the AST.
const { InvalidToken } = require("../error/error");
const {
  VALID_ASSIGNMENT_OPERATORS,
  VALID_COMPARISON_OPERATORS,
  tokenTypes,
  getTokenType,
  VALID_LOGICAL_OPERATORS,
} = require("../lexer/validTokens");

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
  constructor(tag = null, assignOp = null, value = null) {
    this.tag = tag;
    this.assignOp = assignOp;
    this.value = value;
  }

  toString() {
    return `Tag =-> : (${this.tag}), Assignment_Operator: (${this.assignOp}), Value: (${this.value})`;
  }
}

class MetricNode {
  constructor(metric = null, comparOp = null, value = null) {
    this.metric = metric;
    this.comparOp = comparOp;
    this.value = value;
  }

  toString() {
    return `Metric =-> : (${this.metric}), Comparison_Opertor: (${this.comparOp}), Value: (${this.value})`;
  }
}

class ExactKeywordNode {
  constructor(startingQuote, keyword, endingQuote) {
    this.startingQuote = startingQuote;
    this.keyword = keyword;
    this.endingQuote = endingQuote;
  }

  toString() {
    return `ExactKeyword =-> : (StartingQuote: ${this.startingQuote}, Keyword: ${this.keyword}, EndingQuote: ${this.endingQuote})`;
  }
}

// The binary operator node
class BinaryOperatorNode {
  constructor(left, logicalOp, right) {
    this.left = left;
    this.logicalOp = logicalOp;
    this.right = right;
  }

  toString() {
    return `Binary Operator Node, Left: (${this.left}), Logical_Operator: (${this.logicalOp}), Right: (${this.right})`;
  }
}

class Parser {
  constructor(tokens) {
    this.tokens = tokens;
    this.token_index = -1;
    this.currentToken = null;
    this.logicalOperators = VALID_LOGICAL_OPERATORS;
    this.comparisonOperators = VALID_COMPARISON_OPERATORS;
    this.assignmentOperator = VALID_ASSIGNMENT_OPERATORS;

    this.advance();
  }

  advance() {
    // Check if the token at the start and at the end are valid
    this.token_index++;
    this.currentToken = this.tokens[this.token_index];
    let check = this.checkIfValidToken();
    // console.log(check);
    return this.currentToken;
  }

  checkIfValidToken() {
    if (this.token_index === 0) {
      if (
        !getTokenType(this.currentToken.value) ||
        this.currentToken.type === "TT_UNKNOWN"
      ) {
        return new InvalidToken(
          this.currentToken,
          this.token_index,
          "Invalid starting token!"
        );
      }
    }

    if (
      this.logicalOperators.has(
        this.tokens[this.tokens.length - 2].type ||
          this.comparisonOperators.has(
            this.tokens[this.tokens.length - 2].value
          )
      )
    ) {
      return new InvalidToken(
        this.tokens[this.tokens.length - 2],
        this.token_index,
        "Invalid ending token!"
      );
    }

    return "Passed!!!";
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
    // console.log(leftNode);

    if (isInstanceOf(leftNode, InvalidToken))
      return { result: null, error: leftNode };

    while (this.currentToken.type == "TT_LOGICAL_OPERATOR") {
      if (
        this.comparisonOperators.has(this.currentToken.value) &&
        this.tokens[this.token_index + 1].type !== "TT_NUMBER"
      ) {
        return new InvalidToken(
          this.currentToken,
          this.token_index,
          "Conditional statement can be followed by a number!"
        );
      }
      let operator_token = this.currentToken;
      //console.log(operator_token);
      this.advance();

      let rightNode = this.factor();
      // console.log(rightNode);
      if (isInstanceOf(rightNode, InvalidToken))
        return new InvalidToken(
          this.currentToken,
          this.token_index,
          "Something wrong with the right node!!"
        );
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
    // Return a tag node, it extracts the tag, assignment op and the value
    else if (token.type === "TT_TAG") {
      const tagNode = new TagNode();
      tagNode.tag = token;
      this.advance();

      if (this.currentToken.type === "TT_ASSIGNMENT_OPERATOR") {
        tagNode.assignOp = this.currentToken;
        this.advance();
      } else
        return new InvalidToken(
          this.currentToken,
          this.token_index,
          "Expected assignment operator!"
        );

      let value = this.getTagValue();
      if (isInstanceOf(value, InvalidToken))
        return new InvalidToken(
          this.currentToken,
          this.token_index,
          "Expected closing paranthesis!"
        );
      tagNode.value = value.result;
      return tagNode;
      // return new Node(token);
    }
    // Return a tag node, it extracts the tag, comparison op and the value
    else if (token.type === "TT_NUMERIC_TAG") {
      const tagNode = new TagNode();
      tagNode.tag = token;
      this.advance();

      if (
        this.currentToken.type === "TT_COMPARISON_OPERATOR" ||
        this.currentToken.type === "TT_ASSIGNMENT_OPERATOR"
      ) {
        tagNode.assignOp = this.currentToken;
        this.advance();
      } else
        return new InvalidToken(
          this.currentToken,
          this.token_index,
          "Expected assignment operator OR comparison operator!"
        );

      let value = this.getTagValue();
      if (
        isInstanceOf(value, InvalidToken) &&
        value.result.type !== "TT_NUMBER"
      )
        return new InvalidToken(
          this.currentToken,
          this.token_index,
          "Expected closing paranthesis!"
        );

      tagNode.value = value.result;
      return tagNode;
      // return new Node(token);
    }
    // Return a metric node, it extracts the metric, operator and the value
    else if (token.type === "TT_LPARANTH") {
      this.advance();
      // this.currentToken.value = "(" + this.currentToken.value;
      let node = this.term();
      node.paranthLeft = "(";
      if (isInstanceOf(node, InvalidToken))
        return new InvalidToken(
          this.currentToken,
          this.token_index,
          "Invalid node after LPRARANTH!"
        );

      if (this.currentToken.type === "TT_RPARANTH") {
        node.paranthRight = ")";
      } else
        return new InvalidToken(
          this.currentToken,
          this.token_index,
          "Expected closing paranthesis!"
        );

      // this.currentToken = this.currentToken.value + ")";
      this.advance();

      return node;
    }
    // Return a metric node, it extracts the metric, operator and the value
    else if (token.type === "TT_METRIC") {
      let metric = token.value;
      let compOperator = null;
      let value = null;
      this.advance();
      if (
        this.comparisonOperators.has(this.currentToken.value) ||
        this.currentToken.type === "TT_ASSIGNMENT_OPERATOR"
      ) {
        compOperator = this.currentToken.value;
        this.advance();

        if (this.currentToken.type === "TT_NUMBER") {
          value = this.currentToken.value;
          this.advance();
          return new MetricNode(metric, compOperator, value);
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
      let keyword = "";
      this.advance();
      while (this.currentToken.type !== "TT_QUOTE") {
        keyword += this.currentToken.value;
        this.advance();
      }

      let endingQuote = "'";
      this.advance();

      return new ExactKeywordNode(startingQuote, keyword, endingQuote);
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

      let endingQuote = "'";
      this.advance();
      return {
        result: new ExactKeywordNode(startingQuote, str, endingQuote),
        error: null,
      };
    } else if (token.type === "TT_LPARANTH") {
      this.advance();
      let node = this.term();
      if (isInstanceOf(node, InvalidToken))
        return new InvalidToken(
          this.currentToken,
          this.token_index,
          "Invalid node after TT_LPARANTH!"
        );

      if (this.currentToken.type !== "TT_RPARANTH") {
        return new InvalidToken(
          this.currentToken,
          this.token_index,
          "Expected closing paranthesis!"
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

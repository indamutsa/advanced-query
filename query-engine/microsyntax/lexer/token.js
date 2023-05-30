// Define your token types somewhere in your code.
let tokenTypes = {
    LOGICAL_OPERATOR: 'TT_LOGICAL_OPERATOR',
    COMPARISON_OPERATOR: 'TT_COMPARISON_OPERATOR',
    ASSIGNMENT_OPERATOR: 'TT_ASSIGNMENT_OPERATOR',
    NUMBER: 'TT_NUMBER',
    KEYWORD: 'TT_KEYWORD',
    METRIC: 'TT_METRIC',
    SPACE: 'TT_SPACE',
    TAG: 'TT_TAG',
    QUOTE: 'TT_QUOTE',
    FUZZ: 'TT_FUZZ',
    PLUS: 'TT_PLUS',
    MINUS: 'TT_MINUS',
    EOF: 'TT_EOF',
  };
  
  // Token class
  class Token {
    constructor(type, value) {
      if (!Object.values(tokenTypes).includes(type)) {
        throw new Error(`Invalid token type: ${type}`);
      }
  
      this.type = type;
      this.value = value;
    }
  
    toString() {
      return `Token >> Type: ${this.type}, Value: ${this.value}`;
    }
  }
  
  module.exports = Token;
  
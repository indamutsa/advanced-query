import { tokenTypes } from './tokenTypes';

// Define your token types somewhere in your code.
let tokenTypes = {
    TT_LOGICAL_OPERATOR: tokenTypes.VALID_LOGICAL_OPERATORS,
    TT_COMPARISON_OPERATOR: tokenTypes.VALID_COMPARISON_OPERATORS,
    TT_ASSIGNMENT_OPERATOR: tokenTypes.VALID_ASSIGNMENT_OPERATORS,
    TT_NUMBER: 'TT_NUMBER',
    TT_KEYWORD: 'TT_KEYWORD',
    TT_METRIC: 'TT_METRIC',
    TT_SPACE: 'TT_SPACE',
    TT_TAG: 'TT_TAG',
    TT_QUOTE: 'TT_QUOTE',
    TT_FUZZ: 'TT_FUZZ',
    TT_PLUS: 'TT_PLUS',
    TT_MINUS: 'TT_MINUS',
    TT_EOF: 'TT_EOF',
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
  
import {  VALID_QUOTES,
  VALID_METRICS,
  VALID_TAGS,
  VALID_LOGICAL_OPERATORS,
  VALID_COMPARISON_OPERATORS,
  VALID_ASSIGNMENT_OPERATORS} from './validTokens.js';

// Define your token types somewhere in your code.
let TokenTypes = {
  LOGICAL_OPERATOR: { token: 'TT_LOGICAL_OPERATOR', value: VALID_LOGICAL_OPERATORS },
  COMPARISON_OPERATOR: { token: 'TT_COMPARISON_OPERATOR', value: VALID_COMPARISON_OPERATORS },
  ASSIGNMENT_OPERATOR: { token: 'TT_ASSIGNMENT_OPERATOR', value: VALID_ASSIGNMENT_OPERATORS },
  NUMBER: { token: 'TT_NUMBER', value: /\d+/ },
  KEYWORD: { token: 'TT_KEYWORD', value: '' },
  METRIC: { token: 'TT_METRIC', value: VALID_METRICS },
  SPACE: { token: 'TT_SPACE', value: ' ' },
  TAG: { token: 'TT_TAG', value: VALID_TAGS },
  QUOTE: { token: 'TT_QUOTE', value: VALID_QUOTES },
  FUZZ: { token: 'TT_FUZZ', value: '~' },
  PLUS: { token: 'TT_PLUS', value: '+' },
  MINUS: { token: 'TT_MINUS', value: '-' },
  EOF: { token: 'TT_EOF', value: '' },
};

  
// Token class
class Token {
  constructor(type, value) {
    if (!Object.keys(TokenTypes).some((key) => TokenTypes[key].token === type)) {
      throw new Error(`Invalid token type: ${type}`);
    }

    this.type = type;
    this.value = value;
  }

  toString() {
    return `Token >> Type: ${this.type}, Value: ${this.value}`;
  }
}

  
module.exports = {
  Token, TokenTypes,  
  };
  
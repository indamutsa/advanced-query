// Import the necessary functions and values from 'validTokens' module
const { getTokenType, tokenTypes, TT_KEYWORD } = require("./validTokens");

// Define the Token class
class Token {
  // Constructor for the Token class that takes a value as argument
  constructor(keywordValue) {
    // Get the type of the token using the imported 'getTokenType' function
    let type =
      keywordValue?.type == "keyword" ? TT_KEYWORD : getTokenType(keywordValue);

    let value = keywordValue?.value ? keywordValue.value : keywordValue;

    // Convert the token types values into a Set for efficient lookups
    const tokenTypesSet = new Set(Object.values(tokenTypes));

    // If the type is not in the set of token types, throw an error
    if (!tokenTypesSet.has(type)) {
      throw new Error(`Invalid token type: ${type}`);
    }

    // Set the type and value of the Token instance
    this.type = type;
    this.value = value;
  }

  // Define a method to convert the Token instance into a string representation
  toString() {
    return `Token >> Type: ${this.type}, Value: ${this.value}`;
  }
}

// Export the Token class
module.exports = Token;

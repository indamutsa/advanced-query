class IllegalCharacterError {
    constructor(currentChar, position, message) {
        this.message = message;
        this.currentChar = currentChar;
        this.position = position;
    }

    toString() {
        return `Error >> Message: Error at current char: ${this.currentChar} on position: ${this.position} with message: ${this.message}`;
    }
}

class InvalidToken {
    constructor(token, tokenIndex, message) {
        this.token = token;
        this.tokenIndex = tokenIndex;
        this.message = message;
    }

    toString() {
        return `Invalid token: { Token type: ${this.token.type}, on position: ${this.position} with message: ${this.message}`;
    }
}

module.exports = { IllegalCharacterError, InvalidToken };
// Let us define the lexer for the query language.
// The lexer is a state machine that takes a string as input and
// produces a stream of tokens as output.
// The lexer is implemented as a generator function that yields
// tokens one by one.
const axios = require('axios');
const { IllegalCharacterError } = require('../error/error.js');
const {
    skipTokens,
    metrics,
    tags
} = require('./constants.js')
const Token = require('./token.js');
class Lexer {
    constructor(input) {
        this.input = input;
        this.pos = -1;
        this.currentChar = null;
        this.advance();
        this.tokens = [];
    }

    advance() {
        this.pos++;
        this.currentChar = this.pos < this.input.length ? this.input[this.pos] : null;
    }

    makeTokens() {
        // with switch statement
        while (this.currentChar !== null) {
            switch (this.currentChar) {
                case '\t':
                    this.advance();
                    break;
                case ' ':
                    if (skipTokens.includes(this.tokens[this.tokens.length - 1]?.type))
                        this.tokens.push(new Token('TT_SPACE', ' '))
                    this.advance();
                    break;
                case '[':
                    this.tokens.push(new Token('TT_LBRAKET', '['));
                    this.advance();
                    break;
                case ']':
                    this.tokens.push(new Token('TT_RBRAKET', ']'));
                    this.advance();
                    break;
                case '=':
                    this.advance();
                    if (this.currentChar === '=') {
                        this.tokens.push(new Token('TT_EQUAL', '=='));
                        this.advance();
                    }
                    break;
                case '<':
                    this.advance();
                    if (this.currentChar === '=') {
                        this.tokens.push(new Token('TT_LESS_THAN_EQUAL', '<='));
                        this.advance();
                    } else {
                        this.tokens.push(new Token('TT_LESS_THAN', '<'));

                    }
                    break;
                case '>':
                    this.advance();
                    if (this.currentChar === '=') {
                        this.tokens.push(new Token('TT_GREATER_THAN_EQUAL', '>='));
                        this.advance();
                    } else {
                        this.tokens.push(new Token('TT_GREATER_THAN', '>'));

                    }
                    break;

                // case '~':
                //     this.tokens.push(new Token('TT_FUZZ', '~'));
                //     this.advance();
                //     break;
                case ':':
                    this.tokens.push(new Token("TT_COLON", ':'));
                    this.advance();
                    break;
                case '"':
                case "'":
                    this.tokens.push(new Token("TT_QUOTE", "'"));
                    this.advance();
                    break;
                case 'A':
                    if (this.checkStringEquality('AND')) {
                        this.tokens.push(new Token("TT_AND", 'AND'));
                        this.advance();
                    } else {
                        let keyword = this.makeAkeyword();
                        if (keyword instanceof IllegalCharacterError)
                            return keyword;
                        this.tokens.push(new Token('TT_KEYWORD', keyword));
                    }
                    break;
                case 'O':
                    if (this.checkStringEquality('OR')) {
                        this.tokens.push(new Token("TT_OR", 'OR'));
                        this.advance();
                    } else {
                        let keyword = this.makeAkeyword();
                        if (keyword instanceof IllegalCharacterError)
                            return keyword;
                        this.tokens.push(new Token('TT_KEYWORD', keyword));
                    }
                    break;
                case 'N':
                    if (this.checkStringEquality('NOT')) {
                        this.tokens.push(new Token("TT_NOT", 'NOT'));
                        this.advance();
                    } else {
                        let keyword = this.makeAkeyword();
                        if (keyword instanceof IllegalCharacterError)
                            return keyword;
                        this.tokens.push(new Token('TT_KEYWORD', keyword));
                    }
                    break;
                default:
                    if (this.currentChar.match(/[0-9]/)) {
                        let number = this.makeNumberToken();
                        if (number instanceof IllegalCharacterError)
                            return number;
                        this.tokens.push(new Token("TT_NUMBER", number));
                        // this.advance();
                    }
                    else if (this.currentChar.match(/[\w\d\,\.\/\;\%\|\`\?\"\+\&\|\!\(\)\{\}\^\"\~\*\?\\\-]/)) {
                        let keyword = this.makeAkeyword();
                        if (keyword instanceof IllegalCharacterError)
                            return keyword;

                        if (tags.includes(keyword)) {
                            let token = this.tokens[this.tokens.length - 1];
                            if (token?.type === 'TT_QUOTE')
                                this.tokens.push(new Token('TT_KEYWORD', keyword));
                            else
                                this.tokens.push(new Token('TT_TAG', keyword));
                        }
                        else if (metrics.includes(keyword))
                            this.tokens.push(new Token('TT_METRIC', keyword));
                        else
                            this.tokens.push(new Token('TT_KEYWORD', keyword));
                        // this.advance();
                    }
                    else {
                        return new Token('TT_ERROR',
                            new IllegalCharacterError(
                                this.currentChar, this.pos, `Invalid character! >> ${this.currentChar} <<`));
                    }
                    break;
            }
        }

        this.tokens.push(new Token('TT_EOF', null));
        this.tokensFixer();

        return this.tokens;
    }

    tokensFixer() {
        let i = 0;
        while (i < this.tokens.length) {
            if (this.tokens[i].type === 'TT_SPACE') {
                if (['TT_RBRAKET', 'TT_EOF', 'TT_AND', 'TT_OR', 'TT_NOT', 'TT_COLON', 'TT_GREATER_THAN', 'TT_LESS_THAN'].includes(this.tokens[i + 1].type)) {
                    this.tokens.splice(i, 1);
                    continue;
                }
                // if (this.tokens[i].type === 'TT_SPACE') {
                //     if (this.tokens[i + 1].type === 'TT_RBRAKET' || this.tokens[i + 1].type === 'TT_EOF') {
                //         this.tokens.splice(i, 1);
                //         continue;
                //     }
                // else if (this.tokens[i - 1].type === 'TT_QUOTE') {
                //     this.tokens.splice(i, 1);
                //     continue;
                // }
            }
            i += 1;
        }

    }

    makeNumberToken() {
        let number = '';
        let dot_count = 0;

        // We are checking for a number with a decimal point
        while (this.currentChar !== null && this.currentChar.match(/[0-9\.]/)) {
            if (this.currentChar === '.') {
                if (dot_count === 1) {
                    return new IllegalCharacterError(
                        this.currentChar, this.pos,
                        `Invalid number >> ${this.currentChar} << -- too many decimal points`);
                }
                dot_count += 1;
                number += this.currentChar;
                this.advance();
            }
            else {
                number += this.currentChar;
                this.advance();
            }
        }
        // If we have a dot count less than zero, we have a number
        if ((dot_count === 0 || dot_count === 1) && [' ', ']', null].includes(this.currentChar))
            return number;
        else return new IllegalCharacterError(
            this.currentChar, this.pos,
            `Invalid character in the sequence >> ${this.currentChar} << --`);
    }


    makeAkeyword() {
        let keyword = '';
        while (this.currentChar !== null &&
            this.currentChar.match(/[\w\d\,\.\/\;\%\|\`\?\"\+\&\|\!\(\)\{\}\^\"\=\<\>\~\*\?\\\-]/)) {
            // console.log(this.input);

            if (this.currentChar.match(/[\(\)\{\}\^\"]/) && this.input[this.pos == 0 ? this.pos : this.pos - 1] !== '\\')
                return new IllegalCharacterError(
                    this.currentChar, this.pos,
                    `Invalid character in the sequence >> ${this.currentChar} << --`);

            keyword += this.currentChar;
            this.advance()
        }
        return keyword;
    }

    // We will use to check if the string entered is a predefined tag
    checkStringEquality(target) {
        for (let index = 0; index < target.length; index++) {
            if (this.currentChar === target[index]) {
                this.advance();
            } else {
                this.pos = this.pos - (index + 1);
                this.currentChar = this.input[this.pos];
                this.advance();
                return false;
            }
        }

        if (this.currentChar === " " || this.currentChar === ":" || this.pos === this.input.length)
            return true

        return false;
    }


}
module.exports = { Lexer };


// const functions = {
//     add: (num1, num2) => num1 + num2,
//     isNull: () => null,
//     checkValue: x => x,
//     createUser: () => {
//         const user = { firstName: 'Brad' };
//         user['lastName'] = 'Traversy';
//         return user;
//     },
//     fetchUser: () =>
//         axios
//             .get('https://jsonplaceholder.typicode.com/users/1')
//             .then(res => res.data)
//             .catch(err => 'error')
// };



// case 'c':
//     if (this.checkStringEquality('conformsTo')) {
//         this.tokens.push(new Token("TT_TAG", 'conformsTo'));
//     } else {
//         let keyword = this.makeAkeyword();
//         if (keyword instanceof Token)
//             return keyword;
//         this.tokens.push(new Token('TT_KEYWORD', keyword));
//     }
//     break;
// case 'h':
//     if (this.checkStringEquality('hasAttribute')) {
//         this.tokens.push(new Token("TT_TAG", 'hasAttribute'));
//     } else {
//         let keyword = this.makeAkeyword();
//         if (keyword instanceof Token)
//             return keyword;
//         this.tokens.push(new Token('TT_KEYWORD', keyword));
//     }
//     break;
// case 'i':
//     if (this.checkStringEquality('isTransformable')) {
//         this.tokens.push(new Token("TT_TAG", 'isTransformable'));
//     } else {
//         let keyword = this.makeAkeyword();
//         if (keyword instanceof Token)
//             return keyword;
//         this.tokens.push(new Token('TT_KEYWORD', keyword));
//     }
//     break;
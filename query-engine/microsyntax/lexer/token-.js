/**
 * We can return a keyword
 * We can return tags
 * conditional statements AND, NOT, OR
 * We can group statements () 
 * 
 * (size < 5000 ) NOT (ext="xmi") OR (CMC == 2 AND AVGTTR <= 2) 
 * conformsTo="unique_name" hasAttribute="name" AND isTransformable="ID"
 */

//Token class
class Token {
    constructor(type, value) {
        this.type = type;
        this.value = value;
    }

    toString() {
        return `Token >> Type: ${this.type}, Value: ${this.value}`;
    }
}

module.exports = Token;
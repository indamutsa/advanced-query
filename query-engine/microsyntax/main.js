const { log } = console;
// Special character /[\'\"\+\&\|\!\(\)\{\}\^\"\~\*\?\:\\\-]/
// Normal character /[\w\d\,\.\/\;\%\|\`\?]/
// Test token class
// const query = "[conformsTo:'id' hasAttribute:'value'] isTransformable:'value' Kirue";
// const query = "hello [world full [another word]]";
// const query = "conformsTo: ' id '";
// const query = "  [   name    :       value  keyword   ] ";
// const query = "amc == 10";
// const query = "name1 name2 mc == 2 hasAttribute:value name:'value2'"
// const query = "name1 AND name2 [ mc == 2 hasAttribute:value] name:'value2'"
// const query = "23[23=="
const query = "23.32 OR    78 AND 99    "

const Token = require("./lexer/token");
const { Lexer } = require("./lexer/lexer");
const { Parser, BinaryOperatorNode } = require("./parser/parser");
let tokens = new Lexer(query).makeTokens();
log(tokens);

if (Array.isArray(tokens)) {
    let parser = new Parser(tokens);
    let { result, error } = parser.parse();

    log(result ? result : error);
} else log(lexer);


function printInorder(node) {
    if (node == null)
        return;

    /* first recur on left child */
    printInorder(node.left);

    /* then print the data of node */
    log(isInstanceOf(node, BinaryOperatorNode) ? node.operator : node.token);

    /* now recur on right child */
    printInorder(node.right);
}

function isInstanceOf(obj, instance) {
    return obj instanceof instance;
}
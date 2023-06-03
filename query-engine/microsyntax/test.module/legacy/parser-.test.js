const { Lexer } = require("../lexer/lexer");
const Token = require("../lexer/token");
const { Parser, BinaryOperatorNode, TagNode, Node } = require("../parser/parser");


// Testing the parser
describe('Testing the parser', () => {

    // Testing if the parse function is defined
    test('Testing if parse is defined', () => {
        // Expecting the parse function to be defined
        let lexer = new Lexer('123');
        let tokens = lexer.makeTokens();
        let parser = new Parser(tokens);
        expect(parser.parse()).toBeDefined();
    });

    // Testing if the parse function returns an object
    test('Testing if parse returns an object', () => {
        // Expecting the parse function to return an object
        let lexer = new Lexer('123');
        let tokens = lexer.makeTokens();
        let parser = new Parser(tokens);
        expect(typeof parser.parse()).toBe('object');
    });

    // Testing if the parse function returns an object with a result property
    test('Testing if parse returns an object with a result property', () => {
        // Expecting the parse function to return an object with a result property
        let lexer = new Lexer('123');
        let tokens = lexer.makeTokens();
        let parser = new Parser(tokens);
        expect(parser.parse().result).toBeDefined();
    });

    // Testing if the parse function returns an object with a error property
    test('Testing if parse returns an object with a error property', () => {
        // Expecting the parse function to return an object with a error property
        let lexer = new Lexer('123');
        let tokens = lexer.makeTokens();
        let parser = new Parser(tokens);
        expect(parser.parse().error).toBeDefined();
    });

    // Testing if the parse function returns the correct result
    test('Testing if parse returns the correct result', () => {
        // Expecting the parse function to return the correct result
        let lexer = new Lexer('keyword1 keyword2  326676  keyword3 name:value');
        let tokens = lexer.makeTokens();
        let parser = new Parser(tokens);
        let { result } = parser.parse();

        // Checking if the result operator is correct
        expect(result.operator.type).toBe('TT_SPACE');

        // Checking if the result left is a binary operator node
        expect(isInstanceOf(result.left, BinaryOperatorNode)).toBe(true);

        // Checking if the result right is a binary operator node
        expect(isInstanceOf(result.right, TagNode)).toBe(true);

        // Checking if the result left left is a binary operator node
        expect(isInstanceOf(result.left.left, BinaryOperatorNode)).toBe(true);

        // Checking if the result left left left is a binary operator node
        expect(isInstanceOf(result.left.left.left, BinaryOperatorNode)).toBe(true);

        // Checking if the result left left left left is a binary operator node
        expect(isInstanceOf(result.left.left.left.left, Node)).toBe(true);


    });

});


function isInstanceOf(obj, instance) {
    return obj instanceof instance;
}
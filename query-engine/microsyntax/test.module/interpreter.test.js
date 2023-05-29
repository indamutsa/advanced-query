const { Lexer } = require("../lexer/lexer");
const Token = require("../lexer/token");
const { Parser, BinaryOperatorNode, TagNode, Node } = require("../parser/parser");
const { Interpreter } = require("../interpreter/interpreter");

// Testing the interpreter
describe('Testing the interpreter', () => {
    // Testing interpreter visit function is defined
    test('Testing if visit is defined', () => {
        // Expecting the visit function to be defined
        const query = ""
        let lexer = new Lexer(query);
        let tokens = lexer.makeTokens();
        let parser = new Parser(tokens);
        let { result } = parser.parse();
        let interpreter = new Interpreter(result);
        expect(interpreter.visit()).toBeDefined();
    });

    // Testing if the visitBinaryOperatorNode function is defined
    test('Testing if visitBinaryOperator is defined', () => {
        // Expecting the visitBinaryOperator function to be defined
        const query = ""
        let lexer = new Lexer(query);
        let tokens = lexer.makeTokens();
        let parser = new Parser(tokens);
        let { result } = parser.parse();
        let interpreter = new Interpreter(result);
        expect(interpreter.visitBinaryOperatorNode).toBeDefined();
    });

    // Testing if the visitTagNode function is defined
    test('Testing if visitTagNode is defined', () => {
        // Expecting the visitTagNode function to be defined
        const query = ""
        let lexer = new Lexer(query);
        let tokens = lexer.makeTokens();
        let parser = new Parser(tokens);
        let { result } = parser.parse();
        let interpreter = new Interpreter(result);
        expect(interpreter.visitTagNode).toBeDefined();
    });

    // Testing if the visitTagNode function is a type of function
    test('Testing if visitTagNode is a type of function', () => {
        // Expecting the visitTagNode function to return an object
        const query = ""
        let lexer = new Lexer(query);
        let tokens = lexer.makeTokens();
        let parser = new Parser(tokens);
        let { result } = parser.parse();
        let interpreter = new Interpreter(result);
        expect(typeof interpreter.visitTagNode).toBe('function');
    });

    // Testing if the visitMetricNode function is a type of function
    test('Testing if visitMetricNode is a type of function', () => {
        // Expecting the visitMetricNode function to return an object
        const query = ""
        let lexer = new Lexer(query);
        let tokens = lexer.makeTokens();
        let parser = new Parser(tokens);
        let { result } = parser.parse();
        let interpreter = new Interpreter(result);
        expect(typeof interpreter.visitMetricNode).toBe('function');
    });


    // Testing if the visitExactKeywordNode function is a type of function
    test('Testing if visitExactKeywordNode is a type of function', () => {
        // Expecting the visitExactKeywordNode function to return an object
        const query = ""
        let lexer = new Lexer(query);
        let tokens = lexer.makeTokens();
        let parser = new Parser(tokens);
        let { result } = parser.parse();
        let interpreter = new Interpreter(result);
        expect(typeof interpreter.visitExactKeywordNode).toBe('function');
    });
});


// Let's test some basic queries
describe('Testing basic queries', () => {
    test('Testing keywords', () => {
        // Expecting the visit function to be defined
        const query = "keyword1 keyword2 keyword3"
        let lexer = new Lexer(query);
        let tokens = lexer.makeTokens();
        let parser = new Parser(tokens);
        let { result } = parser.parse();
        let interpreter = new Interpreter(result);
        interpreter.visit(result);
        expect(interpreter.global_query).toEqual('keyword1 keyword2 keyword3');
    });

    test('Testing keywords with spaces', () => {
        // Expecting the visit function to be defined
        const query = "         keyword1       keyword2 keyword3    "
        let lexer = new Lexer(query);
        let tokens = lexer.makeTokens();
        let parser = new Parser(tokens);
        let { result } = parser.parse();
        let interpreter = new Interpreter(result);
        interpreter.visit(result);
        expect(interpreter.global_query).toEqual('keyword1 keyword2 keyword3');
    });

    test('Testing special keywords with spaces --> (Keyword such as |& are not operators)', () => {
        // Expecting the visit function to be defined
        const query = "         keyword1       keyword2 keyword3    | keyword4 & keyword5"
        let lexer = new Lexer(query);
        let tokens = lexer.makeTokens();
        let parser = new Parser(tokens);
        let { result } = parser.parse();
        let interpreter = new Interpreter(result);
        interpreter.visit(result);
        expect(interpreter.global_query).toEqual('keyword1 keyword2 keyword3 | keyword4 & keyword5');
    });

    test('Testing grouped keywords)', () => {
        // Expecting the visit function to be defined
        const query = "[ keyword1  keyword2 keyword3  keyword4]"
        let lexer = new Lexer(query);
        let tokens = lexer.makeTokens();
        let parser = new Parser(tokens);
        let { result } = parser.parse();
        let interpreter = new Interpreter(result);
        interpreter.visit(result);
        expect(interpreter.global_query).toEqual('(keyword1 keyword2 keyword3 keyword4)');
    });

    test('Testing grouped keywords with spaces)', () => {
        // Expecting the visit function to be defined
        const query = "[         keyword1       keyword2 keyword3    keyword4]"
        let lexer = new Lexer(query);
        let tokens = lexer.makeTokens();
        let parser = new Parser(tokens);
        let { result } = parser.parse();
        let interpreter = new Interpreter(result);
        interpreter.visit(result);
        expect(interpreter.global_query).toEqual('(keyword1 keyword2 keyword3 keyword4)');
    });


    test('Testing grouped keywords with spaces)', () => {
        // Expecting the visit function to be defined
        const query = "[         keyword1       [keyword2 keyword3]    keyword4]"
        let lexer = new Lexer(query);
        let tokens = lexer.makeTokens();
        let parser = new Parser(tokens);
        let { result } = parser.parse();
        let interpreter = new Interpreter(result);
        interpreter.visit(result);
        expect(interpreter.global_query).toEqual('(keyword1 (keyword2 keyword3) keyword4)');
    });
});

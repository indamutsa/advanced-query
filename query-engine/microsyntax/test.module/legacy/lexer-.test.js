const { IllegalCharacterError } = require('../error/error');
const { Lexer } = require('../lexer/lexer');
const Token = require('../lexer/token');

// Before everything
// beforeAll(() => console.log('Before everything'));
// afterAll(() => console.log('After everything'));

// Testing the lexer
describe('Testing the lexer', () => {

    // Testing if the makeTokens function is defined
    test('Testing if makeTokens is defined', () => {
        // Expecting the makeTokens function to be defined
        let lexer = new Lexer('123');
        expect(lexer.makeTokens()).toBeDefined();
    });

    // Testing if the makeTokens function returns an array
    test('Testing if makeTokens returns an array', () => {
        // Expecting the lexer to return a lexer
        let lexer = new Lexer('123');
        expect(Array.isArray(lexer.makeTokens())).toBeTruthy();
    });

    // Testing if the makeTokens function returns an array of tokens
    test('Testing if makeTokens returns an array of tokens', () => {
        // Expecting the lexer to return a lexer
        let lexer = new Lexer('keyword1 keyword2  326676  keyword3 name:value');
        expect(lexer.makeTokens()[0].type).toBeDefined();
    });

    // Testing if the makeTokens function returns the correct tokens
    test('Testing if makeTokens returns the correct tokens -- simpler version -- (i)', () => {
        // Expecting the lexer to return a lexer
        let lexer = new Lexer('keyword1 keyword2 AND 326676 OR keyword3 NOT name:value');

        expect(lexer.makeTokens()[0].type).toBe('TT_KEYWORD');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[1].type).toBe('TT_SPACE');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[2].type).toBe('TT_KEYWORD');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[3].type).toBe('TT_AND');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[4].type).toBe('TT_NUMBER');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[5].type).toBe('TT_OR');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[6].type).toBe('TT_KEYWORD');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[7].type).toBe('TT_NOT');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[8].type).toBe('TT_TAG');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[9].type).toBe('TT_COLON');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[10].type).toBe('TT_KEYWORD');


    });

    // Testing if the makeTokens function returns the correct tokens at their index
    test('Testing if makeTokens returns the correct tokens -- complex version -- (ii)', () => {
        // Expecting the lexer to return a lexer
        let lexer = new Lexer('[keyword1 keyword2] NOT 326676     keyword3 AND [ name:value keword4 hello [description: "hello world"] AND name:value2] ]');

        expect(lexer.makeTokens()[0].type).toBe('TT_LBRAKET');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[1].type).not.toBe('TT_SPACE');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[2].type).toBe('TT_SPACE');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[3].type).toBe('TT_KEYWORD');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[4].type).toBe('TT_RBRAKET');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[5].type).toBe('TT_NOT');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[6].type).toBe('TT_NUMBER');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[7].type).toBe('TT_SPACE');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[8].type).toBe('TT_KEYWORD');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[9].type).toBe('TT_AND');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[10].type).toBe('TT_LBRAKET');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[11].type).not.toBe('TT_SPACE');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[11].type).toBe('TT_TAG');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[12].type).toBe('TT_COLON');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[13].type).toBe('TT_KEYWORD');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[14].type).toBe('TT_SPACE');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[15].type).toBe('TT_KEYWORD');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[16].type).toBe('TT_SPACE');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[17].type).toBe('TT_KEYWORD');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[18].type).toBe('TT_SPACE');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[19].type).toBe('TT_LBRAKET');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[20].type).toBe('TT_TAG');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[21].type).toBe('TT_COLON');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[22].type).toBe('TT_QUOTE');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[23].type).toBe('TT_KEYWORD');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[24].type).toBe('TT_SPACE');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[25].type).toBe('TT_KEYWORD');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[26].type).toBe('TT_RBRAKET');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[27].type).toBe('TT_AND');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[28].type).toBe('TT_TAG');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[29].type).toBe('TT_COLON');

        // Testing that tokens are coming as expected
        expect(lexer.makeTokens()[30].type).toBe('TT_KEYWORD');
    });


    // Testing if the makeTokens return the right tokens number
    test('Testing if makeTokens returns the right number of tokens', () => {
        // Expecting the lexer to return a lexer
        let lexer = new Lexer("[conformsTo:'id' hasAttribute:'value'] isTransformable:'value' Kirue");

        expect(lexer.makeTokens().length).toBe(22);
    });

    // Testing if the makeTokens return the right tokens number
    test('Testing if makeTokens returns the right number of tokens -- complex version --', () => {
        // Expecting the lexer to return a lexer
        let lexer = new Lexer("name1 AND name2 [ mc == 2 hasAttribute:value] name:'value2'");

        // Checking if the length of the tokens array is 20
        expect(lexer.makeTokens().length).toBe(20);

        // Checking if the token at the end is TT_EOF
        expect(lexer.makeTokens()[19].type).toBe('TT_EOF');

        // Checking if the token at index 5 is TT_LBRAKET
        expect(lexer.makeTokens()[4].type).toBe('TT_LBRAKET');

        // Checking if the token at index 6 is TT_METRIC
        expect(lexer.makeTokens()[5].type).toBe('TT_METRIC');

        // Checking if the token at index 7 is TT_EQUAL
        expect(lexer.makeTokens()[6].type).toBe('TT_EQUAL');

        // Checking if the token at index 8 is TT_NUMBER
        expect(lexer.makeTokens()[7].type).toBe('TT_NUMBER');

        // Checking if the token at index 18 is TT_QUOTE
        expect(lexer.makeTokens()[17].type).toBe('TT_KEYWORD');

        // Checking if the token at index 18 is TT_QUOTE
        expect(lexer.makeTokens()[18].type).toBe('TT_QUOTE');
    });


    // Testing makeNumberToken method
    test('Testing makeNumberToken method', () => {
        // Expecting the lexer to return a lexer
        let lexer = new Lexer("23[23==");
        let lex = new Lexer("23.32.3");
        let lexx = new Lexer("23.32 78 99");

        // Checking if the output is an instance of Token
        expect(isInstanceOf(lexer.makeNumberToken(), IllegalCharacterError)).toBe(true);

        // Checking illegal dot
        expect(isInstanceOf(lex.makeNumberToken(), IllegalCharacterError)).toBe(true);

        // Checking if the output is an array of number tokens
        expect(isInstanceOf(lexx.makeTokens(), Array)).toBe(true);
    });
});

function isInstanceOf(obj, instance) {
    return obj instanceof instance;
}

// Test token class
// const query = "[conformsTo:'id' hasAttribute:'value'] isTransformable:'value' Kirue";
// const query = "hello [world full [another word]]";
// const query = "conformsTo: ' id '";
// const query = "  [   name    :       value  keyword   ] ";
// const query = "amc == 10";
// const query = "name1 name2 mc == 2 hasAttribute:value name:'value2'"
// const query = "name1 AND name2 [ mc == 2 hasAttribute:value] name:'value2'"

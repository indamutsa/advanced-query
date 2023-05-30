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
// const query = "23[23==";
// const query = "(keyword1 keywo)rd2) keyword3 | keyword4 & keyword5"
// const query = "name = '      university_ocl.ecore '";

const { Lexer } = require("./lexer/lexer");
const { Parser } = require("./parser/parser");
const { Interpreter } = require("./interpreter/interpreter");

const runMicroSyntax = (query) => {
  try {
    let tokens = new Lexer(query).makeTokens();
    log(tokens);
    if (Array.isArray(tokens)) {
      let parser = new Parser(tokens);
      let { result, error } = parser.parse();
      //   log(result ? result : error);

      let interpreter = new Interpreter(result);
      //   log("Hello", interpreter.global_query);

      interpreter.visit(result);
      log(
        interpreter.global_query,
        "===> Inside runMicroSyntax function in interpreter"
      );

      return {
        res: interpreter.global_query,
        err: "",
      };
    } else
      return {
        res: "",
        err: tokens,
      };
  } catch (err) {
    return {
      res: "",
      err: err.message,
    };
  }
};

// runMicroSyntax(query);

module.exports = { runMicroSyntax };

// let tokens = new Lexer(query).makeTokens();
// log(tokens);

// if (Array.isArray(tokens)) {
//     let parser = new Parser(tokens);
//     let { result, error } = parser.parse();

//     log(result ? result : error);

//     if (result) {

//         let interpreter = new Interpreter(result);
//         interpreter.visit(result);
//         log(interpreter.global_query)
//     }

// } else log(tokens);

const { log } = console;

const query =
  "student professor (name: jack AND size: 20 (project: 'Project1' OR hello (cmc == 2 AND mc: 2 size = 600 )) )";

const Lexer = require("./lexer/lexer");
const { Parser } = require("./parser/parser");
const { Interpreter } = require("./interpreter/interpreter");

const runMicroSyntax = (query) => {
  try {
    const tokens = new Lexer(query).makeTokens();
    log(tokens);

    // let tokens = new Lexer(query).makeTokens();
    // log(tokens);
    // if (Array.isArray(tokens)) {
    //   let parser = new Parser(tokens);
    //   let { result, error } = parser.parse();
    //   //   log(result ? result : error);

    //   let interpreter = new Interpreter(result);
    //   //   log("Hello", interpreter.global_query);

    //   interpreter.visit(result);
    //   log(
    //     interpreter.global_query,
    //     "===> Inside runMicroSyntax function in interpreter"
    //   );
    //   return {
    //     res: interpreter.global_query,
    //     err: "",
    //   };
    // } else
    //   return {
    //     res: "",
    //     err: tokens,
    //   };
  } catch (err) {
    return {
      res: "",
      err: err.message,
    };
  }
};

runMicroSyntax(query);

module.exports = { runMicroSyntax };

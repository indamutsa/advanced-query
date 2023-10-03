const { log } = console;
// let query = "";
// Node
// query = "hello";
// query = "123456";
// query = "123456.123";

// ExactKeywordNode
// query = "'keyword1 keyword2 12545.33'";

// TagNode
// query = "name=simpleoop.ecore";
// query = "name : (simpleoop.ecore)";
// query = "name :'simpleoop.ecore'";

// BinaryOperatorNode
// query = "student professor";
// query = "student professor AND book";
// query = "student AND professor";
// query = "name  :   (  'keyword1   keyword2 12545.33  ')  ";

// MetricNode
// query = "cmc > 5";
// query = "mc == 2 AND cmc > 8";

// Complex queries:
// query = "(keyword1 AND keyword2 OR keyword3) AND name:value OR cmc>10";
// query = "(conformsTo:'id' hasAttribute:'value') isTransformable:'value' Kirue";
// query = "name1 AND name2 ( mc == 2 hasAttribute:value) name:'value2'";
// query = "accessControl = 'public' AND size < 500 OR ext = 'json'";
// query = "(size >= 1000 AND createdAt <= 20220101) OR (project = 'Project2' AND attr > 5)";
// query =  "(type = 'ecore' AND uniqueName = 'uniqueModel') OR (license = 'Apache' AND cflmc = 2)";
// query = "(hasAttribute = 'color' AND description = 'Complex Model') OR (updatedAt > 20240101 AND amc <= 3)";
// query = "conformsTo = 'matamodel_id' AND (license = 'GPL' AND name = 'ModelY')";
// query =  "involvedOperations = 'operation_id' (uniqueName = 'ModelX' AND mc > 50)";
// query = "description = 'Advanced Model' OR project = 'Project1' AND type = 'xmi'";
// query =
//   "(updatedAt > 20230101) NOT (ext = 'json') OR (cmc > 5 AND sf <= 2) keyword5 AND license = 'MIT' project='Project1' AND isTransformable='ARTIFACT_ID'";
// query = "name = 'ModelX' AND (mc > 50 OR sf <= 2)";
// query =  "student professor (name: jack AND size: 20 (project: 'Project1' OR hello (cmc == 2 AND mc: 2 size = 600 )))";

const Lexer = require("./lexer");
const { Parser } = require("./parser");
const Interpreter = require("./interpreter");

const runMicroSyntax = (query) => {
  try {
    let tokens = new Lexer(query).makeTokens();
    // log(tokens);
    if (Array.isArray(tokens)) {
      let parser = new Parser(tokens);
      let { result, error } = parser.parse();
      // log(result ? result : error);

      const interpreter = new Interpreter(result);
      const elasticQuery = interpreter.visitAst();
      // console.log(elasticQuery);

      return elasticQuery;
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

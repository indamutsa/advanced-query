const Interpreter = require("../interpreter");
const Lexer = require("../lexer");
const { Parser } = require("../parser");

describe("Interpreter", () => {
  it("should interpret node query correctly", () => {
    const query = "hello";
    const tokens = new Lexer(query).makeTokens();
    let { result: ast, error } = new Parser(tokens).parse();
    const result = new Interpreter(ast).visitAst();

    expect(result).toEqual(
      `{"query":{"bool":{"must":[{"query_string":{"query":"hello"}}]}}}`
    );
  });

  it("should interpret ExactKeywordNode query correctly", () => {
    const query = "'keyword1 keyword2 12545.33'";
    const tokens = new Lexer(query).makeTokens();
    let { result: ast, error } = new Parser(tokens).parse();
    const interpreter = new Interpreter(ast);
    const result = new Interpreter(ast).visitAst();

    expect(result).toEqual(
      `{"query":{"bool":{"must":[{"bool":{"should":[{"match_phrase":{"content":"keyword1 keyword2 12545.33"}},{"match_phrase":{"description":"keyword1 keyword2 12545.33"}},{"match_phrase":{"name":"keyword1 keyword2 12545.33"}}],"minimum_should_match":1}}]}}}`
    );
  });

  // TagNode tests
  it("should interpret TagNode query correctly (equal sign)", () => {
    const query = "name=simpleoop.ecore";
    const tokens = new Lexer(query).makeTokens();
    let { result: ast, error } = new Parser(tokens).parse();
    const result = new Interpreter(ast).visitAst();

    expect(result).toEqual(
      `{"query":{"bool":{"must":[{"match":{"name":"simpleoop.ecore"}}]}}}`
    );
  });

  it("should interpret TagNode query correctly (colon)", () => {
    const query = "name : (simpleoop.ecore)";
    const tokens = new Lexer(query).makeTokens();
    let { result: ast, error } = new Parser(tokens).parse();
    const result = new Interpreter(ast).visitAst();

    expect(result).toEqual(
      `{"query":{"bool":{"must":[{"match":{"name":"simpleoop.ecore"}}]}}}`
    );
  });

  it("should interpret TagNode query with ExactKeywordNode correctly", () => {
    const query = "name :'simpleoop.ecore'";
    const tokens = new Lexer(query).makeTokens();
    let { result: ast, error } = new Parser(tokens).parse();
    const result = new Interpreter(ast).visitAst();

    expect(result).toEqual(
      `{"query":{"bool":{"must":[{"multi_match":{"query":"simpleoop.ecore","fields":["name"],"type":"phrase"}}]}}}`
    );
  });

  // BinaryOperatorNode tests
  it("should interpret BinaryOperatorNode query with space as logical operator correctly", () => {
    const query = "student professor";
    const tokens = new Lexer(query).makeTokens();
    let { result: ast, error } = new Parser(tokens).parse();
    const result = new Interpreter(ast).visitAst();

    expect(result).toEqual(
      `{"query":{"bool":{"must":[{"bool":{"should":[{"query_string":{"query":"student"}},{"query_string":{"query":"professor"}}],"minimum_should_match":1}}]}}}`
    );
  });

  it("should interpret BinaryOperatorNode query with AND as logical operator correctly", () => {
    const query = "student professor AND book";
    const tokens = new Lexer(query).makeTokens();
    let { result: ast, error } = new Parser(tokens).parse();
    const result = new Interpreter(ast).visitAst();

    expect(result).toEqual(
      `{"query":{"bool":{"must":[{"bool":{"must":[{"bool":{"should":[{"query_string":{"query":"student"}},{"query_string":{"query":"professor"}}],"minimum_should_match":1}},{"query_string":{"query":"book"}}]}}]}}}`
    );
  });

  it("should interpret BinaryOperatorNode query with only two nodes correctly", () => {
    const query = "student AND professor";
    const tokens = new Lexer(query).makeTokens();
    let { result: ast, error } = new Parser(tokens).parse();
    const result = new Interpreter(ast).visitAst();

    expect(result).toEqual(
      `{"query":{"bool":{"must":[{"bool":{"must":[{"query_string":{"query":"student"}},{"query_string":{"query":"professor"}}]}}]}}}`
    );
  });

  it("should interpret BinaryOperatorNode query with TagNode and ExactKeywordNode correctly", () => {
    const query = "name  :   (  'keyword1   keyword2 12545.33  ')  ";
    const tokens = new Lexer(query).makeTokens();
    let { result: ast, error } = new Parser(tokens).parse();
    const result = new Interpreter(ast).visitAst();

    expect(result).toEqual(
      `{"query":{"bool":{"must":[{"multi_match":{"query":"keyword1 keyword2 12545.33","fields":["name"],"type":"phrase"}}]}}}`
    );
  });

  //Testing metric node
  it("should interpret MetricNode query correctly", () => {
    const query = "cmc > 5";
    const tokens = new Lexer(query).makeTokens();
    let { result: ast, error } = new Parser(tokens).parse();
    const result = new Interpreter(ast).visitAst();

    expect(result).toEqual(
      `{"query":{"bool":{"must":[{"bool":{"must":[{"match":{"metrics.code":"CMC"}},{"range":{"metrics.value":{"gt":"5"}}}]}}]}}}`
    );
  });

  // BinaryOperatorNode tests with MetricNode
  it("should interpret BinaryOperatorNode query with MetricNode correctly", () => {
    const query = "mc == 2 AND cmc > 8";
    const tokens = new Lexer(query).makeTokens();
    let { result: ast, error } = new Parser(tokens).parse();
    const result = new Interpreter(ast).visitAst();

    expect(result).toEqual(
      `{"query":{"bool":{"must":[{"bool":{"must":[{"bool":{"must":[{"match":{"metrics.code":"MC"}},{"range":{"metrics.value":{"gte":"2","lte":"2"}}}]}},{"bool":{"must":[{"match":{"metrics.code":"CMC"}},{"range":{"metrics.value":{"gt":"8"}}}]}}]}}]}}}`
    );
  });

  // =============================================================

  it("should interpret complex query correctly (Query 1)", () => {
    const query =
      "(keyword1 AND keyword2 OR keyword3) AND name:value OR cmc>10";
    const tokens = new Lexer(query).makeTokens();
    let { result: ast, error } = new Parser(tokens).parse();
    const result = new Interpreter(ast).visitAst();
    expect(result).toEqual(
      `{"query":{"bool":{"must":[{"bool":{"should":[{"bool":{"must":[{"bool":{"should":[{"bool":{"must":[{"query_string":{"query":"keyword1"}},{"query_string":{"query":"keyword2"}}]}},{"query_string":{"query":"keyword3"}}],"minimum_should_match":1}},{"match":{"name":"value"}}]}},{"query_string":{"query":"cmc10"}}],"minimum_should_match":1}}]}}}`
    );
  });

  it("should interpret complex query correctly (Query 2)", () => {
    const query =
      "(conformsTo:'id' hasAttribute:'value') isTransformable:'value' Kirue";
    const tokens = new Lexer(query).makeTokens();
    let { result: ast, error } = new Parser(tokens).parse();
    const result = new Interpreter(ast).visitAst();
    expect(result).toEqual(
      `{"query":{"bool":{"must":[{"bool":{"should":[{"bool":{"should":[{"bool":{"should":[{"multi_match":{"query":"id","fields":["conformsTo"],"type":"phrase"}},{"multi_match":{"query":"value","fields":["hasAttribute"],"type":"phrase"}}],"minimum_should_match":1}},{"multi_match":{"query":"value","fields":["isTransformable"],"type":"phrase"}}],"minimum_should_match":1}},{"query_string":{"query":"Kirue"}}],"minimum_should_match":1}}]}}}`
    );
  });

  it("should interpret complex query correctly (Query 3)", () => {
    const query = "name1 AND name2 ( mc == 2 hasAttribute:value) name:'value2'";
    const tokens = new Lexer(query).makeTokens();
    let { result: ast, error } = new Parser(tokens).parse();
    const result = new Interpreter(ast).visitAst();
    expect(result).toEqual(
      `{"query":{"bool":{"must":[{"bool":{"should":[{"bool":{"should":[{"bool":{"must":[{"query_string":{"query":"name1"}},{"query_string":{"query":"name2"}}]}},{"bool":{"should":[{"bool":{"must":[{"match":{"metrics.code":"MC"}},{"range":{"metrics.value":{"gte":"2","lte":"2"}}}]}},{"match":{"hasAttribute":"value"}}],"minimum_should_match":1}}],"minimum_should_match":1}},{"multi_match":{"query":"value2","fields":["name"],"type":"phrase"}}],"minimum_should_match":1}}]}}}`
    );
  });

  it("should interpret complex query correctly (Query 4)", () => {
    const query = "accessControl = 'public' AND size < 500 OR ext = 'json'";
    const tokens = new Lexer(query).makeTokens();
    let { result: ast, error } = new Parser(tokens).parse();
    const result = new Interpreter(ast).visitAst();
    expect(result).toEqual(
      `{"query":{"bool":{"must":[{"bool":{"should":[{"bool":{"must":[{"multi_match":{"query":"public","fields":["accessControl"],"type":"phrase"}},{"match":{"size":"500"}}]}},{"multi_match":{"query":"json","fields":["ext"],"type":"phrase"}}],"minimum_should_match":1}}]}}}`
    );
  });

  it("should interpret complex query correctly (Query 5)", () => {
    const query =
      "(size >= 1000 AND createdAt <= 20220101) OR (project = 'Project2' AND attr > 5)";
    const tokens = new Lexer(query).makeTokens();
    let { result: ast, error } = new Parser(tokens).parse();
    const result = new Interpreter(ast).visitAst();
    expect(result).toEqual(
      `{"query":{"bool":{"must":[{"bool":{"should":[{"bool":{"must":[{"match":{"size":"1000"}},{"match":{"createdAt":"20220101"}}]}},{"bool":{"must":[{"multi_match":{"query":"Project2","fields":["project"],"type":"phrase"}},{"bool":{"must":[{"match":{"metrics.code":"ATTR"}},{"range":{"metrics.value":{"gt":"5"}}}]}}]}}],"minimum_should_match":1}}]}}}`
    );
  });

  it("should interpret complex query correctly (Query 6)", () => {
    const query =
      "(type = 'ecore' AND uniqueName = 'uniqueModel') OR (license = 'Apache' AND cflmc = 2)";
    const tokens = new Lexer(query).makeTokens();
    let { result: ast, error } = new Parser(tokens).parse();
    const result = new Interpreter(ast).visitAst();
    expect(result).toEqual(
      `{"query":{"bool":{"must":[{"bool":{"should":[{"bool":{"must":[{"multi_match":{"query":"ecore","fields":["type"],"type":"phrase"}},{"multi_match":{"query":"uniqueModel","fields":["uniqueName"],"type":"phrase"}}]}},{"bool":{"must":[{"multi_match":{"query":"Apache","fields":["license"],"type":"phrase"}},{"bool":{"must":[{"match":{"metrics.code":"CFLMC"}},{"range":{"metrics.value":{"gte":"2","lte":"2"}}}]}}]}}],"minimum_should_match":1}}]}}}`
    );
  });

  it("should interpret complex query correctly (Query 7)", () => {
    const query =
      "(hasAttribute = 'color' AND description = 'Complex Model') OR (updatedAt > 20240101 AND amc <= 3)";
    const tokens = new Lexer(query).makeTokens();
    let { result: ast, error } = new Parser(tokens).parse();
    const result = new Interpreter(ast).visitAst();
    expect(result).toEqual(
      `{"query":{"bool":{"must":[{"bool":{"should":[{"bool":{"must":[{"multi_match":{"query":"color","fields":["hasAttribute"],"type":"phrase"}},{"multi_match":{"query":"Complex Model","fields":["description"],"type":"phrase"}}]}},{"bool":{"must":[{"match":{"updatedAt":"20240101"}},{"bool":{"must":[{"match":{"metrics.code":"AMC"}},{"range":{"metrics.value":{"lte":"3"}}}]}}]}}],"minimum_should_match":1}}]}}}`
    );
  });

  it("should interpret complex query correctly (Query 8)", () => {
    const query =
      "conformsTo = 'matamodel_id' AND (license = 'GPL' AND name = 'ModelY')";
    const tokens = new Lexer(query).makeTokens();
    let { result: ast, error } = new Parser(tokens).parse();
    const result = new Interpreter(ast).visitAst();
    expect(result).toEqual(
      `{"query":{"bool":{"must":[{"bool":{"must":[{"multi_match":{"query":"matamodel_id","fields":["conformsTo"],"type":"phrase"}},{"bool":{"must":[{"multi_match":{"query":"GPL","fields":["license"],"type":"phrase"}},{"multi_match":{"query":"ModelY","fields":["name"],"type":"phrase"}}]}}]}}]}}}`
    );
  });

  it("should interpret complex query correctly (Query 9)", () => {
    const query =
      "involvedOperations = 'operation_id' (uniqueName = 'ModelX' AND mc > 50)";
    const tokens = new Lexer(query).makeTokens();
    let { result: ast, error } = new Parser(tokens).parse();
    const result = new Interpreter(ast).visitAst();
    expect(result).toEqual(
      `{"query":{"bool":{"must":[{"bool":{"should":[{"multi_match":{"query":"operation_id","fields":["involvedOperations"],"type":"phrase"}},{"bool":{"must":[{"multi_match":{"query":"ModelX","fields":["uniqueName"],"type":"phrase"}},{"bool":{"must":[{"match":{"metrics.code":"MC"}},{"range":{"metrics.value":{"gt":"50"}}}]}}]}}],"minimum_should_match":1}}]}}}`
    );
  });

  it("should interpret complex query correctly (Query 10)", () => {
    const query =
      "description = 'Advanced Model' OR project = 'Project1' AND type = 'xmi'";
    const tokens = new Lexer(query).makeTokens();
    let { result: ast, error } = new Parser(tokens).parse();
    const result = new Interpreter(ast).visitAst();
    expect(result).toEqual(
      `{"query":{"bool":{"must":[{"bool":{"must":[{"bool":{"should":[{"multi_match":{"query":"Advanced Model","fields":["description"],"type":"phrase"}},{"multi_match":{"query":"Project1","fields":["project"],"type":"phrase"}}],"minimum_should_match":1}},{"multi_match":{"query":"xmi","fields":["type"],"type":"phrase"}}]}}]}}}`
    );
  });

  it("should interpret complex query correctly (Query 11)", () => {
    const query =
      "(updatedAt > 20230101) NOT (ext = 'json') OR (cmc > 5 AND sf <= 2) keyword5 AND license = 'MIT' project='Project1' AND isTransformable='ARTIFACT_ID'";
    const tokens = new Lexer(query).makeTokens();
    let { result: ast, error } = new Parser(tokens).parse();
    const result = new Interpreter(ast).visitAst();
    expect(result).toEqual(
      `{"query":{"bool":{"must":[{"bool":{"must":[{"bool":{"should":[{"bool":{"must":[{"bool":{"should":[{"bool":{"should":[{"bool":{"must_not":[{"multi_match":{"query":"json","fields":["ext"],"type":"phrase"}}],"filter":[{"match":{"updatedAt":"20230101"}}]}},{"bool":{"must":[{"bool":{"must":[{"match":{"metrics.code":"CMC"}},{"range":{"metrics.value":{"gt":"5"}}}]}},{"bool":{"must":[{"match":{"metrics.code":"SF"}},{"range":{"metrics.value":{"lte":"2"}}}]}}]}}],"minimum_should_match":1}},{"query_string":{"query":"keyword5"}}],"minimum_should_match":1}},{"multi_match":{"query":"MIT","fields":["license"],"type":"phrase"}}]}},{"multi_match":{"query":"Project1","fields":["project"],"type":"phrase"}}],"minimum_should_match":1}},{"multi_match":{"query":"ARTIFACT_ID","fields":["isTransformable"],"type":"phrase"}}]}}]}}}`
    );
  });

  it("should interpret complex query correctly (Query 12)", () => {
    const query = "name = 'ModelX' AND (mc > 50 OR sf <= 2)";
    const tokens = new Lexer(query).makeTokens();
    let { result: ast, error } = new Parser(tokens).parse();
    const result = new Interpreter(ast).visitAst();
    expect(result).toEqual(
      `{"query":{"bool":{"must":[{"bool":{"must":[{"multi_match":{"query":"ModelX","fields":["name"],"type":"phrase"}},{"bool":{"should":[{"bool":{"must":[{"match":{"metrics.code":"MC"}},{"range":{"metrics.value":{"gt":"50"}}}]}},{"bool":{"must":[{"match":{"metrics.code":"SF"}},{"range":{"metrics.value":{"lte":"2"}}}]}}],"minimum_should_match":1}}]}}]}}}`
    );
  });

  it("should interpret complex query correctly (Query 15)", () => {
    const query =
      "student professor (name: jack AND size: 20 (project: 'Project1' OR hello (cmc == 2 AND mc: 2 size = 600 )))";
    const tokens = new Lexer(query).makeTokens();
    let { result: ast, error } = new Parser(tokens).parse();
    const result = new Interpreter(ast).visitAst();
    expect(result).toEqual(
      `{"query":{"bool":{"must":[{"bool":{"should":[{"bool":{"should":[{"query_string":{"query":"student"}},{"query_string":{"query":"professor"}}],"minimum_should_match":1}},{"bool":{"should":[{"bool":{"must":[{"match":{"name":"jack"}},{"match":{"size":"20"}}]}},{"bool":{"should":[{"bool":{"should":[{"multi_match":{"query":"Project1","fields":["project"],"type":"phrase"}},{"query_string":{"query":"hello"}}],"minimum_should_match":1}},{"bool":{"should":[{"bool":{"must":[{"bool":{"must":[{"match":{"metrics.code":"CMC"}},{"range":{"metrics.value":{"gte":"2","lte":"2"}}}]}},{"bool":{"must":[{"match":{"metrics.code":"MC"}},{"range":{"metrics.value":{"gte":"2","lte":"2"}}}]}}]}},{"match":{"size":"600"}}],"minimum_should_match":1}}],"minimum_should_match":1}}],"minimum_should_match":1}}],"minimum_should_match":1}}]}}}`
    );
  });
});

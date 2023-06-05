const Lexer = require("../lexer");
const Token = require("../lexer/token");
const {
  Parser,
  BinaryOperatorNode,
  Node,
  TagNode,
  MetricNode,
  ExactKeywordNode,
} = require("../parser");

describe("Testing the parser with valid expressions", () => {
  test("Single Keyword", () => {
    let lexer = new Lexer("keyword1");
    let tokens = lexer.makeTokens();
    let parser = new Parser(tokens);
    let { result, error } = parser.parse();
    expect(error).toBeNull();
    expect(result).toBeDefined();
    // Perform more specific assertions based on the structure of your AST.
    expect(result).toBeInstanceOf(Node);
    expect(result.token.type).toBe("TT_KEYWORD");
  });

  test("Numeric", () => {
    let lexer = new Lexer("123456");
    let tokens = lexer.makeTokens();
    let parser = new Parser(tokens);
    let { result, error } = parser.parse();
    expect(error).toBeNull();
    expect(result).toBeDefined();
    // Perform more specific assertions based on the structure of your AST.
    expect(result).toBeInstanceOf(Node);
    expect(result.token.type).toBe("TT_NUMBER");
  });

  test("Multiple Keywords", () => {
    let lexer = new Lexer("keyword1 keyword2 12545.33");
    let tokens = lexer.makeTokens();
    let parser = new Parser(tokens);
    let { result, error } = parser.parse();
    expect(error).toBeNull();
    expect(result).toBeDefined();

    // Perform more specific assertions based on the structure of your AST.
    expect(result).toBeInstanceOf(BinaryOperatorNode);
    expect(result.left).toBeInstanceOf(BinaryOperatorNode);
    expect(result.left.left).toBeInstanceOf(Node);
    expect(result.left.left.token.type).toBe("TT_KEYWORD");
    expect(result.left.logicalOp.type).toBe("TT_LOGICAL_OPERATOR");
    expect(result.left.right).toBeInstanceOf(Node);
    expect(result.left.right.token.type).toBe("TT_KEYWORD");
    expect(result.left.logicalOp.type).toBe("TT_LOGICAL_OPERATOR");
    expect(result.right).toBeInstanceOf(Node);
    expect(result.right.token.type).toBe("TT_NUMBER");
  });

  // Testing exact match
  test("Exact match", () => {
    let lexer = new Lexer("'keyword1 keyword2 12545.33'");
    let tokens = lexer.makeTokens();
    let parser = new Parser(tokens);
    let { result, error } = parser.parse();
    expect(error).toBeNull();
    expect(result).toBeDefined();

    // Perform more specific assertions based on the structure of your AST.
    expect(result).toBeInstanceOf(ExactKeywordNode);
    expect(result.startingQuote).toBe("'");
    expect(result.endingQuote).toBe("'");
    expect(result.keyword).toBe("keyword1 keyword2 12545.33");
  });

  test("Testing simple Tag", () => {
    let lexer = new Lexer("name=value");
    let tokens = lexer.makeTokens();
    let parser = new Parser(tokens);
    let { result, error } = parser.parse();
    expect(error).toBeNull();
    expect(result).toBeDefined();
    // Perform more specific assertions based on the structure of your AST.
    expect(result).toBeInstanceOf(TagNode);
    expect(result.tag.type).toBe("TT_TAG");
    expect(result.tag.value).toBe("name");
    expect(result.assignOp.type).toBe("TT_ASSIGNMENT_OPERATOR");
    expect(result.value.token.type).toBe("TT_KEYWORD");
  });

  // More tests...
  test("Testing Complex Tag", () => {
    const query = "name  :   (  'keyword1   keyword2 12545.33  ')  ";
    let lexer = new Lexer(query);
    let tokens = lexer.makeTokens();
    let parser = new Parser(tokens);
    let { result, error } = parser.parse();

    expect(error).toBeNull();
    expect(result).toBeDefined();

    // Perform more specific assertions based on the structure of your AST.
    expect(result).toBeInstanceOf(TagNode);

    expect(result.tag.type).toBe("TT_TAG");
    expect(result.tag.value).toBe("name");

    expect(result.assignOp.type).toBe("TT_ASSIGNMENT_OPERATOR");

    expect(result.value).toBeInstanceOf(ExactKeywordNode);
    expect(result.value.startingQuote).toBe("'");
    expect(result.value.endingQuote).toBe("'");
    expect(result.value.keyword).toBe("keyword1 keyword2 12545.33");
  });

  test("Complex Query [1]", () => {
    const query =
      "(keyword1 AND keyword2 OR keyword3) AND name:value OR cmc>10";
    let lexer = new Lexer(query);
    let tokens = lexer.makeTokens();
    let parser = new Parser(tokens);
    let { result, error } = parser.parse();

    expect(error).toBeNull();
    expect(result).toBeDefined();

    // Perform more specific assertions based on the structure of your AST.
    expect(result).toBeInstanceOf(BinaryOperatorNode);

    // Root Level
    expect(result.logicalOp.type).toBe("TT_LOGICAL_OPERATOR");
    expect(result.logicalOp.value).toBe("OR");

    // Right Node of Root
    expect(result.right).toBeInstanceOf(Node);
    expect(result.right.token.type).toBe("TT_KEYWORD");
    expect(result.right.token.value).toBe("cmc10");

    // Left Node of Root
    expect(result.left).toBeInstanceOf(BinaryOperatorNode);
    expect(result.left.logicalOp.type).toBe("TT_LOGICAL_OPERATOR");
    expect(result.left.logicalOp.value).toBe("AND");

    // Unpacking the nested BinaryOperatorNode
    let nestedBinaryNode = result.left.left;
    expect(nestedBinaryNode.result).toBeInstanceOf(BinaryOperatorNode);
    expect(nestedBinaryNode.paranthLeft).toBe("(");
    expect(nestedBinaryNode.paranthRight).toBe(")");

    // Further Unpacking the nested BinaryOperatorNode
    let furtherNestedBinaryNode = nestedBinaryNode.result;

    // Top Level of Further Nested Node
    expect(furtherNestedBinaryNode).toBeInstanceOf(BinaryOperatorNode);
    expect(furtherNestedBinaryNode.logicalOp.type).toBe("TT_LOGICAL_OPERATOR");
    expect(furtherNestedBinaryNode.logicalOp.value).toBe("OR");

    // Right Node of Further Nested Node
    expect(furtherNestedBinaryNode.right).toBeInstanceOf(Node);
    expect(furtherNestedBinaryNode.right.token.type).toBe("TT_KEYWORD");
    expect(furtherNestedBinaryNode.right.token.value).toBe("keyword3");

    // Left Node of Further Nested Node
    expect(furtherNestedBinaryNode.left).toBeInstanceOf(BinaryOperatorNode);
    expect(furtherNestedBinaryNode.left.logicalOp.type).toBe(
      "TT_LOGICAL_OPERATOR"
    );
    expect(furtherNestedBinaryNode.left.logicalOp.value).toBe("AND");

    // Unpacking the most nested BinaryOperatorNode
    let mostNestedBinaryNode = furtherNestedBinaryNode.left;

    // Left Node of Most Nested Node
    expect(mostNestedBinaryNode.left).toBeInstanceOf(Node);
    expect(mostNestedBinaryNode.left.token.type).toBe("TT_KEYWORD");
    expect(mostNestedBinaryNode.left.token.value).toBe("keyword1");

    // Right Node of Most Nested Node
    expect(mostNestedBinaryNode.right).toBeInstanceOf(Node);
    expect(mostNestedBinaryNode.right.token.type).toBe("TT_KEYWORD");
    expect(mostNestedBinaryNode.right.token.value).toBe("keyword2");

    // Right Node of Nested Binary Node
    expect(result.left.right).toBeInstanceOf(TagNode);
    expect(result.left.right.tag.type).toBe("TT_TAG");
    expect(result.left.right.tag.value).toBe("name");
    expect(result.left.right.assignOp.type).toBe("TT_ASSIGNMENT_OPERATOR");
    expect(result.left.right.value.token.type).toBe("TT_KEYWORD");
    expect(result.left.right.value.token.value).toBe("value");
  });

  test("Complex Query [2]", () => {
    let lexer = new Lexer(
      "(conformsTo:'id' hasAttribute:'value') isTransformable:'value' Kirue"
    );
    let tokens = lexer.makeTokens();
    let parser = new Parser(tokens);
    let { result, error } = parser.parse();

    // Initial Assertions
    expect(error).toBeNull();
    expect(result).toBeInstanceOf(BinaryOperatorNode);
    expect(result.logicalOp.type).toBe("TT_LOGICAL_OPERATOR");

    // Right Node
    expect(result.right).toBeInstanceOf(Node);
    expect(result.right.token.type).toBe("TT_KEYWORD");
    expect(result.right.token.value).toBe("Kirue");

    // Left Node
    expect(result.left).toBeInstanceOf(BinaryOperatorNode);
    expect(result.left.logicalOp.type).toBe("TT_LOGICAL_OPERATOR");

    // Unpacking the Left Node
    let leftNode = result.left;

    // Right Node of Left Node
    expect(leftNode.right).toBeInstanceOf(TagNode);
    expect(leftNode.right.tag.type).toBe("TT_TAG");
    expect(leftNode.right.tag.value).toBe("isTransformable");
    expect(leftNode.right.assignOp.type).toBe("TT_ASSIGNMENT_OPERATOR");
    expect(leftNode.right.value).toBeInstanceOf(ExactKeywordNode);
    expect(leftNode.right.value.startingQuote).toBe("'");
    expect(leftNode.right.value.endingQuote).toBe("'");
    expect(leftNode.right.value.keyword).toBe("value");

    // Further Unpacking the Left Node
    let furtherNestedBinaryNode = leftNode.left.result;
    expect(furtherNestedBinaryNode).toBeInstanceOf(BinaryOperatorNode);

    // Left Node of Further Nested Node
    expect(furtherNestedBinaryNode.left).toBeInstanceOf(TagNode);
    expect(furtherNestedBinaryNode.left.tag.type).toBe("TT_TAG");
    expect(furtherNestedBinaryNode.left.tag.value).toBe("conformsTo");
    expect(furtherNestedBinaryNode.left.assignOp.type).toBe(
      "TT_ASSIGNMENT_OPERATOR"
    );
    expect(furtherNestedBinaryNode.left.value).toBeInstanceOf(ExactKeywordNode);
    expect(furtherNestedBinaryNode.left.value.startingQuote).toBe("'");
    expect(furtherNestedBinaryNode.left.value.endingQuote).toBe("'");
    expect(furtherNestedBinaryNode.left.value.keyword).toBe("id");

    // Right Node of Further Nested Node
    expect(furtherNestedBinaryNode.right).toBeInstanceOf(TagNode);
    expect(furtherNestedBinaryNode.right.tag.type).toBe("TT_TAG");
    expect(furtherNestedBinaryNode.right.tag.value).toBe("hasAttribute");
    expect(furtherNestedBinaryNode.right.assignOp.type).toBe(
      "TT_ASSIGNMENT_OPERATOR"
    );
    expect(furtherNestedBinaryNode.right.value).toBeInstanceOf(
      ExactKeywordNode
    );
    expect(furtherNestedBinaryNode.right.value.startingQuote).toBe("'");
    expect(furtherNestedBinaryNode.right.value.endingQuote).toBe("'");
    expect(furtherNestedBinaryNode.right.value.keyword).toBe("value");
  });

  test("Complex Query [3]", () => {
    let lexer = new Lexer(
      "name1 AND name2 ( mc == 2 hasAttribute:value) name:'value2'"
    );
    let tokens = lexer.makeTokens();
    let parser = new Parser(tokens);
    let { result, error } = parser.parse();

    // Initial Assertions
    expect(error).toBeNull();
    expect(result).toBeInstanceOf(BinaryOperatorNode);
    expect(result.logicalOp.type).toBe("TT_LOGICAL_OPERATOR");

    // Right Node
    expect(result.right).toBeInstanceOf(TagNode);
    expect(result.right.tag.type).toBe("TT_TAG");
    expect(result.right.tag.value).toBe("name");
    expect(result.right.assignOp.type).toBe("TT_ASSIGNMENT_OPERATOR");
    expect(result.right.value).toBeInstanceOf(ExactKeywordNode);
    expect(result.right.value.startingQuote).toBe("'");
    expect(result.right.value.endingQuote).toBe("'");
    expect(result.right.value.keyword).toBe("value2");

    // Left Node
    expect(result.left).toBeInstanceOf(BinaryOperatorNode);
    expect(result.left.logicalOp.type).toBe("TT_LOGICAL_OPERATOR");

    // Unpacking the Left Node
    let leftNode = result.left;

    // Right Node of Left Node
    expect(leftNode.right).toBeDefined(); // Further assertions should be done based on the structure of the Node returned
    expect(leftNode.right.paranthLeft).toBe("(");
    expect(leftNode.right.paranthRight).toBe(")");

    // Further Unpacking the Left Node
    let furtherNestedBinaryNode = leftNode.left;
    expect(furtherNestedBinaryNode).toBeInstanceOf(BinaryOperatorNode);

    // Left Node of Further Nested Node
    expect(furtherNestedBinaryNode.left).toBeInstanceOf(Node);
    expect(furtherNestedBinaryNode.left.token.type).toBe("TT_KEYWORD");
    expect(furtherNestedBinaryNode.left.token.value).toBe("name1");

    // Right Node of Further Nested Node
    expect(furtherNestedBinaryNode.right).toBeInstanceOf(Node);
    expect(furtherNestedBinaryNode.right.token.type).toBe("TT_KEYWORD");
    expect(furtherNestedBinaryNode.right.token.value).toBe("name2");
  });

  test("Complex Query [4]", () => {
    let lexer = new Lexer(
      "accessControl = 'public' AND size < 500 OR ext = 'json'"
    );
    let tokens = lexer.makeTokens();
    let parser = new Parser(tokens);
    let { result, error } = parser.parse();

    // Initial Assertions
    expect(error).toBeNull();
    expect(result).toBeInstanceOf(BinaryOperatorNode);
    expect(result.logicalOp.type).toBe("TT_LOGICAL_OPERATOR");
    expect(result.logicalOp.value).toBe("OR");

    // Right Node
    expect(result.right).toBeInstanceOf(TagNode);
    expect(result.right.tag.type).toBe("TT_TAG");
    expect(result.right.tag.value).toBe("ext");
    expect(result.right.assignOp.type).toBe("TT_ASSIGNMENT_OPERATOR");
    expect(result.right.value).toBeInstanceOf(ExactKeywordNode);
    expect(result.right.value.startingQuote).toBe("'");
    expect(result.right.value.endingQuote).toBe("'");
    expect(result.right.value.keyword).toBe("json");

    // Unpacking the Left Node
    let leftNode = result.left;
    expect(leftNode).toBeInstanceOf(BinaryOperatorNode);
    expect(leftNode.logicalOp.type).toBe("TT_LOGICAL_OPERATOR");
    expect(leftNode.logicalOp.value).toBe("AND");

    // Left Node of Left Node
    expect(leftNode.left).toBeInstanceOf(TagNode);
    expect(leftNode.left.tag.type).toBe("TT_TAG");
    expect(leftNode.left.tag.value).toBe("accessControl");
    expect(leftNode.left.assignOp.type).toBe("TT_ASSIGNMENT_OPERATOR");
    expect(leftNode.left.value).toBeInstanceOf(ExactKeywordNode);
    expect(leftNode.left.value.startingQuote).toBe("'");
    expect(leftNode.left.value.endingQuote).toBe("'");
    expect(leftNode.left.value.keyword).toBe("public");

    // Right Node of Left Node
    expect(leftNode.right).toBeDefined(); // Further assertions should be done based on the structure of the Node returned
  });

  test("Complex Query with Logical Operators, Tags, Metrics and Exact Matches", () => {
    let lexer = new Lexer(
      "(size >= 1000 AND createdAt <= 20220101) OR (project = 'Project2' AND attr > 5)"
    );
    let tokens = lexer.makeTokens();
    let parser = new Parser(tokens);
    let { result, error } = parser.parse();

    // Initial Assertions
    expect(error).toBeNull();
    expect(result).toBeInstanceOf(BinaryOperatorNode);
    expect(result.logicalOp.type).toBe("TT_LOGICAL_OPERATOR");
    expect(result.logicalOp.value).toBe("OR");

    // Unpacking the Left Group
    let leftGroup = result.left;
    expect(leftGroup.paranthLeft).toBe("(");
    expect(leftGroup.paranthRight).toBe(")");
    let leftGroupResult = leftGroup.result;
    expect(leftGroupResult).toBeInstanceOf(BinaryOperatorNode);
    expect(leftGroupResult.logicalOp.type).toBe("TT_LOGICAL_OPERATOR");
    expect(leftGroupResult.logicalOp.value).toBe("AND");

    // Left Group Result - Left
    expect(leftGroupResult.left).toBeInstanceOf(TagNode); // Further unpacking based on your implementation

    // Left Group Result - Right
    expect(leftGroupResult.right).toBeInstanceOf(TagNode); // Further unpacking based on your implementation

    // Unpacking the Right Group
    let rightGroup = result.right;
    expect(rightGroup.paranthLeft).toBe("(");
    expect(rightGroup.paranthRight).toBe(")");
    let rightGroupResult = rightGroup.result;
    expect(rightGroupResult).toBeInstanceOf(BinaryOperatorNode);
    expect(rightGroupResult.logicalOp.type).toBe("TT_LOGICAL_OPERATOR");
    expect(rightGroupResult.logicalOp.value).toBe("AND");

    // Right Group Result - Left
    expect(rightGroupResult.left).toBeInstanceOf(TagNode); // Further unpacking based on your implementation

    // Right Group Result - Right
    expect(rightGroupResult.right).toBeInstanceOf(MetricNode); // Further unpacking based on your implementation
  });

  test("Complex Query 1 with Logical Operators, Tags, and Exact Matches", () => {
    let lexer = new Lexer(
      "(type = 'ecore' AND uniqueName = 'uniqueModel') OR (license = 'Apache' AND cflmc = 2)"
    );
    let tokens = lexer.makeTokens();
    let parser = new Parser(tokens);
    let { result, error } = parser.parse();

    // Initial Assertions
    expect(error).toBeNull();
    expect(result).toBeInstanceOf(BinaryOperatorNode);
    expect(result.logicalOp.type).toBe("TT_LOGICAL_OPERATOR");
    expect(result.logicalOp.value).toBe("OR");

    // Unpacking the Left Group
    let leftGroup = result.left;
    expect(leftGroup.paranthLeft).toBe("(");
    expect(leftGroup.paranthRight).toBe(")");
    let leftGroupResult = leftGroup.result;
    expect(leftGroupResult).toBeInstanceOf(BinaryOperatorNode);
    expect(leftGroupResult.logicalOp.type).toBe("TT_LOGICAL_OPERATOR");
    expect(leftGroupResult.logicalOp.value).toBe("AND");

    // Left Group Result - Left
    expect(leftGroupResult.left).toBeInstanceOf(TagNode); // Further unpacking based on your implementation

    // Left Group Result - Right
    expect(leftGroupResult.right).toBeInstanceOf(TagNode); // Further unpacking based on your implementation

    // Unpacking the Right Group
    let rightGroup = result.right;
    expect(rightGroup.paranthLeft).toBe("(");
    expect(rightGroup.paranthRight).toBe(")");
    let rightGroupResult = rightGroup.result;
    expect(rightGroupResult).toBeInstanceOf(BinaryOperatorNode);
    expect(rightGroupResult.logicalOp.type).toBe("TT_LOGICAL_OPERATOR");
    expect(rightGroupResult.logicalOp.value).toBe("AND");

    // Right Group Result - Left
    expect(rightGroupResult.left).toBeInstanceOf(TagNode); // Further unpacking based on your implementation

    // Right Group Result - Right
    expect(rightGroupResult.right).toBeInstanceOf(MetricNode); // Further unpacking based on your implementation
  });

  test("Complex Query 2 with Logical Operators, Tags, and Metrics", () => {
    let lexer = new Lexer(
      "(hasAttribute = 'color' AND description = 'Complex Model') OR (updatedAt > 20240101 AND amc <= 3)"
    );
    let tokens = lexer.makeTokens();
    let parser = new Parser(tokens);
    let { result, error } = parser.parse();

    // Initial Assertions
    expect(error).toBeNull();
    expect(result).toBeInstanceOf(BinaryOperatorNode);
    expect(result.logicalOp.type).toBe("TT_LOGICAL_OPERATOR");
    expect(result.logicalOp.value).toBe("OR");

    // Unpacking the Left Group
    let leftGroup = result.left;
    expect(leftGroup.paranthLeft).toBe("(");
    expect(leftGroup.paranthRight).toBe(")");
    let leftGroupResult = leftGroup.result;
    expect(leftGroupResult).toBeInstanceOf(BinaryOperatorNode);
    expect(leftGroupResult.logicalOp.type).toBe("TT_LOGICAL_OPERATOR");
    expect(leftGroupResult.logicalOp.value).toBe("AND");

    // Left Group Result - Left
    expect(leftGroupResult.left).toBeInstanceOf(TagNode); // Further unpacking based on your implementation

    // Left Group Result - Right
    expect(leftGroupResult.right).toBeInstanceOf(TagNode); // Further unpacking based on your implementation

    // Unpacking the Right Group
    let rightGroup = result.right;
    expect(rightGroup.paranthLeft).toBe("(");
    expect(rightGroup.paranthRight).toBe(")");
    let rightGroupResult = rightGroup.result;
    expect(rightGroupResult).toBeInstanceOf(BinaryOperatorNode);
    expect(rightGroupResult.logicalOp.type).toBe("TT_LOGICAL_OPERATOR");
    expect(rightGroupResult.logicalOp.value).toBe("AND");

    // Right Group Result - Left
    expect(rightGroupResult.left).toBeInstanceOf(TagNode); // Further unpacking based on your implementation

    // Right Group Result - Right
    expect(rightGroupResult.right).toBeInstanceOf(MetricNode); // Further unpacking based on your implementation
  });

  test("Query 2 with Logical Operators, Parentheses, Tags, and Exact Matches", () => {
    let lexer = new Lexer(
      "conformsTo = 'matamodel_id' AND (license = 'GPL' AND name = 'ModelY')"
    );
    let tokens = lexer.makeTokens();
    let parser = new Parser(tokens);
    let { result, error } = parser.parse();

    // Initial Assertions
    expect(error).toBeNull();
    expect(result).toBeInstanceOf(BinaryOperatorNode);
    expect(result.logicalOp.type).toBe("TT_LOGICAL_OPERATOR");
    expect(result.logicalOp.value).toBe("AND");

    // Unpacking the Left Node
    let leftNode = result.left;
    expect(leftNode).toBeInstanceOf(TagNode); // Further unpacking based on your implementation

    // Unpacking the Right Group
    let rightGroup = result.right;
    expect(rightGroup.paranthLeft).toBe("(");
    expect(rightGroup.paranthRight).toBe(")");
    let rightGroupResult = rightGroup.result;
    expect(rightGroupResult).toBeInstanceOf(BinaryOperatorNode);
    expect(rightGroupResult.logicalOp.type).toBe("TT_LOGICAL_OPERATOR");
    expect(rightGroupResult.logicalOp.value).toBe("AND");

    // Unpacking Right Group Result - Left Node
    expect(rightGroupResult.left).toBeInstanceOf(TagNode); // Further unpacking based on your implementation

    // Unpacking Right Group Result - Right Node
    expect(rightGroupResult.right).toBeInstanceOf(TagNode); // Further unpacking based on your implementation
  });

  test("Query 3 with Logical Operators, Parentheses, Tags, Metrics, and Exact Matches", () => {
    let lexer = new Lexer(
      "involvedOperations = 'operation_id' (uniqueName = 'ModelX' AND mc > 50)"
    );
    let tokens = lexer.makeTokens();
    let parser = new Parser(tokens);
    let { result, error } = parser.parse();

    // Initial Assertions
    expect(error).toBeNull();
    expect(result).toBeInstanceOf(BinaryOperatorNode);
    expect(result.logicalOp.type).toBe("TT_LOGICAL_OPERATOR");
    expect(result.logicalOp.value).toBe(" ");

    // Unpacking the Left Node
    let leftNode = result.left;
    expect(leftNode).toBeInstanceOf(TagNode); // Further unpacking based on your implementation

    // Unpacking the Right Group
    let rightGroup = result.right;
    expect(rightGroup.paranthLeft).toBe("(");
    expect(rightGroup.paranthRight).toBe(")");
    let rightGroupResult = rightGroup.result;
    expect(rightGroupResult).toBeInstanceOf(BinaryOperatorNode);
    expect(rightGroupResult.logicalOp.type).toBe("TT_LOGICAL_OPERATOR");
    expect(rightGroupResult.logicalOp.value).toBe("AND");

    // Unpacking Right Group Result - Left Node
    expect(rightGroupResult.left).toBeInstanceOf(TagNode); // Further unpacking based on your implementation

    // Unpacking Right Group Result - Right Node
    expect(rightGroupResult.right).toBeInstanceOf(MetricNode); // Further unpacking based on your implementation
  });

  test("Complex query with mixed AND, OR operations and exact matches", () => {
    let lexer = new Lexer(
      "description = 'Advanced Model' OR project = 'Project1' AND type = 'xmi'"
    );
    let tokens = lexer.makeTokens();
    let parser = new Parser(tokens);
    let { result, error } = parser.parse();
    expect(error).toBeNull();

    expect(result).toBeInstanceOf(BinaryOperatorNode);
    expect(result.logicalOp.type).toBe("TT_LOGICAL_OPERATOR");
    expect(result.logicalOp.value).toBe("AND");

    let leftNode = result.left;
    expect(leftNode).toBeInstanceOf(BinaryOperatorNode);
    expect(leftNode.logicalOp.type).toBe("TT_LOGICAL_OPERATOR");
    expect(leftNode.logicalOp.value).toBe("OR");

    let rightNode = result.right;
    expect(rightNode).toBeInstanceOf(TagNode);
    expect(rightNode.tag.type).toBe("TT_TAG");
    expect(rightNode.tag.value).toBe("type");
    expect(rightNode.assignOp.type).toBe("TT_ASSIGNMENT_OPERATOR");
    expect(rightNode.value).toBeInstanceOf(ExactKeywordNode);
    expect(rightNode.value.startingQuote).toBe("'");
    expect(rightNode.value.endingQuote).toBe("'");
    expect(rightNode.value.keyword).toBe("xmi");
  });

  test("Complex query with mixed logical operations and exact matches", () => {
    let lexer = new Lexer(
      "(updatedAt > 20230101) NOT (ext = 'json') OR (cmc > 5 AND sf <= 2) keyword5 AND license = 'MIT' project='Project1' AND isTransformable='ARTIFACT_ID'"
    );
    let tokens = lexer.makeTokens();
    let parser = new Parser(tokens);
    let { result, error } = parser.parse();
    expect(error).toBeNull();

    // Top level node should be a BinaryOperatorNode with AND operation
    expect(result).toBeInstanceOf(BinaryOperatorNode);
    expect(result.logicalOp.type).toBe("TT_LOGICAL_OPERATOR");
    expect(result.logicalOp.value).toBe("AND");

    // Left side of top level node
    let leftNode = result.left;
    expect(leftNode).toBeInstanceOf(BinaryOperatorNode);

    // Unpack the left side of the top level node
    let leftLeftNode = leftNode.left;
    expect(leftLeftNode).toBeInstanceOf(BinaryOperatorNode);

    let leftRightNode = leftNode.right;
    expect(leftRightNode).toBeInstanceOf(TagNode);
    expect(leftRightNode.tag.type).toBe("TT_TAG");
    expect(leftRightNode.tag.value).toBe("project");
    expect(leftRightNode.assignOp.type).toBe("TT_ASSIGNMENT_OPERATOR");
    expect(leftRightNode.value).toBeInstanceOf(ExactKeywordNode);
    expect(leftRightNode.value.startingQuote).toBe("'");
    expect(leftRightNode.value.endingQuote).toBe("'");
    expect(leftRightNode.value.keyword).toBe("Project1");

    // Right side of top level node
    let rightNode = result.right;
    expect(rightNode).toBeInstanceOf(TagNode);
    expect(rightNode.tag.type).toBe("TT_TAG");
    expect(rightNode.tag.value).toBe("isTransformable");
    expect(rightNode.assignOp.type).toBe("TT_ASSIGNMENT_OPERATOR");
    expect(rightNode.value).toBeInstanceOf(ExactKeywordNode);
    expect(rightNode.value.startingQuote).toBe("'");
    expect(rightNode.value.endingQuote).toBe("'");
    expect(rightNode.value.keyword).toBe("ARTIFACT_ID");
  });

  test("Query with mixed logical operations and parenthesis", () => {
    let lexer = new Lexer("name = 'ModelX' AND (mc > 50 OR sf <= 2)");
    let tokens = lexer.makeTokens();
    let parser = new Parser(tokens);
    let { result, error } = parser.parse();
    expect(error).toBeNull();

    // Top level node should be a BinaryOperatorNode with AND operation
    expect(result).toBeInstanceOf(BinaryOperatorNode);
    expect(result.logicalOp.type).toBe("TT_LOGICAL_OPERATOR");
    expect(result.logicalOp.value).toBe("AND");

    // Left side of top level node
    let leftNode = result.left;
    expect(leftNode).toBeInstanceOf(TagNode);
    expect(leftNode.tag.type).toBe("TT_TAG");
    expect(leftNode.tag.value).toBe("name");
    expect(leftNode.assignOp.type).toBe("TT_ASSIGNMENT_OPERATOR");
    expect(leftNode.value).toBeInstanceOf(ExactKeywordNode);
    expect(leftNode.value.startingQuote).toBe("'");
    expect(leftNode.value.endingQuote).toBe("'");
    expect(leftNode.value.keyword).toBe("ModelX");

    // Right side of top level node should be a BinaryOperatorNode
    let rightNode = result.right;
    expect(rightNode.result).toBeInstanceOf(BinaryOperatorNode);

    // Unpack the BinaryOperatorNode
    let rightBinaryNode = rightNode.result;
    expect(rightBinaryNode.left).toBeInstanceOf(MetricNode);
    expect(rightBinaryNode.right).toBeInstanceOf(MetricNode);
    expect(rightBinaryNode.logicalOp.type).toBe("TT_LOGICAL_OPERATOR");
    expect(rightBinaryNode.logicalOp.value).toBe("OR");
  });

  test("Two keywords without explicit operator", () => {
    let lexer = new Lexer("student professor");
    let tokens = lexer.makeTokens();
    let parser = new Parser(tokens);
    let { result, error } = parser.parse();
    expect(error).toBeNull();

    // Top level node should be a BinaryOperatorNode with an implicit AND operation
    expect(result).toBeInstanceOf(BinaryOperatorNode);
    expect(result.logicalOp.type).toBe("TT_LOGICAL_OPERATOR");
    expect(result.logicalOp.value).toBe(" ");

    // Left and Right nodes of the BinaryOperatorNode
    expect(result.left).toBeInstanceOf(Node);
    expect(result.right).toBeInstanceOf(Node);
    expect(result.left.token.type).toBe("TT_KEYWORD");
    expect(result.right.token.type).toBe("TT_KEYWORD");
    expect(result.left.token.value).toBe("student");
    expect(result.right.token.value).toBe("professor");
  });

  test("Two keywords with explicit AND operator", () => {
    let lexer = new Lexer("student AND professor");
    let tokens = lexer.makeTokens();
    let parser = new Parser(tokens);
    let { result, error } = parser.parse();
    expect(error).toBeNull();

    // Top level node should be a BinaryOperatorNode with an AND operation
    expect(result).toBeInstanceOf(BinaryOperatorNode);
    expect(result.logicalOp.type).toBe("TT_LOGICAL_OPERATOR");
    expect(result.logicalOp.value).toBe("AND");

    // Left and Right nodes of the BinaryOperatorNode
    expect(result.left).toBeInstanceOf(Node);
    expect(result.right).toBeInstanceOf(Node);
    expect(result.left.token.type).toBe("TT_KEYWORD");
    expect(result.right.token.type).toBe("TT_KEYWORD");
    expect(result.left.token.value).toBe("student");
    expect(result.right.token.value).toBe("professor");
  });

  test("Nested expressions with both logical and tag operators", () => {
    let lexer = new Lexer(
      "student professor (name: jack AND size: 20 (project: 'Project1' OR hello (cmc == 2 AND mc: 2 size = 600 )))"
    );
    let tokens = lexer.makeTokens();
    let parser = new Parser(tokens);
    let { result, error } = parser.parse();

    expect(error).toBeNull();
    expect(result).toBeInstanceOf(BinaryOperatorNode);

    let { left: firstLl, logicalOp, right: firstLr } = result;

    // Unpacking first level of BinaryOperatorNode
    expect(firstLl).toBeInstanceOf(BinaryOperatorNode);
    expect(logicalOp.type).toBe("TT_LOGICAL_OPERATOR");
    expect(firstLr).toBeInstanceOf(Object);

    // Unpacking first level of BinaryOperatorNode
    let {
      left: secondLl,
      logicalOp: secondLogicalOp,
      right: secondLr,
    } = firstLl;

    expect(secondLl).toBeInstanceOf(Node);
    expect(secondLl.token.type).toBe("TT_KEYWORD");
    expect(secondLogicalOp.type).toBe("TT_LOGICAL_OPERATOR");
    expect(secondLr).toBeInstanceOf(Node);
    expect(secondLr.token.type).toBe("TT_KEYWORD");

    //   --------------------------------

    // Unpacking second level of BinaryOperatorNode
    let firstLevelRight = firstLr.result;
    let secondLevelLeft = firstLevelRight.left;
    let secondLevelRight = firstLevelRight.right;
    let secondLevelLogicalOp = firstLevelRight.logicalOp;

    expect(secondLevelLeft).toBeInstanceOf(BinaryOperatorNode);
    expect(secondLevelRight).toBeInstanceOf(Object);
    expect(secondLevelLogicalOp.type).toBe("TT_LOGICAL_OPERATOR");

    // Unpacking second level of BinaryOperatorNode
    expect(secondLevelLeft.left).toBeInstanceOf(TagNode);
    expect(secondLevelLeft.logicalOp.type).toBe("TT_LOGICAL_OPERATOR");
    expect(secondLevelLeft.right).toBeInstanceOf(TagNode);

    //   --------------------------------
    let secondLevelRightResult = secondLevelRight.result;
    let thirdLevelLeft = secondLevelRightResult.left;
    let thirdLevelRight = secondLevelRightResult.right;
    let thirdLevelLogicalOp = secondLevelRightResult.logicalOp;

    expect(thirdLevelLeft).toBeInstanceOf(BinaryOperatorNode);
    expect(thirdLevelLogicalOp.type).toBe("TT_LOGICAL_OPERATOR");
    expect(thirdLevelRight).toBeInstanceOf(Object);

    expect(thirdLevelLeft.left).toBeInstanceOf(TagNode);
    expect(thirdLevelLeft.logicalOp.type).toBe("TT_LOGICAL_OPERATOR");
    expect(thirdLevelLeft.right.token.type).toBe("TT_KEYWORD");
    expect(thirdLevelLeft.right.token.value).toBe("hello");

    //   --------------------------------
    let thirdLevelLeftNode = thirdLevelRight.result;
    expect(thirdLevelLeftNode.left).toBeInstanceOf(BinaryOperatorNode);
    expect(thirdLevelLeftNode.right).toBeInstanceOf(TagNode);
    expect(thirdLevelLeftNode.logicalOp.type).toBe("TT_LOGICAL_OPERATOR");
    expect(thirdLevelLeftNode.right.value.token.value).toBe("600");

    //   --------------------------------
    let fourthLevelLeft = thirdLevelLeftNode.left;
    expect(fourthLevelLeft.left).toBeInstanceOf(MetricNode);
    expect(fourthLevelLeft.right).toBeInstanceOf(MetricNode);
    expect(fourthLevelLeft.logicalOp.type).toBe("TT_LOGICAL_OPERATOR");
  });
});

function isInstanceOf(obj, instance) {
  return obj instanceof instance;
}

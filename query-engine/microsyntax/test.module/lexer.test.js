const Lexer = require("../lexer/index");

const queries = [
  // Testing logical operators
  {
    query: "AND",
    expectedTokens: [
      { type: "TT_LOGICAL_OPERATOR", value: "AND" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query: "OR",
    expectedTokens: [
      { type: "TT_LOGICAL_OPERATOR", value: "OR" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query: "NOT",
    expectedTokens: [
      { type: "TT_LOGICAL_OPERATOR", value: "NOT" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },

  // Testing comparison operators
  {
    query: "==",
    expectedTokens: [
      { type: "TT_COMPARISON_OPERATOR", value: "==" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query: "<",
    expectedTokens: [
      { type: "TT_COMPARISON_OPERATOR", value: "<" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query: ">",
    expectedTokens: [
      { type: "TT_COMPARISON_OPERATOR", value: ">" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query: "<=",
    expectedTokens: [
      { type: "TT_COMPARISON_OPERATOR", value: "<=" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query: ">=",
    expectedTokens: [
      { type: "TT_COMPARISON_OPERATOR", value: ">=" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },

  // Testing assignment operators
  {
    query: "=",
    expectedTokens: [
      { type: "TT_ASSIGNMENT_OPERATOR", value: "=" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query: ":",
    expectedTokens: [
      { type: "TT_ASSIGNMENT_OPERATOR", value: ":" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },

  // // Testing spaces
  {
    query: " ",
    expectedTokens: [
      { type: "TT_KEYWORD", value: "undefined" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query: "         ",
    expectedTokens: [
      { type: "TT_KEYWORD", value: "undefined" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query: "         ",
    expectedTokens: [
      { type: "TT_KEYWORD", value: "undefined" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },

  // Testing fuzz
  {
    query: "~",
    expectedTokens: [
      { type: "TT_FUZZ", value: "~" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query: "~~",
    expectedTokens: [
      { type: "TT_FUZZ", value: "~" },
      { type: "TT_FUZZ", value: "~" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },

  // Testing plus
  {
    query: "+",
    expectedTokens: [
      { type: "TT_PLUS", value: "+" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query: "++",
    expectedTokens: [
      { type: "TT_PLUS", value: "+" },
      { type: "TT_PLUS", value: "+" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },

  // Testing left paranthesis
  {
    query: "(",
    expectedTokens: [
      { type: "TT_LPARANTH", value: "(" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query: "((",
    expectedTokens: [
      { type: "TT_LPARANTH", value: "(" },
      { type: "TT_LPARANTH", value: "(" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },

  // Testing right paranthesis
  {
    query: ")",
    expectedTokens: [
      { type: "TT_RPARANTH", value: ")" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query: "))",
    expectedTokens: [
      { type: "TT_RPARANTH", value: ")" },
      { type: "TT_RPARANTH", value: ")" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },

  // Testing EOF
  {
    query: "EOF",
    expectedTokens: [
      { type: "TT_KEYWORD", value: "EOF" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },

  // testing keywords
  {
    query: "hello",
    expectedTokens: [
      { type: "TT_KEYWORD", value: "hello" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query: "hello999world",
    expectedTokens: [
      { type: "TT_KEYWORD", value: "hello999world" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query: "999hello",
    expectedTokens: [
      { type: "TT_KEYWORD", value: "999hello" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query: "name999",
    expectedTokens: [
      { type: "TT_KEYWORD", value: "name999" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query: "999name",
    expectedTokens: [
      { type: "TT_KEYWORD", value: "999name" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query: "name\\:999\\#",
    expectedTokens: [
      { type: "TT_KEYWORD", value: "name\\:999\\#" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },

  // Testing numbers
  {
    query: "99999",
    expectedTokens: [
      { type: "TT_NUMBER", value: "99999" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query: "999.99",
    expectedTokens: [
      { type: "TT_NUMBER", value: "999.99" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },

  // Tesing tags
  {
    query: "name:999\\(9",
    expectedTokens: [
      { type: "TT_TAG", value: "name" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: ":" },
      { type: "TT_KEYWORD", value: "999\\(9" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },

  {
    query: "  (   name    :       value  keyword   ) ",
    expectedTokens: [
      { type: "TT_LPARANTH", value: "(" },
      { type: "TT_TAG", value: "name" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: ":" },
      { type: "TT_KEYWORD", value: "value" },
      { type: "TT_LOGICAL_OPERATOR", value: " " },
      { type: "TT_KEYWORD", value: "keyword" },
      { type: "TT_RPARANTH", value: ")" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query: "name=89",
    expectedTokens: [
      { type: "TT_TAG", value: "name" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: "=" },
      { type: "TT_NUMBER", value: "89" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query: "name:99999",
    expectedTokens: [
      { type: "TT_TAG", value: "name" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: ":" },
      { type: "TT_NUMBER", value: "99999" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query: "name:hello999world",
    expectedTokens: [
      { type: "TT_TAG", value: "name" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: ":" },
      { type: "TT_KEYWORD", value: "hello999world" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query: "name:'999hello'",
    expectedTokens: [
      { type: "TT_TAG", value: "name" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: ":" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_KEYWORD", value: "999hello" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query: "name:999\\(9",
    expectedTokens: [
      { type: "TT_TAG", value: "name" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: ":" },
      { type: "TT_KEYWORD", value: "999\\(9" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query: "name:'hello\\#\\%999'",
    expectedTokens: [
      { type: "TT_TAG", value: "name" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: ":" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_KEYWORD", value: "hello\\#\\%999" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query: "name = ' 9 university_ocl.ecore '",
    expectedTokens: [
      { type: "TT_TAG", value: "name" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: "=" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_KEYWORD", value: "9 university_ocl.ecore" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query: "conformsTo : ' id hello world way back '",
    expectedTokens: [
      { type: "TT_TAG", value: "conformsTo" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: ":" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_KEYWORD", value: "id hello world way back" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query: "amc == 10",
    expectedTokens: [
      { type: "TT_METRIC", value: "amc" },
      { type: "TT_COMPARISON_OPERATOR", value: "==" },
      { type: "TT_NUMBER", value: "10" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query: "conformsTo : ' id hello world way back '",
    expectedTokens: [
      { type: "TT_TAG", value: "conformsTo" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: ":" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_KEYWORD", value: "id hello world way back" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },

  // --------------------COMPLEX QUERIES-------------------
  {
    query:
      "(conformsTo:'id' hasAttribute:'value') isTransformable:'value' Kirue",
    //  "(conformsTo:'id' hasAttribute:'value') isTransformable:'value' Kirue",
    expectedTokens: [
      { type: "TT_LPARANTH", value: "(" },
      { type: "TT_TAG", value: "conformsTo" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: ":" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_KEYWORD", value: "id" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_LOGICAL_OPERATOR", value: " " },
      { type: "TT_TAG", value: "hasAttribute" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: ":" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_KEYWORD", value: "value" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_RPARANTH", value: ")" },
      { type: "TT_LOGICAL_OPERATOR", value: " " },
      { type: "TT_TAG", value: "isTransformable" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: ":" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_KEYWORD", value: "value" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_LOGICAL_OPERATOR", value: " " },
      { type: "TT_KEYWORD", value: "Kirue" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },

  {
    query: "name1 AND name2 ( mc == 2 hasAttribute:value) name:'value2'",
    expectedTokens: [
      { type: "TT_KEYWORD", value: "name1" },
      { type: "TT_LOGICAL_OPERATOR", value: "AND" },
      { type: "TT_KEYWORD", value: "name2" },
      { type: "TT_LOGICAL_OPERATOR", value: " " },
      { type: "TT_LPARANTH", value: "(" },
      { type: "TT_METRIC", value: "mc" },
      { type: "TT_COMPARISON_OPERATOR", value: "==" },
      { type: "TT_NUMBER", value: "2" },
      { type: "TT_LOGICAL_OPERATOR", value: " " },
      { type: "TT_TAG", value: "hasAttribute" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: ":" },
      { type: "TT_KEYWORD", value: "value" },
      { type: "TT_RPARANTH", value: ")" },
      { type: "TT_LOGICAL_OPERATOR", value: " " },
      { type: "TT_TAG", value: "name" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: ":" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_KEYWORD", value: "value2" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query: "accessControl = 'public' AND size < 500 OR ext = 'json'",
    expectedTokens: [
      { type: "TT_TAG", value: "accessControl" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: "=" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_KEYWORD", value: "public" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_LOGICAL_OPERATOR", value: "AND" },
      { type: "TT_NUMERIC_TAG", value: "size" },
      { type: "TT_COMPARISON_OPERATOR", value: "<" },
      { type: "TT_NUMBER", value: "500" },
      { type: "TT_LOGICAL_OPERATOR", value: "OR" },
      { type: "TT_TAG", value: "ext" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: "=" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_KEYWORD", value: "json" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query:
      "(size >= 1000 AND createdAt <= 20220101) OR (project = 'Project2' AND attr > 5)",
    expectedTokens: [
      { type: "TT_LPARANTH", value: "(" },
      { type: "TT_NUMERIC_TAG", value: "size" },
      { type: "TT_COMPARISON_OPERATOR", value: ">=" },
      { type: "TT_NUMBER", value: "1000" },
      { type: "TT_LOGICAL_OPERATOR", value: "AND" },
      { type: "TT_NUMERIC_TAG", value: "createdAt" },
      { type: "TT_COMPARISON_OPERATOR", value: "<=" },
      { type: "TT_NUMBER", value: "20220101" },
      { type: "TT_RPARANTH", value: ")" },
      { type: "TT_LOGICAL_OPERATOR", value: "OR" },
      { type: "TT_LPARANTH", value: "(" },
      { type: "TT_TAG", value: "project" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: "=" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_KEYWORD", value: "Project2" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_LOGICAL_OPERATOR", value: "AND" },
      { type: "TT_METRIC", value: "attr" },
      { type: "TT_COMPARISON_OPERATOR", value: ">" },
      { type: "TT_NUMBER", value: "5" },
      { type: "TT_RPARANTH", value: ")" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query:
      "(type = 'ecore' AND uniqueName = 'uniqueModel') OR (license = 'Apache' AND cflmc = 2)",
    expectedTokens: [
      { type: "TT_LPARANTH", value: "(" },
      { type: "TT_TAG", value: "type" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: "=" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_KEYWORD", value: "ecore" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_LOGICAL_OPERATOR", value: "AND" },
      { type: "TT_TAG", value: "uniqueName" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: "=" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_KEYWORD", value: "uniqueModel" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_RPARANTH", value: ")" },
      { type: "TT_LOGICAL_OPERATOR", value: "OR" },
      { type: "TT_LPARANTH", value: "(" },
      { type: "TT_TAG", value: "license" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: "=" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_KEYWORD", value: "Apache" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_LOGICAL_OPERATOR", value: "AND" },
      { type: "TT_METRIC", value: "cflmc" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: "=" },
      { type: "TT_NUMBER", value: "2" },
      { type: "TT_RPARANTH", value: ")" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query:
      "(hasAttribute = 'color' AND description = 'Complex Model') OR (updatedAt > 20240101 AND amc <= 3)",
    expectedTokens: [
      { type: "TT_LPARANTH", value: "(" },
      { type: "TT_TAG", value: "hasAttribute" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: "=" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_KEYWORD", value: "color" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_LOGICAL_OPERATOR", value: "AND" },
      { type: "TT_TAG", value: "description" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: "=" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_KEYWORD", value: "Complex Model" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_RPARANTH", value: ")" },
      { type: "TT_LOGICAL_OPERATOR", value: "OR" },
      { type: "TT_LPARANTH", value: "(" },
      { type: "TT_NUMERIC_TAG", value: "updatedAt" },
      { type: "TT_COMPARISON_OPERATOR", value: ">" },
      { type: "TT_NUMBER", value: "20240101" },
      { type: "TT_LOGICAL_OPERATOR", value: "AND" },
      { type: "TT_METRIC", value: "amc" },
      { type: "TT_COMPARISON_OPERATOR", value: "<=" },
      { type: "TT_NUMBER", value: "3" },
      { type: "TT_RPARANTH", value: ")" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query:
      "description = 'Advanced Model' OR project = 'Project1' AND type = 'xmi'",
    expectedTokens: [
      { type: "TT_TAG", value: "description" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: "=" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_KEYWORD", value: "Advanced Model" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_LOGICAL_OPERATOR", value: "OR" },
      { type: "TT_TAG", value: "project" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: "=" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_KEYWORD", value: "Project1" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_LOGICAL_OPERATOR", value: "AND" },
      { type: "TT_TAG", value: "type" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: "=" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_KEYWORD", value: "xmi" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query:
      "conformsTo = 'matamodel_id' AND (license = 'GPL' AND name = 'ModelY')",
    expectedTokens: [
      { type: "TT_TAG", value: "conformsTo" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: "=" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_KEYWORD", value: "matamodel_id" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_LOGICAL_OPERATOR", value: "AND" },
      { type: "TT_LPARANTH", value: "(" },
      { type: "TT_TAG", value: "license" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: "=" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_KEYWORD", value: "GPL" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_LOGICAL_OPERATOR", value: "AND" },
      { type: "TT_TAG", value: "name" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: "=" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_KEYWORD", value: "ModelY" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_RPARANTH", value: ")" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query:
      "involvedOperations = 'operation_id' (uniqueName = 'ModelX' AND mc > 50)",
    expectedTokens: [
      { type: "TT_TAG", value: "involvedOperations" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: "=" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_KEYWORD", value: "operation_id" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_LOGICAL_OPERATOR", value: " " },
      { type: "TT_LPARANTH", value: "(" },
      { type: "TT_TAG", value: "uniqueName" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: "=" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_KEYWORD", value: "ModelX" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_LOGICAL_OPERATOR", value: "AND" },
      { type: "TT_METRIC", value: "mc" },
      { type: "TT_COMPARISON_OPERATOR", value: ">" },
      { type: "TT_NUMBER", value: "50" },
      { type: "TT_RPARANTH", value: ")" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query:
      "(updatedAt > 20230101) NOT (ext = 'json') OR (cmc > 5 AND sf <= 2) keyword5 AND license = 'MIT' project='Project1' AND isTransformable='ARTIFACT_ID'",
    expectedTokens: [
      { type: "TT_LPARANTH", value: "(" },
      { type: "TT_NUMERIC_TAG", value: "updatedAt" },
      { type: "TT_COMPARISON_OPERATOR", value: ">" },
      { type: "TT_NUMBER", value: "20230101" },
      { type: "TT_RPARANTH", value: ")" },
      { type: "TT_LOGICAL_OPERATOR", value: "NOT" },
      { type: "TT_LPARANTH", value: "(" },
      { type: "TT_TAG", value: "ext" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: "=" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_KEYWORD", value: "json" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_RPARANTH", value: ")" },
      { type: "TT_LOGICAL_OPERATOR", value: "OR" },
      { type: "TT_LPARANTH", value: "(" },
      { type: "TT_METRIC", value: "cmc" },
      { type: "TT_COMPARISON_OPERATOR", value: ">" },
      { type: "TT_NUMBER", value: "5" },
      { type: "TT_LOGICAL_OPERATOR", value: "AND" },
      { type: "TT_METRIC", value: "sf" },
      { type: "TT_COMPARISON_OPERATOR", value: "<=" },
      { type: "TT_NUMBER", value: "2" },
      { type: "TT_RPARANTH", value: ")" },
      { type: "TT_LOGICAL_OPERATOR", value: " " },
      { type: "TT_KEYWORD", value: "keyword5" },
      { type: "TT_LOGICAL_OPERATOR", value: "AND" },
      { type: "TT_TAG", value: "license" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: "=" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_KEYWORD", value: "MIT" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_LOGICAL_OPERATOR", value: " " },
      { type: "TT_TAG", value: "project" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: "=" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_KEYWORD", value: "Project1" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_LOGICAL_OPERATOR", value: "AND" },
      { type: "TT_TAG", value: "isTransformable" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: "=" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_KEYWORD", value: "ARTIFACT_ID" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query: "name = 'ModelX' AND (mc > 50 OR sf <= 2)",
    expectedTokens: [
      { type: "TT_TAG", value: "name" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: "=" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_KEYWORD", value: "ModelX" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_LOGICAL_OPERATOR", value: "AND" },
      { type: "TT_LPARANTH", value: "(" },
      { type: "TT_METRIC", value: "mc" },
      { type: "TT_COMPARISON_OPERATOR", value: ">" },
      { type: "TT_NUMBER", value: "50" },
      { type: "TT_LOGICAL_OPERATOR", value: "OR" },
      { type: "TT_METRIC", value: "sf" },
      { type: "TT_COMPARISON_OPERATOR", value: "<=" },
      { type: "TT_NUMBER", value: "2" },
      { type: "TT_RPARANTH", value: ")" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },

  {
    query: "student professor",
    expectedTokens: [
      { type: "TT_KEYWORD", value: "student" },
      { type: "TT_LOGICAL_OPERATOR", value: " " },
      { type: "TT_KEYWORD", value: "professor" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query: "student AND professor",
    expectedTokens: [
      { type: "TT_KEYWORD", value: "student" },
      { type: "TT_LOGICAL_OPERATOR", value: "AND" },
      { type: "TT_KEYWORD", value: "professor" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
  {
    query:
      "student professor (name: jack AND size: 20 (project: 'Project1' OR hello (cmc == 2 AND mc: 2 size = 600 )) )",
    expectedTokens: [
      { type: "TT_KEYWORD", value: "student" },
      { type: "TT_LOGICAL_OPERATOR", value: " " },
      { type: "TT_KEYWORD", value: "professor" },
      { type: "TT_LOGICAL_OPERATOR", value: " " },
      { type: "TT_LPARANTH", value: "(" },
      { type: "TT_TAG", value: "name" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: ":" },
      { type: "TT_KEYWORD", value: "jack" },
      { type: "TT_LOGICAL_OPERATOR", value: "AND" },
      { type: "TT_NUMERIC_TAG", value: "size" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: ":" },
      { type: "TT_NUMBER", value: "20" },
      { type: "TT_LOGICAL_OPERATOR", value: " " },
      { type: "TT_LPARANTH", value: "(" },
      { type: "TT_TAG", value: "project" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: ":" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_KEYWORD", value: "Project1" },
      { type: "TT_QUOTE", value: "'" },
      { type: "TT_LOGICAL_OPERATOR", value: "OR" },
      { type: "TT_KEYWORD", value: "hello" },
      { type: "TT_LOGICAL_OPERATOR", value: " " },
      { type: "TT_LPARANTH", value: "(" },
      { type: "TT_METRIC", value: "cmc" },
      { type: "TT_COMPARISON_OPERATOR", value: "==" },
      { type: "TT_NUMBER", value: "2" },
      { type: "TT_LOGICAL_OPERATOR", value: "AND" },
      { type: "TT_METRIC", value: "mc" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: ":" },
      { type: "TT_NUMBER", value: "2" },
      { type: "TT_LOGICAL_OPERATOR", value: " " },
      { type: "TT_NUMERIC_TAG", value: "size" },
      { type: "TT_ASSIGNMENT_OPERATOR", value: "=" },
      { type: "TT_NUMBER", value: "600" },
      { type: "TT_RPARANTH", value: ")" },
      { type: "TT_RPARANTH", value: ")" },
      { type: "TT_RPARANTH", value: ")" },
      { type: "TT_EOF", value: "EOF" },
    ],
  },
];

for (const { query, expectedTokens } of queries) {
  test(`should correctly tokenize the query: "${query}"`, () => {
    const lexer = new Lexer(query);

    const tokens = lexer.makeTokens();

    for (let i = 0; i < tokens.length; i++) {
      // console.log("Token: ", tokens[i], "Index: ", i);
      expect(tokens[i].type).toEqual(expectedTokens[i].type);
      expect(tokens[i].value).toEqual(expectedTokens[i].value);
    }
  });
}

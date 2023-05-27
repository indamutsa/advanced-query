//Token types
let operators = {
  TT_AND: "AND",
  TT_OR: "OR",
  TT_NOT: "NOT",
  TT_LBRAKET: "[",
  TT_RBRAKET: "]",
  TT_EQUAL: "::",
  TT_LESS_THAN: "<",
  TT_GREATER_THAN: ">",
  TT_LESS_THAN_EQUAL: "<:",
  TT_GREATER_THAN_EQUAL: ">:",
  TT_NUMBER: "NUMBER",
  TT_KEYWORD: "KEYWORD",
  TT_CONFORMS_TO: "conformsTo",
  TT_HAS_ATTRIBUTE: "hasAttribute",
  TT_IS_TRANSFORMABLE: "isTransformable",
  TT_COMMA: ",",
  TT_COLON: ":",
  TT_STRING_CHAR: "'" || '"',
  TT_FUZZ: "~",
  TT_PLUS: "+",
  TT_MINUS: "-",
  TT_MUL: "*",
  TT_EOF: "EOF",
};

let metrics = [
  "acfmc",
  "aiflmc",
  "amc",
  "attr",
  "attrh",
  "avgattr",
  "avgref",
  "ccfmc",
  "cflmc",
  "ciflmc",
  "cmc",
  "iflmc",
  "lmc",
  "maxhl",
  "maxhs",
  "mc",
  "mcwsp",
  "mtnb",
  "rec_cont",
  "ref",
  "refcc",
  "refeop",
  "sf",
  "sfh",
];

let tags = [
  "accessControl",
  "content",
  "createdAt",
  "description",
  "ext",
  "involvedOperations",
  "license",
  "name",
  "project",
  "size",
  "storageUrl",
  "type",
  "unique_name",
  "updatedAt",
  "conformsTo",
  "hasAttribute",
  "isTransformable",
];

let skipTokens = ["TT_KEYWORD", "TT_NUMBER", "TT_RBRAKET", "TT_QUOTE"];

module.exports = {
  operators,
  metrics,
  tags,
  skipTokens,
};

// let skipToken = [
//     'TT_LBRAKET', 'TT_RBRAKET', 'TT_EQUAL', 'TT_LESS_THAN_EQUAL', 'TT_LESS_THAN', 'TT_GREATER_THAN_EQUAL', 'TT_GREATER_THAN', "TT_COLON", "TT_QUOTE", "TT_AND", "TT_OR", 'TT_KEYWORD', "TT_NOT", "TT_NUMBER", 'TT_TAG', 'TT_METRIC',
//

// 'TT_LBRAKET', 'TT_RBRAKET', 'TT_EQUAL', 'TT_LESS_THAN_EQUAL', 'TT_LESS_THAN', 'TT_GREATER_THAN_EQUAL', 'TT_GREATER_THAN', "TT_COLON", "TT_QUOTE", "TT_AND", "TT_OR", , "TT_NOT", 'TT_TAG', 'TT_METRIC',

// ]

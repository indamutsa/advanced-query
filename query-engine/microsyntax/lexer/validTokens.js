const VALID_METRICS = new Set([
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
]);

const VALID_TAGS = new Set([
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
]);

const VALID_LOGICAL_OPERATORS = new Set(["AND", "OR", "NOT"]);
const VALID_COMPARISON_OPERATORS = new Set(["==", "<", ">", "<=", ">="]);
const VALID_ASSIGNMENT_OPERATORS = new Set(["=", ":"]);
const VALID_QUOTE_OPERATORS = new Set(['"', "'"]);

const tokenTypes = {
  TT_LOGICAL_OPERATOR: "TT_LOGICAL_OPERATOR",
  TT_COMPARISON_OPERATOR: "TT_COMPARISON_OPERATOR",
  TT_ASSIGNMENT_OPERATOR: "TT_ASSIGNMENT_OPERATOR",
  TT_VALID_QUOTE_OPERATORS: "TT_VALID_QUOTE_OPERATORS",
  TT_NUMBER: "TT_NUMBER",
  TT_METRIC: "TT_METRIC",
  TT_TAG: "TT_TAG",
  TT_SPACE: "TT_SPACE",
  TT_QUOTE: "TT_QUOTE",
  TT_FUZZ: "TT_FUZZ",
  TT_PLUS: "TT_PLUS",
  TT_MINUS: "TT_MINUS",
  TT_KEYWORD: "TT_KEYWORD",
  TT_RPARANTH: "TT_RPARANTH",
  TT_LPARANTH: "TT_LPARANTH",
  TT_EOF: "TT_EOF",
  TT_UNKNOWN: "TT_UNKNOWN",
};

const {
  TT_METRIC,
  TT_TAG,
  TT_LOGICAL_OPERATOR,
  TT_COMPARISON_OPERATOR,
  TT_ASSIGNMENT_OPERATOR,
  TT_VALID_QUOTE_OPERATORS,
  TT_NUMBER,
  TT_SPACE,
  TT_QUOTE,
  TT_FUZZ,
  TT_PLUS,
  TT_MINUS,
  TT_KEYWORD,
  TT_RPARANTH,
  TT_LPARANTH,
  TT_EOF,
  TT_UNKNOWN,
} = tokenTypes;

const getTokenType = (value) => {
  const numberRegex = /^[0-9]+(\.[0-9]+)?$/;

  switch (true) {
    case VALID_METRICS.has(value):
      return TT_METRIC;
    case VALID_TAGS.has(value):
      return TT_TAG;
    case VALID_LOGICAL_OPERATORS.has(value):
      return TT_LOGICAL_OPERATOR;
    case VALID_COMPARISON_OPERATORS.has(value):
      return TT_COMPARISON_OPERATOR;
    case VALID_ASSIGNMENT_OPERATORS.has(value):
      return TT_ASSIGNMENT_OPERATOR;
    case numberRegex.test(value):
      return TT_NUMBER;
    case value === " ":
      return TT_SPACE;
    case VALID_QUOTE_OPERATORS.has(value):
      return TT_QUOTE;
    case value === "~":
      return TT_FUZZ;
    case value === "+":
      return TT_PLUS;
    case value === "-":
      return TT_MINUS;
    case value === ")":
      return TT_RPARANTH;
    case value === "(":
      return TT_LPARANTH;
    case value === "EOF":
    case value === "":
      return TT_EOF;
    default:
      return TT_UNKNOWN;
  }
};

module.exports = {
  getTokenType,
  tokenTypes,
  VALID_ASSIGNMENT_OPERATORS,
  VALID_COMPARISON_OPERATORS,
  VALID_LOGICAL_OPERATORS,
  VALID_METRICS,
  VALID_TAGS,
  TT_METRIC,
  TT_TAG,
  TT_LOGICAL_OPERATOR,
  TT_COMPARISON_OPERATOR,
  TT_ASSIGNMENT_OPERATOR,
  TT_KEYWORD,
  TT_NUMBER,
  TT_SPACE,
  TT_QUOTE,
  TT_FUZZ,
  TT_PLUS,
  TT_MINUS,
  TT_RPARANTH,
  TT_LPARANTH,
  TT_EOF,
  TT_UNKNOWN,
};

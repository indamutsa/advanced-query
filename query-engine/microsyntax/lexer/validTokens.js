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
  "description",
  "ext",
  "involvedOperations",
  "license",
  "name",
  "project",
  "storageUrl",
  "type",
  "uniqueName",
  "conformsTo",
  "hasAttribute",
  "isTransformable",
]);

const VALID_LOGICAL_OPERATORS = new Set(["AND", "OR", "NOT", " "]);
const VALID_COMPARISON_OPERATORS = new Set(["==", "<", ">", "<=", ">="]);
const VALID_ASSIGNMENT_OPERATORS = new Set(["=", ":"]);
const VALID_NUMERIC_TAGS = new Set(["size", "createdAt", "updatedAt"]);

const tokenTypes = {
  TT_LOGICAL_OPERATOR: "TT_LOGICAL_OPERATOR",
  TT_COMPARISON_OPERATOR: "TT_COMPARISON_OPERATOR",
  TT_ASSIGNMENT_OPERATOR: "TT_ASSIGNMENT_OPERATOR",
  TT_NUMBER: "TT_NUMBER",
  TT_METRIC: "TT_METRIC",
  TT_TAG: "TT_TAG",
  TT_NUMERIC_TAG: "TT_NUMERIC_TAG",
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
  TT_NUMERIC_TAG,
  TT_LOGICAL_OPERATOR,
  TT_COMPARISON_OPERATOR,
  TT_ASSIGNMENT_OPERATOR,
  TT_NUMBER,
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
  const numberRegex = /^-?\d*(\.\d+)?$/; // /^[0-9]+(\.[0-9]+)?$/;

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
    case VALID_NUMERIC_TAGS.has(value):
      return TT_NUMERIC_TAG;
    case numberRegex.test(value):
      return TT_NUMBER;
    case value === "'":
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
  VALID_NUMERIC_TAGS,
  TT_METRIC,
  TT_TAG,
  TT_NUMERIC_TAG,
  TT_LOGICAL_OPERATOR,
  TT_COMPARISON_OPERATOR,
  TT_ASSIGNMENT_OPERATOR,
  TT_KEYWORD,
  TT_NUMBER,
  TT_QUOTE,
  TT_FUZZ,
  TT_PLUS,
  TT_MINUS,
  TT_RPARANTH,
  TT_LPARANTH,
  TT_EOF,
  TT_UNKNOWN,
};

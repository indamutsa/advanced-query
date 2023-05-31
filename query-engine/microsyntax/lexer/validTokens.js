const VALID_METRICS = [
  "acfmc", "aiflmc", "amc", "attr", "attrh", "avgattr", "avgref", 
  "ccfmc", "cflmc", "ciflmc", "cmc", "iflmc", "lmc", "maxhl", 
  "maxhs", "mc", "mcwsp", "mtnb", "rec_cont", "ref", "refcc", 
  "refeop", "sf", "sfh"
];

const VALID_TAGS = [
  "accessControl", "content", "createdAt", "description", "ext", 
  "involvedOperations", "license", "name", "project", "size", 
  "storageUrl", "type", "unique_name", "updatedAt", "conformsTo", 
  "hasAttribute", "isTransformable"
];

const VALID_LOGICAL_OPERATORS = [
    "AND", "OR", "NOT"
];

const VALID_COMPARISON_OPERATORS = [
    "==", "<", ">", "<=", ">="
];

const VALID_ASSIGNMENT_OPERATORS = [
    "=", ":"
];

const VALID_QUOTES = [
    '"', "'"
];

module.exports = {
  VALID_QUOTES,
  VALID_METRICS,
  VALID_TAGS,
  VALID_LOGICAL_OPERATORS,
  VALID_COMPARISON_OPERATORS,
  VALID_ASSIGNMENT_OPERATORS,
};

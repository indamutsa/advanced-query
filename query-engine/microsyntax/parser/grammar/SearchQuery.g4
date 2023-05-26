grammar SearchQuery;

searchQuery: term EOF;
term: factor (operator factor)*;
factor:
	NUMBER
	| KEYWORD
	| tag
	| metric
	| exactKeyword
	| '(' term ')';
operator:
	AND
	| OR
	| NOT
	| SPACE
	| COLON
	| GT
	| LT
	| EQ
	| GTE
	| LTE;
keyword: KEYWORD;
number: NUMBER;
tag: TAG COLON tagValue;
tagValue: keyword | number | exactKeyword;
metric: METRIC metricOperator NUMBER;
metricOperator: GT | LT | EQ | GTE | LTE;
exactKeyword: QUOTE STRING QUOTE;

AND: 'AND';
OR: 'OR';
NOT: 'NOT';
COLON: ':';
GT: '>';
LT: '<';
EQ: '=';
GTE: '>=';
LTE: '<=';

// Lexer rules
KEYWORD:
	STRING (SPACE STRING)*; // Modify as per your requirements);
NUMBER: [0-9]+; // Modify as per your requirements
TAG: 'TT_TAG';
METRIC: 'TT_METRIC';
SPACE: ' ';
QUOTE: '\'';
STRING:
	~('\'')+; // Sequence of characters excluding single quote

// grammar SearchQuery;

// searchQuery: term EOF; term: factor (operator factor)*; factor: NUMBER | KEYWORD | tag | metric |
// exactKeyword | '(' term ')'; operator: 'AND' | 'OR' | 'NOT' | SPACE | ':' | '>' | '<' | '=' |
// '>=' | '<='; keyword: KEYWORD; number: NUMBER; tag: TAG ':' tagValue; tagValue: keyword | number
// | exactKeyword; metric: METRIC metricOperator NUMBER; metricOperator: '>' | '<' | '=' | '>=' |
// '<='; exactKeyword: '\'' STRING '\''; string: STRING; space: SPACE;

// // Lexer rules KEYWORD: ([a-zA-Z0-9_] | '\\' .)+; // Modify as per your requirements NUMBER:
// [0-9]+; // Modify as per your requirements TAG: 'TT_TAG'; METRIC: 'TT_METRIC'; SPACE: ' ';
// STRING: ~('\'' | ' ')+; // Sequence of characters excluding single quote and spaces


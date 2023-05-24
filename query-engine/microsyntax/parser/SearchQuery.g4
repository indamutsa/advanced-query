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
	'AND'
	| 'OR'
	| 'NOT'
	| SPACE
	| ':'
	| '>'
	| '<'
	| '='
	| '>='
	| '<=';
keyword: KEYWORD;
number: NUMBER;
tag: TAG ':' tagValue;
tagValue: keyword | number | exactKeyword;
metric: METRIC metricOperator NUMBER;
metricOperator: '>' | '<' | '=' | '>=' | '<=';
exactKeyword: '\'' STRING '\'';
string: STRING;
space: SPACE;

// Lexer rules
KEYWORD: ([a-zA-Z0-9_] | '\\' .)+; // Modify as per your requirements
NUMBER: [0-9]+; // Modify as per your requirements
TAG: 'TT_TAG';
METRIC: 'TT_METRIC';
SPACE: ' ';
STRING:
	~('\'' | ' ')+; // Sequence of characters excluding single quote and spaces


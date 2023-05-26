// grammar searchQ;

// searchQuery: term EOF;

// term: factor (boolean_operator factor)*;

// factor: text | tag | metric | '(' term ')';

// boolean_operator: AND | OR | NOT | SPACE;

// operator: GT | LT | EQ | GTE | LTE;

// text: KEYWORD | NUMBER | exactText;

// tag: TAG_ID ':' tagValue;

// tagValue: KEYWORD | NUMBER | exactText;

// metric: (METRIC_ID) operator NUMBER;

// exactText: '\'' (KEYWORD | SPACE)+ '\'';

// TAG_ID: 'accessControl' | 'content' | 'createdAt' | 'conformsTo' | 'hasAttribute' |
// 'isTransformable';

// NUMERICAL_TAG_ID: 'size' | 'createdAt' | 'updatedAt';

// METRIC_ID: 'mc' | 'sf' | 'cmc';

// AND: 'AND';

// OR: 'OR';

// NOT: 'NOT';

// GT: '>';

// LT: '<';

// EQ: '=';

// GTE: '>=';

// LTE: '<=';

// NUMBER: '0' ..'9'+;

// KEYWORD: ~('\'' | ' ')+; // Sequence of characters excluding single quote and spaces

// SPACE: ' ';

// WS: [ \t\n\r]+ -> skip;

//
// 
//
// 
//
// 
//
// 
//
// 
//
// 
//
// 
//
// 
//
// 
//
// 
//
// 
//
// 
//
// 
//
// 
//
// 
//
// 
//
// ------------------------------------------------------------------------------------------------------------------------
// grammar SearchQuery;

// searchQuery: term EOF;

// term: factor (operator factor)*;

// factor: number | keyword | tag | metric | exactKeyword | LPARANTH term RPARANTH;

// operator: AND | OR | NOT | COLON | GT | LT | EQ | GTE | LTE;

// keyword: KEYWORD;

// number: NUMBER;

// tag: TAG COLON tagValue;

// tagValue: keyword | number | exactKeyword;

// metric: METRIC metricOperator number;

// metricOperator: GT | LT | EQ | GTE | LTE;

// exactKeyword: QUOTE KEYWORD QUOTE;

// AND: 'AND' SPACE;

// OR: 'OR' SPACE;

// NOT: 'NOT' SPACE;

// COLON: ':';

// GT: '>';

// LT: '<';

// EQ: '==';

// GTE: '>=';

// LTE: '<=';

// LPARANTH: '(';

// RPARANTH: ')';

// // Lexer rules KEYWORD: (ALPHANUM | ESCAPED_CHAR | ' ')+;

// NUMBER: (DIGIT+ ('.' DIGIT+)?) | ('.' DIGIT+);

// TAG: 'TT_TAG';

// METRIC: 'TT_METRIC';

// SPACE: ' ';

// QUOTE: '\'';

// ALPHANUM: [a-zA-Z0-9];

// ESCAPED_CHAR: '\\' .;

// fragment DIGIT: [0-9];

//
// 
//
// 
//
// 
//
// 
//
// 
//
// 
//
// 
//
// 
//
// 
//
// 
//
// 
//
// 
//
// 
//
// 
//
// 
//
// 
//
// ------------------------------------------------------------------------------------------------------------------------
// FIRST WORKING GRAMMAR
// ------------------------------------------------------------------------------------------------------------------------
grammar searchQ;

searchQuery: term EOF;
term: factor (boolen_operator factor)*;
factor: text | tag | metric | '(' term ')';

boolen_operator: 'AND' | 'OR' | 'NOT' | SPACE;

operator: '>' | '<' | '=' | '>=' | '<=';

text: keyword | number | exactText;
keyword: ~('\'' | ' ')+; // Sequence of characters excluding single quote and spaces;
number: '0' ..'9'+;
tag: tag_id ':' tagValue;
tagValue: keyword | number | exactText;
metric: metric_id operator number;
exactText: '\'' keyword+ '\'';
tag_id:
	'accessControl'
	| 'content'
	| 'createdAt'
	| 'conformsTo'
	| 'hasAttribute'
	| 'isTransformable';
metric_id: 'mc' | 'sf' | 'cmc';
SPACE: ' ';
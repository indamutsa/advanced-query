grammar search;

searchQuery: term EOF;
term: factor (boolean_operator factor)*;
factor: text | tag | expression | LPARANTH term RPARANTH;
boolean_operator: AND | OR | NOT | SPACE;
operator: GT | LT | EQ | GTE | LTE;
text: KEYWORD | NUMBER | exactText;
exactText: QUOTE KEYWORD (SPACE KEYWORD)+ QUOTE;
tag: (TAG_ID | NUMERICAL_TAG_ID) EQASSIGN tagValue;
tagValue: KEYWORD | NUMBER | exactText;
expression: numericalExpr | metric_EXPR;
metric_EXPR: METRIC_ID operator NUMBER;
numericalExpr: NUMERICAL_TAG_ID operator NUMBER;
TAG_ID:
	'accessControl'
	| 'content'
	| 'description'
	| 'ext'
	| 'involvedOperations'
	| 'license'
	| 'name'
	| 'project'
	| 'storageUrl'
	| 'type'
	| 'uniqueName'
	| 'conformsTo'
	| 'hasAttribute'
	| 'isTransformable';
NUMERICAL_TAG_ID: 'size' | 'createdAt' | 'updatedAt';
METRIC_ID:
	'acfmc'
	| 'aiflmc'
	| 'amc'
	| 'attr'
	| 'attrh'
	| 'avgattr'
	| 'avgref'
	| 'ccfmc'
	| 'cflmc'
	| 'ciflmc'
	| 'cmc'
	| 'iflmc'
	| 'lmc'
	| 'maxhl'
	| 'maxhs'
	| 'mc'
	| 'mcwsp'
	| 'mtnb'
	| 'rec_cont'
	| 'ref'
	| 'refcc'
	| 'refeop'
	| 'sf'
	| 'sfh';

AND: 'AND';
OR: 'OR';
NOT: 'NOT';
GT: '>';
LT: '<';
EQ: '==';
EQASSIGN: '=';
GTE: '>=';
LTE: '<=';
NUMBER: '0' ..'9'+;
KEYWORD:
	~('\'' | ' ')+; // Sequence of characters excluding single quote and spaces

LPARANTH: '(';
RPARANTH: ')';
SPACE: ' ';
QUOTE: '\'' | '"';

WS: [ \t\n\r]+ -> skip;

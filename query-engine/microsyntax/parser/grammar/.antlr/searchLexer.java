// Generated from /home/arsene/Project/school-projects/mdeforge/advanced-query/query-engine/microsyntax/parser/grammar/search.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class searchLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TAG_ID=1, NUMERICAL_TAG_ID=2, METRIC_ID=3, AND=4, OR=5, NOT=6, GT=7, LT=8, 
		EQ=9, EQASSIGN=10, GTE=11, LTE=12, NUMBER=13, KEYWORD=14, LPARANTH=15, 
		RPARANTH=16, SPACE=17, QUOTE=18, WS=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"TAG_ID", "NUMERICAL_TAG_ID", "METRIC_ID", "AND", "OR", "NOT", "GT", 
			"LT", "EQ", "EQASSIGN", "GTE", "LTE", "NUMBER", "KEYWORD", "LPARANTH", 
			"RPARANTH", "SPACE", "QUOTE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'AND'", "'OR'", "'NOT'", "'>'", "'<'", "'=='", 
			"'='", "'>='", "'<='", null, null, "'('", "')'", "' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TAG_ID", "NUMERICAL_TAG_ID", "METRIC_ID", "AND", "OR", "NOT", 
			"GT", "LT", "EQ", "EQASSIGN", "GTE", "LTE", "NUMBER", "KEYWORD", "LPARANTH", 
			"RPARANTH", "SPACE", "QUOTE", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public searchLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "search.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25\u016a\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\u00ad"+
		"\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\5\3\u00c5\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0136"+
		"\n\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3"+
		"\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\6\16\u0153\n\16\r\16\16"+
		"\16\u0154\3\17\6\17\u0158\n\17\r\17\16\17\u0159\3\20\3\20\3\21\3\21\3"+
		"\22\3\22\3\23\3\23\3\24\6\24\u0165\n\24\r\24\16\24\u0166\3\24\3\24\2\2"+
		"\25\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25\3\2\5\4\2\"\"))\4\2$$))\5\2\13\f\17\17\"\""+
		"\2\u0192\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\3\u00ac\3\2\2\2\5\u00c4\3\2\2\2\7"+
		"\u0135\3\2\2\2\t\u0137\3\2\2\2\13\u013b\3\2\2\2\r\u013e\3\2\2\2\17\u0142"+
		"\3\2\2\2\21\u0144\3\2\2\2\23\u0146\3\2\2\2\25\u0149\3\2\2\2\27\u014b\3"+
		"\2\2\2\31\u014e\3\2\2\2\33\u0152\3\2\2\2\35\u0157\3\2\2\2\37\u015b\3\2"+
		"\2\2!\u015d\3\2\2\2#\u015f\3\2\2\2%\u0161\3\2\2\2\'\u0164\3\2\2\2)*\7"+
		"c\2\2*+\7e\2\2+,\7e\2\2,-\7g\2\2-.\7u\2\2./\7u\2\2/\60\7E\2\2\60\61\7"+
		"q\2\2\61\62\7p\2\2\62\63\7v\2\2\63\64\7t\2\2\64\65\7q\2\2\65\u00ad\7n"+
		"\2\2\66\67\7e\2\2\678\7q\2\289\7p\2\29:\7v\2\2:;\7g\2\2;<\7p\2\2<\u00ad"+
		"\7v\2\2=>\7f\2\2>?\7g\2\2?@\7u\2\2@A\7e\2\2AB\7t\2\2BC\7k\2\2CD\7r\2\2"+
		"DE\7v\2\2EF\7k\2\2FG\7q\2\2G\u00ad\7p\2\2HI\7g\2\2IJ\7z\2\2J\u00ad\7v"+
		"\2\2KL\7k\2\2LM\7p\2\2MN\7x\2\2NO\7q\2\2OP\7n\2\2PQ\7x\2\2QR\7g\2\2RS"+
		"\7f\2\2ST\7Q\2\2TU\7r\2\2UV\7g\2\2VW\7t\2\2WX\7c\2\2XY\7v\2\2YZ\7k\2\2"+
		"Z[\7q\2\2[\\\7p\2\2\\\u00ad\7u\2\2]^\7n\2\2^_\7k\2\2_`\7e\2\2`a\7g\2\2"+
		"ab\7p\2\2bc\7u\2\2c\u00ad\7g\2\2de\7p\2\2ef\7c\2\2fg\7o\2\2g\u00ad\7g"+
		"\2\2hi\7r\2\2ij\7t\2\2jk\7q\2\2kl\7l\2\2lm\7g\2\2mn\7e\2\2n\u00ad\7v\2"+
		"\2op\7u\2\2pq\7v\2\2qr\7q\2\2rs\7t\2\2st\7c\2\2tu\7i\2\2uv\7g\2\2vw\7"+
		"W\2\2wx\7t\2\2x\u00ad\7n\2\2yz\7v\2\2z{\7{\2\2{|\7r\2\2|\u00ad\7g\2\2"+
		"}~\7w\2\2~\177\7p\2\2\177\u0080\7k\2\2\u0080\u0081\7s\2\2\u0081\u0082"+
		"\7w\2\2\u0082\u0083\7g\2\2\u0083\u0084\7P\2\2\u0084\u0085\7c\2\2\u0085"+
		"\u0086\7o\2\2\u0086\u00ad\7g\2\2\u0087\u0088\7e\2\2\u0088\u0089\7q\2\2"+
		"\u0089\u008a\7p\2\2\u008a\u008b\7h\2\2\u008b\u008c\7q\2\2\u008c\u008d"+
		"\7t\2\2\u008d\u008e\7o\2\2\u008e\u008f\7u\2\2\u008f\u0090\7V\2\2\u0090"+
		"\u00ad\7q\2\2\u0091\u0092\7j\2\2\u0092\u0093\7c\2\2\u0093\u0094\7u\2\2"+
		"\u0094\u0095\7C\2\2\u0095\u0096\7v\2\2\u0096\u0097\7v\2\2\u0097\u0098"+
		"\7t\2\2\u0098\u0099\7k\2\2\u0099\u009a\7d\2\2\u009a\u009b\7w\2\2\u009b"+
		"\u009c\7v\2\2\u009c\u00ad\7g\2\2\u009d\u009e\7k\2\2\u009e\u009f\7u\2\2"+
		"\u009f\u00a0\7V\2\2\u00a0\u00a1\7t\2\2\u00a1\u00a2\7c\2\2\u00a2\u00a3"+
		"\7p\2\2\u00a3\u00a4\7u\2\2\u00a4\u00a5\7h\2\2\u00a5\u00a6\7q\2\2\u00a6"+
		"\u00a7\7t\2\2\u00a7\u00a8\7o\2\2\u00a8\u00a9\7c\2\2\u00a9\u00aa\7d\2\2"+
		"\u00aa\u00ab\7n\2\2\u00ab\u00ad\7g\2\2\u00ac)\3\2\2\2\u00ac\66\3\2\2\2"+
		"\u00ac=\3\2\2\2\u00acH\3\2\2\2\u00acK\3\2\2\2\u00ac]\3\2\2\2\u00acd\3"+
		"\2\2\2\u00ach\3\2\2\2\u00aco\3\2\2\2\u00acy\3\2\2\2\u00ac}\3\2\2\2\u00ac"+
		"\u0087\3\2\2\2\u00ac\u0091\3\2\2\2\u00ac\u009d\3\2\2\2\u00ad\4\3\2\2\2"+
		"\u00ae\u00af\7u\2\2\u00af\u00b0\7k\2\2\u00b0\u00b1\7|\2\2\u00b1\u00c5"+
		"\7g\2\2\u00b2\u00b3\7e\2\2\u00b3\u00b4\7t\2\2\u00b4\u00b5\7g\2\2\u00b5"+
		"\u00b6\7c\2\2\u00b6\u00b7\7v\2\2\u00b7\u00b8\7g\2\2\u00b8\u00b9\7f\2\2"+
		"\u00b9\u00ba\7C\2\2\u00ba\u00c5\7v\2\2\u00bb\u00bc\7w\2\2\u00bc\u00bd"+
		"\7r\2\2\u00bd\u00be\7f\2\2\u00be\u00bf\7c\2\2\u00bf\u00c0\7v\2\2\u00c0"+
		"\u00c1\7g\2\2\u00c1\u00c2\7f\2\2\u00c2\u00c3\7C\2\2\u00c3\u00c5\7v\2\2"+
		"\u00c4\u00ae\3\2\2\2\u00c4\u00b2\3\2\2\2\u00c4\u00bb\3\2\2\2\u00c5\6\3"+
		"\2\2\2\u00c6\u00c7\7c\2\2\u00c7\u00c8\7e\2\2\u00c8\u00c9\7h\2\2\u00c9"+
		"\u00ca\7o\2\2\u00ca\u0136\7e\2\2\u00cb\u00cc\7c\2\2\u00cc\u00cd\7k\2\2"+
		"\u00cd\u00ce\7h\2\2\u00ce\u00cf\7n\2\2\u00cf\u00d0\7o\2\2\u00d0\u0136"+
		"\7e\2\2\u00d1\u00d2\7c\2\2\u00d2\u00d3\7o\2\2\u00d3\u0136\7e\2\2\u00d4"+
		"\u00d5\7c\2\2\u00d5\u00d6\7v\2\2\u00d6\u00d7\7v\2\2\u00d7\u0136\7t\2\2"+
		"\u00d8\u00d9\7c\2\2\u00d9\u00da\7v\2\2\u00da\u00db\7v\2\2\u00db\u00dc"+
		"\7t\2\2\u00dc\u0136\7j\2\2\u00dd\u00de\7c\2\2\u00de\u00df\7x\2\2\u00df"+
		"\u00e0\7i\2\2\u00e0\u00e1\7c\2\2\u00e1\u00e2\7v\2\2\u00e2\u00e3\7v\2\2"+
		"\u00e3\u0136\7t\2\2\u00e4\u00e5\7c\2\2\u00e5\u00e6\7x\2\2\u00e6\u00e7"+
		"\7i\2\2\u00e7\u00e8\7t\2\2\u00e8\u00e9\7g\2\2\u00e9\u0136\7h\2\2\u00ea"+
		"\u00eb\7e\2\2\u00eb\u00ec\7e\2\2\u00ec\u00ed\7h\2\2\u00ed\u00ee\7o\2\2"+
		"\u00ee\u0136\7e\2\2\u00ef\u00f0\7e\2\2\u00f0\u00f1\7h\2\2\u00f1\u00f2"+
		"\7n\2\2\u00f2\u00f3\7o\2\2\u00f3\u0136\7e\2\2\u00f4\u00f5\7e\2\2\u00f5"+
		"\u00f6\7k\2\2\u00f6\u00f7\7h\2\2\u00f7\u00f8\7n\2\2\u00f8\u00f9\7o\2\2"+
		"\u00f9\u0136\7e\2\2\u00fa\u00fb\7e\2\2\u00fb\u00fc\7o\2\2\u00fc\u0136"+
		"\7e\2\2\u00fd\u00fe\7k\2\2\u00fe\u00ff\7h\2\2\u00ff\u0100\7n\2\2\u0100"+
		"\u0101\7o\2\2\u0101\u0136\7e\2\2\u0102\u0103\7n\2\2\u0103\u0104\7o\2\2"+
		"\u0104\u0136\7e\2\2\u0105\u0106\7o\2\2\u0106\u0107\7c\2\2\u0107\u0108"+
		"\7z\2\2\u0108\u0109\7j\2\2\u0109\u0136\7n\2\2\u010a\u010b\7o\2\2\u010b"+
		"\u010c\7c\2\2\u010c\u010d\7z\2\2\u010d\u010e\7j\2\2\u010e\u0136\7u\2\2"+
		"\u010f\u0110\7o\2\2\u0110\u0136\7e\2\2\u0111\u0112\7o\2\2\u0112\u0113"+
		"\7e\2\2\u0113\u0114\7y\2\2\u0114\u0115\7u\2\2\u0115\u0136\7r\2\2\u0116"+
		"\u0117\7o\2\2\u0117\u0118\7v\2\2\u0118\u0119\7p\2\2\u0119\u0136\7d\2\2"+
		"\u011a\u011b\7t\2\2\u011b\u011c\7g\2\2\u011c\u011d\7e\2\2\u011d\u011e"+
		"\7a\2\2\u011e\u011f\7e\2\2\u011f\u0120\7q\2\2\u0120\u0121\7p\2\2\u0121"+
		"\u0136\7v\2\2\u0122\u0123\7t\2\2\u0123\u0124\7g\2\2\u0124\u0136\7h\2\2"+
		"\u0125\u0126\7t\2\2\u0126\u0127\7g\2\2\u0127\u0128\7h\2\2\u0128\u0129"+
		"\7e\2\2\u0129\u0136\7e\2\2\u012a\u012b\7t\2\2\u012b\u012c\7g\2\2\u012c"+
		"\u012d\7h\2\2\u012d\u012e\7g\2\2\u012e\u012f\7q\2\2\u012f\u0136\7r\2\2"+
		"\u0130\u0131\7u\2\2\u0131\u0136\7h\2\2\u0132\u0133\7u\2\2\u0133\u0134"+
		"\7h\2\2\u0134\u0136\7j\2\2\u0135\u00c6\3\2\2\2\u0135\u00cb\3\2\2\2\u0135"+
		"\u00d1\3\2\2\2\u0135\u00d4\3\2\2\2\u0135\u00d8\3\2\2\2\u0135\u00dd\3\2"+
		"\2\2\u0135\u00e4\3\2\2\2\u0135\u00ea\3\2\2\2\u0135\u00ef\3\2\2\2\u0135"+
		"\u00f4\3\2\2\2\u0135\u00fa\3\2\2\2\u0135\u00fd\3\2\2\2\u0135\u0102\3\2"+
		"\2\2\u0135\u0105\3\2\2\2\u0135\u010a\3\2\2\2\u0135\u010f\3\2\2\2\u0135"+
		"\u0111\3\2\2\2\u0135\u0116\3\2\2\2\u0135\u011a\3\2\2\2\u0135\u0122\3\2"+
		"\2\2\u0135\u0125\3\2\2\2\u0135\u012a\3\2\2\2\u0135\u0130\3\2\2\2\u0135"+
		"\u0132\3\2\2\2\u0136\b\3\2\2\2\u0137\u0138\7C\2\2\u0138\u0139\7P\2\2\u0139"+
		"\u013a\7F\2\2\u013a\n\3\2\2\2\u013b\u013c\7Q\2\2\u013c\u013d\7T\2\2\u013d"+
		"\f\3\2\2\2\u013e\u013f\7P\2\2\u013f\u0140\7Q\2\2\u0140\u0141\7V\2\2\u0141"+
		"\16\3\2\2\2\u0142\u0143\7@\2\2\u0143\20\3\2\2\2\u0144\u0145\7>\2\2\u0145"+
		"\22\3\2\2\2\u0146\u0147\7?\2\2\u0147\u0148\7?\2\2\u0148\24\3\2\2\2\u0149"+
		"\u014a\7?\2\2\u014a\26\3\2\2\2\u014b\u014c\7@\2\2\u014c\u014d\7?\2\2\u014d"+
		"\30\3\2\2\2\u014e\u014f\7>\2\2\u014f\u0150\7?\2\2\u0150\32\3\2\2\2\u0151"+
		"\u0153\4\62;\2\u0152\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0152\3\2"+
		"\2\2\u0154\u0155\3\2\2\2\u0155\34\3\2\2\2\u0156\u0158\n\2\2\2\u0157\u0156"+
		"\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u0157\3\2\2\2\u0159\u015a\3\2\2\2\u015a"+
		"\36\3\2\2\2\u015b\u015c\7*\2\2\u015c \3\2\2\2\u015d\u015e\7+\2\2\u015e"+
		"\"\3\2\2\2\u015f\u0160\7\"\2\2\u0160$\3\2\2\2\u0161\u0162\t\3\2\2\u0162"+
		"&\3\2\2\2\u0163\u0165\t\4\2\2\u0164\u0163\3\2\2\2\u0165\u0166\3\2\2\2"+
		"\u0166\u0164\3\2\2\2\u0166\u0167\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u0169"+
		"\b\24\2\2\u0169(\3\2\2\2\t\2\u00ac\u00c4\u0135\u0154\u0159\u0166\3\b\2"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
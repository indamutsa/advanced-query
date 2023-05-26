// Generated from /home/arsene/Project/school-projects/mdeforge/advanced-query/query-engine/microsyntax/parser/searchQ.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SearchQLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, TAG_ID=5, METRIC_ID=6, AND=7, OR=8, NOT=9, 
		GT=10, LT=11, EQ=12, GTE=13, LTE=14, NUMBER=15, KEYWORD=16, SPACE=17, 
		WS=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "TAG_ID", "METRIC_ID", "AND", "OR", "NOT", 
			"GT", "LT", "EQ", "GTE", "LTE", "NUMBER", "KEYWORD", "SPACE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "':'", "'''", null, null, "'AND'", "'OR'", "'NOT'", 
			"'>'", "'<'", "'='", "'>='", "'<='", null, null, "' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "TAG_ID", "METRIC_ID", "AND", "OR", "NOT", 
			"GT", "LT", "EQ", "GTE", "LTE", "NUMBER", "KEYWORD", "SPACE", "WS"
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


	public SearchQLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "searchQ.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24\u00a6\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6r\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\5\7{\n\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3"+
		"\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\6\20\u0095\n\20\r\20\16"+
		"\20\u0096\3\21\6\21\u009a\n\21\r\21\16\21\u009b\3\22\3\22\3\23\6\23\u00a1"+
		"\n\23\r\23\16\23\u00a2\3\23\3\23\2\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\3\2\4\4\2\""+
		"\"))\5\2\13\f\17\17\"\"\2\u00af\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2\2\5)\3\2\2\2"+
		"\7+\3\2\2\2\t-\3\2\2\2\13q\3\2\2\2\rz\3\2\2\2\17|\3\2\2\2\21\u0080\3\2"+
		"\2\2\23\u0083\3\2\2\2\25\u0087\3\2\2\2\27\u0089\3\2\2\2\31\u008b\3\2\2"+
		"\2\33\u008d\3\2\2\2\35\u0090\3\2\2\2\37\u0094\3\2\2\2!\u0099\3\2\2\2#"+
		"\u009d\3\2\2\2%\u00a0\3\2\2\2\'(\7*\2\2(\4\3\2\2\2)*\7+\2\2*\6\3\2\2\2"+
		"+,\7<\2\2,\b\3\2\2\2-.\7)\2\2.\n\3\2\2\2/\60\7c\2\2\60\61\7e\2\2\61\62"+
		"\7e\2\2\62\63\7g\2\2\63\64\7u\2\2\64\65\7u\2\2\65\66\7E\2\2\66\67\7q\2"+
		"\2\678\7p\2\289\7v\2\29:\7t\2\2:;\7q\2\2;r\7n\2\2<=\7e\2\2=>\7q\2\2>?"+
		"\7p\2\2?@\7v\2\2@A\7g\2\2AB\7p\2\2Br\7v\2\2CD\7e\2\2DE\7t\2\2EF\7g\2\2"+
		"FG\7c\2\2GH\7v\2\2HI\7g\2\2IJ\7f\2\2JK\7C\2\2Kr\7v\2\2LM\7e\2\2MN\7q\2"+
		"\2NO\7p\2\2OP\7h\2\2PQ\7q\2\2QR\7t\2\2RS\7o\2\2ST\7u\2\2TU\7V\2\2Ur\7"+
		"q\2\2VW\7j\2\2WX\7c\2\2XY\7u\2\2YZ\7C\2\2Z[\7v\2\2[\\\7v\2\2\\]\7t\2\2"+
		"]^\7k\2\2^_\7d\2\2_`\7w\2\2`a\7v\2\2ar\7g\2\2bc\7k\2\2cd\7u\2\2de\7V\2"+
		"\2ef\7t\2\2fg\7c\2\2gh\7p\2\2hi\7u\2\2ij\7h\2\2jk\7q\2\2kl\7t\2\2lm\7"+
		"o\2\2mn\7c\2\2no\7d\2\2op\7n\2\2pr\7g\2\2q/\3\2\2\2q<\3\2\2\2qC\3\2\2"+
		"\2qL\3\2\2\2qV\3\2\2\2qb\3\2\2\2r\f\3\2\2\2st\7o\2\2t{\7e\2\2uv\7u\2\2"+
		"v{\7h\2\2wx\7e\2\2xy\7o\2\2y{\7e\2\2zs\3\2\2\2zu\3\2\2\2zw\3\2\2\2{\16"+
		"\3\2\2\2|}\7C\2\2}~\7P\2\2~\177\7F\2\2\177\20\3\2\2\2\u0080\u0081\7Q\2"+
		"\2\u0081\u0082\7T\2\2\u0082\22\3\2\2\2\u0083\u0084\7P\2\2\u0084\u0085"+
		"\7Q\2\2\u0085\u0086\7V\2\2\u0086\24\3\2\2\2\u0087\u0088\7@\2\2\u0088\26"+
		"\3\2\2\2\u0089\u008a\7>\2\2\u008a\30\3\2\2\2\u008b\u008c\7?\2\2\u008c"+
		"\32\3\2\2\2\u008d\u008e\7@\2\2\u008e\u008f\7?\2\2\u008f\34\3\2\2\2\u0090"+
		"\u0091\7>\2\2\u0091\u0092\7?\2\2\u0092\36\3\2\2\2\u0093\u0095\4\62;\2"+
		"\u0094\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097"+
		"\3\2\2\2\u0097 \3\2\2\2\u0098\u009a\n\2\2\2\u0099\u0098\3\2\2\2\u009a"+
		"\u009b\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\"\3\2\2\2"+
		"\u009d\u009e\7\"\2\2\u009e$\3\2\2\2\u009f\u00a1\t\3\2\2\u00a0\u009f\3"+
		"\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3"+
		"\u00a4\3\2\2\2\u00a4\u00a5\b\23\2\2\u00a5&\3\2\2\2\b\2qz\u0096\u009b\u00a2"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
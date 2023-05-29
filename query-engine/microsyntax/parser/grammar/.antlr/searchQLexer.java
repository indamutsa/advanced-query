// Generated from /home/arsene/Project/school-projects/mdeforge/advanced-query/query-engine/microsyntax/parser/grammar/searchQ.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class searchQLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, SPACE=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "SPACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'AND'", "'OR'", "'NOT'", "'>'", "'<'", "'='", "'>='", 
			"'<='", "'''", "':'", "'accessControl'", "'content'", "'createdAt'", 
			"'conformsTo'", "'hasAttribute'", "'isTransformable'", "'mc'", "'sf'", 
			"'cmc'", "' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "SPACE"
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


	public searchQLexer(CharStream input) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\30\u00a2\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3"+
		"\25\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\2\2\30\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30\3\2\2\2\u00a1\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\2-\3\2\2\2\3/\3\2\2\2\5\61\3\2\2\2\7\63\3\2\2\2\t\67\3\2\2\2"+
		"\13:\3\2\2\2\r>\3\2\2\2\17@\3\2\2\2\21B\3\2\2\2\23D\3\2\2\2\25G\3\2\2"+
		"\2\27J\3\2\2\2\31L\3\2\2\2\33N\3\2\2\2\35\\\3\2\2\2\37d\3\2\2\2!n\3\2"+
		"\2\2#y\3\2\2\2%\u0086\3\2\2\2\'\u0096\3\2\2\2)\u0099\3\2\2\2+\u009c\3"+
		"\2\2\2-\u00a0\3\2\2\2/\60\7*\2\2\60\4\3\2\2\2\61\62\7+\2\2\62\6\3\2\2"+
		"\2\63\64\7C\2\2\64\65\7P\2\2\65\66\7F\2\2\66\b\3\2\2\2\678\7Q\2\289\7"+
		"T\2\29\n\3\2\2\2:;\7P\2\2;<\7Q\2\2<=\7V\2\2=\f\3\2\2\2>?\7@\2\2?\16\3"+
		"\2\2\2@A\7>\2\2A\20\3\2\2\2BC\7?\2\2C\22\3\2\2\2DE\7@\2\2EF\7?\2\2F\24"+
		"\3\2\2\2GH\7>\2\2HI\7?\2\2I\26\3\2\2\2JK\7)\2\2K\30\3\2\2\2LM\7<\2\2M"+
		"\32\3\2\2\2NO\7c\2\2OP\7e\2\2PQ\7e\2\2QR\7g\2\2RS\7u\2\2ST\7u\2\2TU\7"+
		"E\2\2UV\7q\2\2VW\7p\2\2WX\7v\2\2XY\7t\2\2YZ\7q\2\2Z[\7n\2\2[\34\3\2\2"+
		"\2\\]\7e\2\2]^\7q\2\2^_\7p\2\2_`\7v\2\2`a\7g\2\2ab\7p\2\2bc\7v\2\2c\36"+
		"\3\2\2\2de\7e\2\2ef\7t\2\2fg\7g\2\2gh\7c\2\2hi\7v\2\2ij\7g\2\2jk\7f\2"+
		"\2kl\7C\2\2lm\7v\2\2m \3\2\2\2no\7e\2\2op\7q\2\2pq\7p\2\2qr\7h\2\2rs\7"+
		"q\2\2st\7t\2\2tu\7o\2\2uv\7u\2\2vw\7V\2\2wx\7q\2\2x\"\3\2\2\2yz\7j\2\2"+
		"z{\7c\2\2{|\7u\2\2|}\7C\2\2}~\7v\2\2~\177\7v\2\2\177\u0080\7t\2\2\u0080"+
		"\u0081\7k\2\2\u0081\u0082\7d\2\2\u0082\u0083\7w\2\2\u0083\u0084\7v\2\2"+
		"\u0084\u0085\7g\2\2\u0085$\3\2\2\2\u0086\u0087\7k\2\2\u0087\u0088\7u\2"+
		"\2\u0088\u0089\7V\2\2\u0089\u008a\7t\2\2\u008a\u008b\7c\2\2\u008b\u008c"+
		"\7p\2\2\u008c\u008d\7u\2\2\u008d\u008e\7h\2\2\u008e\u008f\7q\2\2\u008f"+
		"\u0090\7t\2\2\u0090\u0091\7o\2\2\u0091\u0092\7c\2\2\u0092\u0093\7d\2\2"+
		"\u0093\u0094\7n\2\2\u0094\u0095\7g\2\2\u0095&\3\2\2\2\u0096\u0097\7o\2"+
		"\2\u0097\u0098\7e\2\2\u0098(\3\2\2\2\u0099\u009a\7u\2\2\u009a\u009b\7"+
		"h\2\2\u009b*\3\2\2\2\u009c\u009d\7e\2\2\u009d\u009e\7o\2\2\u009e\u009f"+
		"\7e\2\2\u009f,\3\2\2\2\u00a0\u00a1\7\"\2\2\u00a1.\3\2\2\2\3\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
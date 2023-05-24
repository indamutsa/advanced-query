// Generated from /home/arsene/Project/school-projects/mdeforge/advanced-query/query-engine/microsyntax/parser/SearchQuery.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SearchQueryLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, KEYWORD=13, NUMBER=14, TAG=15, METRIC=16, 
		SPACE=17, STRING=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "KEYWORD", "NUMBER", "TAG", "METRIC", "SPACE", 
			"STRING"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'AND'", "'OR'", "'NOT'", "':'", "'>'", "'<'", "'='", 
			"'>='", "'<='", "'''", null, null, "'TT_TAG'", "'TT_METRIC'", "' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "KEYWORD", "NUMBER", "TAG", "METRIC", "SPACE", "STRING"
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


	public SearchQueryLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SearchQuery.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24j\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3"+
		"\16\3\16\3\16\6\16J\n\16\r\16\16\16K\3\17\6\17O\n\17\r\17\16\17P\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\22\3\22\3\23\6\23g\n\23\r\23\16\23h\2\2\24\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\3\2\5\6\2\62;C\\aac|\3\2\62;\3\2))\2m\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2\2"+
		"\5)\3\2\2\2\7+\3\2\2\2\t/\3\2\2\2\13\62\3\2\2\2\r\66\3\2\2\2\178\3\2\2"+
		"\2\21:\3\2\2\2\23<\3\2\2\2\25>\3\2\2\2\27A\3\2\2\2\31D\3\2\2\2\33I\3\2"+
		"\2\2\35N\3\2\2\2\37R\3\2\2\2!Y\3\2\2\2#c\3\2\2\2%f\3\2\2\2\'(\7*\2\2("+
		"\4\3\2\2\2)*\7+\2\2*\6\3\2\2\2+,\7C\2\2,-\7P\2\2-.\7F\2\2.\b\3\2\2\2/"+
		"\60\7Q\2\2\60\61\7T\2\2\61\n\3\2\2\2\62\63\7P\2\2\63\64\7Q\2\2\64\65\7"+
		"V\2\2\65\f\3\2\2\2\66\67\7<\2\2\67\16\3\2\2\289\7@\2\29\20\3\2\2\2:;\7"+
		">\2\2;\22\3\2\2\2<=\7?\2\2=\24\3\2\2\2>?\7@\2\2?@\7?\2\2@\26\3\2\2\2A"+
		"B\7>\2\2BC\7?\2\2C\30\3\2\2\2DE\7)\2\2E\32\3\2\2\2FJ\t\2\2\2GH\7^\2\2"+
		"HJ\13\2\2\2IF\3\2\2\2IG\3\2\2\2JK\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\34\3\2"+
		"\2\2MO\t\3\2\2NM\3\2\2\2OP\3\2\2\2PN\3\2\2\2PQ\3\2\2\2Q\36\3\2\2\2RS\7"+
		"V\2\2ST\7V\2\2TU\7a\2\2UV\7V\2\2VW\7C\2\2WX\7I\2\2X \3\2\2\2YZ\7V\2\2"+
		"Z[\7V\2\2[\\\7a\2\2\\]\7O\2\2]^\7G\2\2^_\7V\2\2_`\7T\2\2`a\7K\2\2ab\7"+
		"E\2\2b\"\3\2\2\2cd\7\"\2\2d$\3\2\2\2eg\n\4\2\2fe\3\2\2\2gh\3\2\2\2hf\3"+
		"\2\2\2hi\3\2\2\2i&\3\2\2\2\7\2IKPh\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
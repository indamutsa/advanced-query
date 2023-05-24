// Generated from /home/arsene/Project/school-projects/mdeforge/advanced-query/query-engine/microsyntax/parser/SearchQuery.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SearchQueryParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, KEYWORD=13, NUMBER=14, TAG=15, METRIC=16, 
		SPACE=17, STRING=18;
	public static final int
		RULE_searchQuery = 0, RULE_term = 1, RULE_factor = 2, RULE_operator = 3, 
		RULE_keyword = 4, RULE_number = 5, RULE_tag = 6, RULE_tagValue = 7, RULE_metric = 8, 
		RULE_metricOperator = 9, RULE_exactKeyword = 10, RULE_string = 11, RULE_space = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"searchQuery", "term", "factor", "operator", "keyword", "number", "tag", 
			"tagValue", "metric", "metricOperator", "exactKeyword", "string", "space"
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

	@Override
	public String getGrammarFileName() { return "SearchQuery.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SearchQueryParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SearchQueryContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SearchQueryParser.EOF, 0); }
		public SearchQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_searchQuery; }
	}

	public final SearchQueryContext searchQuery() throws RecognitionException {
		SearchQueryContext _localctx = new SearchQueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_searchQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			term();
			setState(27);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<OperatorContext> operator() {
			return getRuleContexts(OperatorContext.class);
		}
		public OperatorContext operator(int i) {
			return getRuleContext(OperatorContext.class,i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			factor();
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << SPACE))) != 0)) {
				{
				{
				setState(30);
				operator();
				setState(31);
				factor();
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(SearchQueryParser.NUMBER, 0); }
		public TerminalNode KEYWORD() { return getToken(SearchQueryParser.KEYWORD, 0); }
		public TagContext tag() {
			return getRuleContext(TagContext.class,0);
		}
		public MetricContext metric() {
			return getRuleContext(MetricContext.class,0);
		}
		public ExactKeywordContext exactKeyword() {
			return getRuleContext(ExactKeywordContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_factor);
		try {
			setState(47);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				match(NUMBER);
				}
				break;
			case KEYWORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				match(KEYWORD);
				}
				break;
			case TAG:
				enterOuterAlt(_localctx, 3);
				{
				setState(40);
				tag();
				}
				break;
			case METRIC:
				enterOuterAlt(_localctx, 4);
				{
				setState(41);
				metric();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 5);
				{
				setState(42);
				exactKeyword();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 6);
				{
				setState(43);
				match(T__0);
				setState(44);
				term();
				setState(45);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorContext extends ParserRuleContext {
		public TerminalNode SPACE() { return getToken(SearchQueryParser.SPACE, 0); }
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << SPACE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeywordContext extends ParserRuleContext {
		public TerminalNode KEYWORD() { return getToken(SearchQueryParser.KEYWORD, 0); }
		public KeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword; }
	}

	public final KeywordContext keyword() throws RecognitionException {
		KeywordContext _localctx = new KeywordContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_keyword);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(KEYWORD);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(SearchQueryParser.NUMBER, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TagContext extends ParserRuleContext {
		public TerminalNode TAG() { return getToken(SearchQueryParser.TAG, 0); }
		public TagValueContext tagValue() {
			return getRuleContext(TagValueContext.class,0);
		}
		public TagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tag; }
	}

	public final TagContext tag() throws RecognitionException {
		TagContext _localctx = new TagContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_tag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(TAG);
			setState(56);
			match(T__5);
			setState(57);
			tagValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TagValueContext extends ParserRuleContext {
		public KeywordContext keyword() {
			return getRuleContext(KeywordContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public ExactKeywordContext exactKeyword() {
			return getRuleContext(ExactKeywordContext.class,0);
		}
		public TagValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tagValue; }
	}

	public final TagValueContext tagValue() throws RecognitionException {
		TagValueContext _localctx = new TagValueContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_tagValue);
		try {
			setState(62);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KEYWORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				keyword();
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				number();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 3);
				{
				setState(61);
				exactKeyword();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MetricContext extends ParserRuleContext {
		public TerminalNode METRIC() { return getToken(SearchQueryParser.METRIC, 0); }
		public MetricOperatorContext metricOperator() {
			return getRuleContext(MetricOperatorContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(SearchQueryParser.NUMBER, 0); }
		public MetricContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metric; }
	}

	public final MetricContext metric() throws RecognitionException {
		MetricContext _localctx = new MetricContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_metric);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(METRIC);
			setState(65);
			metricOperator();
			setState(66);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MetricOperatorContext extends ParserRuleContext {
		public MetricOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metricOperator; }
	}

	public final MetricOperatorContext metricOperator() throws RecognitionException {
		MetricOperatorContext _localctx = new MetricOperatorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_metricOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExactKeywordContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(SearchQueryParser.STRING, 0); }
		public ExactKeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exactKeyword; }
	}

	public final ExactKeywordContext exactKeyword() throws RecognitionException {
		ExactKeywordContext _localctx = new ExactKeywordContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_exactKeyword);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(T__11);
			setState(71);
			match(STRING);
			setState(72);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(SearchQueryParser.STRING, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SpaceContext extends ParserRuleContext {
		public TerminalNode SPACE() { return getToken(SearchQueryParser.SPACE, 0); }
		public SpaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_space; }
	}

	public final SpaceContext space() throws RecognitionException {
		SpaceContext _localctx = new SpaceContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_space);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(SPACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\24Q\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3$\n\3\f\3\16\3"+
		"\'\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\62\n\4\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\5\tA\n\t\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\2\2\17\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\2\4\4\2\5\r\23\23\3\2\t\r\2K\2\34\3\2\2\2\4\37\3\2\2\2\6\61"+
		"\3\2\2\2\b\63\3\2\2\2\n\65\3\2\2\2\f\67\3\2\2\2\169\3\2\2\2\20@\3\2\2"+
		"\2\22B\3\2\2\2\24F\3\2\2\2\26H\3\2\2\2\30L\3\2\2\2\32N\3\2\2\2\34\35\5"+
		"\4\3\2\35\36\7\2\2\3\36\3\3\2\2\2\37%\5\6\4\2 !\5\b\5\2!\"\5\6\4\2\"$"+
		"\3\2\2\2# \3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&\5\3\2\2\2\'%\3\2\2"+
		"\2(\62\7\20\2\2)\62\7\17\2\2*\62\5\16\b\2+\62\5\22\n\2,\62\5\26\f\2-."+
		"\7\3\2\2./\5\4\3\2/\60\7\4\2\2\60\62\3\2\2\2\61(\3\2\2\2\61)\3\2\2\2\61"+
		"*\3\2\2\2\61+\3\2\2\2\61,\3\2\2\2\61-\3\2\2\2\62\7\3\2\2\2\63\64\t\2\2"+
		"\2\64\t\3\2\2\2\65\66\7\17\2\2\66\13\3\2\2\2\678\7\20\2\28\r\3\2\2\29"+
		":\7\21\2\2:;\7\b\2\2;<\5\20\t\2<\17\3\2\2\2=A\5\n\6\2>A\5\f\7\2?A\5\26"+
		"\f\2@=\3\2\2\2@>\3\2\2\2@?\3\2\2\2A\21\3\2\2\2BC\7\22\2\2CD\5\24\13\2"+
		"DE\7\20\2\2E\23\3\2\2\2FG\t\3\2\2G\25\3\2\2\2HI\7\16\2\2IJ\7\24\2\2JK"+
		"\7\16\2\2K\27\3\2\2\2LM\7\24\2\2M\31\3\2\2\2NO\7\23\2\2O\33\3\2\2\2\5"+
		"%\61@";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
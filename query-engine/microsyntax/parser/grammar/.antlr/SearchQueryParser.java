// Generated from /home/arsene/Project/school-projects/mdeforge/advanced-query/query-engine/microsyntax/parser/grammar/SearchQuery.g4 by ANTLR 4.9.2
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
		T__0=1, T__1=2, AND=3, OR=4, NOT=5, COLON=6, GT=7, LT=8, EQ=9, GTE=10, 
		LTE=11, KEYWORD=12, NUMBER=13, TAG=14, METRIC=15, SPACE=16, QUOTE=17, 
		STRING=18;
	public static final int
		RULE_searchQuery = 0, RULE_term = 1, RULE_factor = 2, RULE_operator = 3, 
		RULE_keyword = 4, RULE_number = 5, RULE_tag = 6, RULE_tagValue = 7, RULE_metric = 8, 
		RULE_metricOperator = 9, RULE_exactKeyword = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"searchQuery", "term", "factor", "operator", "keyword", "number", "tag", 
			"tagValue", "metric", "metricOperator", "exactKeyword"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'AND'", "'OR'", "'NOT'", "':'", "'>'", "'<'", "'='", 
			"'>='", "'<='", null, null, "'TT_TAG'", "'TT_METRIC'", "' '", "'''"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "AND", "OR", "NOT", "COLON", "GT", "LT", "EQ", "GTE", 
			"LTE", "KEYWORD", "NUMBER", "TAG", "METRIC", "SPACE", "QUOTE", "STRING"
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
			setState(22);
			term();
			setState(23);
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
			setState(25);
			factor();
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << NOT) | (1L << COLON) | (1L << GT) | (1L << LT) | (1L << EQ) | (1L << GTE) | (1L << LTE) | (1L << SPACE))) != 0)) {
				{
				{
				setState(26);
				operator();
				setState(27);
				factor();
				}
				}
				setState(33);
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
			setState(43);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(34);
				match(NUMBER);
				}
				break;
			case KEYWORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				match(KEYWORD);
				}
				break;
			case TAG:
				enterOuterAlt(_localctx, 3);
				{
				setState(36);
				tag();
				}
				break;
			case METRIC:
				enterOuterAlt(_localctx, 4);
				{
				setState(37);
				metric();
				}
				break;
			case QUOTE:
				enterOuterAlt(_localctx, 5);
				{
				setState(38);
				exactKeyword();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 6);
				{
				setState(39);
				match(T__0);
				setState(40);
				term();
				setState(41);
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
		public TerminalNode AND() { return getToken(SearchQueryParser.AND, 0); }
		public TerminalNode OR() { return getToken(SearchQueryParser.OR, 0); }
		public TerminalNode NOT() { return getToken(SearchQueryParser.NOT, 0); }
		public TerminalNode SPACE() { return getToken(SearchQueryParser.SPACE, 0); }
		public TerminalNode COLON() { return getToken(SearchQueryParser.COLON, 0); }
		public TerminalNode GT() { return getToken(SearchQueryParser.GT, 0); }
		public TerminalNode LT() { return getToken(SearchQueryParser.LT, 0); }
		public TerminalNode EQ() { return getToken(SearchQueryParser.EQ, 0); }
		public TerminalNode GTE() { return getToken(SearchQueryParser.GTE, 0); }
		public TerminalNode LTE() { return getToken(SearchQueryParser.LTE, 0); }
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
			setState(45);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << NOT) | (1L << COLON) | (1L << GT) | (1L << LT) | (1L << EQ) | (1L << GTE) | (1L << LTE) | (1L << SPACE))) != 0)) ) {
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
			setState(47);
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
			setState(49);
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
		public TerminalNode COLON() { return getToken(SearchQueryParser.COLON, 0); }
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
			setState(51);
			match(TAG);
			setState(52);
			match(COLON);
			setState(53);
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
			setState(58);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KEYWORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				keyword();
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(56);
				number();
				}
				break;
			case QUOTE:
				enterOuterAlt(_localctx, 3);
				{
				setState(57);
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
			setState(60);
			match(METRIC);
			setState(61);
			metricOperator();
			setState(62);
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
		public TerminalNode GT() { return getToken(SearchQueryParser.GT, 0); }
		public TerminalNode LT() { return getToken(SearchQueryParser.LT, 0); }
		public TerminalNode EQ() { return getToken(SearchQueryParser.EQ, 0); }
		public TerminalNode GTE() { return getToken(SearchQueryParser.GTE, 0); }
		public TerminalNode LTE() { return getToken(SearchQueryParser.LTE, 0); }
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
			setState(64);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << LT) | (1L << EQ) | (1L << GTE) | (1L << LTE))) != 0)) ) {
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
		public List<TerminalNode> QUOTE() { return getTokens(SearchQueryParser.QUOTE); }
		public TerminalNode QUOTE(int i) {
			return getToken(SearchQueryParser.QUOTE, i);
		}
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
			setState(66);
			match(QUOTE);
			setState(67);
			match(STRING);
			setState(68);
			match(QUOTE);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\24I\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3 \n\3\f\3\16\3#\13\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\5\4.\n\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\5\t=\n\t\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3"+
		"\f\2\2\r\2\4\6\b\n\f\16\20\22\24\26\2\4\4\2\5\r\22\22\3\2\t\r\2E\2\30"+
		"\3\2\2\2\4\33\3\2\2\2\6-\3\2\2\2\b/\3\2\2\2\n\61\3\2\2\2\f\63\3\2\2\2"+
		"\16\65\3\2\2\2\20<\3\2\2\2\22>\3\2\2\2\24B\3\2\2\2\26D\3\2\2\2\30\31\5"+
		"\4\3\2\31\32\7\2\2\3\32\3\3\2\2\2\33!\5\6\4\2\34\35\5\b\5\2\35\36\5\6"+
		"\4\2\36 \3\2\2\2\37\34\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"\5\3"+
		"\2\2\2#!\3\2\2\2$.\7\17\2\2%.\7\16\2\2&.\5\16\b\2\'.\5\22\n\2(.\5\26\f"+
		"\2)*\7\3\2\2*+\5\4\3\2+,\7\4\2\2,.\3\2\2\2-$\3\2\2\2-%\3\2\2\2-&\3\2\2"+
		"\2-\'\3\2\2\2-(\3\2\2\2-)\3\2\2\2.\7\3\2\2\2/\60\t\2\2\2\60\t\3\2\2\2"+
		"\61\62\7\16\2\2\62\13\3\2\2\2\63\64\7\17\2\2\64\r\3\2\2\2\65\66\7\20\2"+
		"\2\66\67\7\b\2\2\678\5\20\t\28\17\3\2\2\29=\5\n\6\2:=\5\f\7\2;=\5\26\f"+
		"\2<9\3\2\2\2<:\3\2\2\2<;\3\2\2\2=\21\3\2\2\2>?\7\21\2\2?@\5\24\13\2@A"+
		"\7\17\2\2A\23\3\2\2\2BC\t\3\2\2C\25\3\2\2\2DE\7\23\2\2EF\7\24\2\2FG\7"+
		"\23\2\2G\27\3\2\2\2\5!-<";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
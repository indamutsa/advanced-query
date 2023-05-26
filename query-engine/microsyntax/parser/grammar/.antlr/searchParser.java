// Generated from /home/arsene/Project/school-projects/mdeforge/advanced-query/query-engine/microsyntax/parser/grammar/search.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class searchParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TAG_ID=1, NUMERICAL_TAG_ID=2, METRIC_ID=3, AND=4, OR=5, NOT=6, GT=7, LT=8, 
		EQ=9, EQASSIGN=10, GTE=11, LTE=12, NUMBER=13, KEYWORD=14, LPARANTH=15, 
		RPARANTH=16, SPACE=17, QUOTE=18, WS=19;
	public static final int
		RULE_searchQuery = 0, RULE_term = 1, RULE_factor = 2, RULE_boolean_operator = 3, 
		RULE_operator = 4, RULE_text = 5, RULE_exactText = 6, RULE_tag = 7, RULE_tagValue = 8, 
		RULE_expression = 9, RULE_metric_EXPR = 10, RULE_numericalExpr = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"searchQuery", "term", "factor", "boolean_operator", "operator", "text", 
			"exactText", "tag", "tagValue", "expression", "metric_EXPR", "numericalExpr"
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

	@Override
	public String getGrammarFileName() { return "search.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public searchParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SearchQueryContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode EOF() { return getToken(searchParser.EOF, 0); }
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
			setState(24);
			term();
			setState(25);
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
		public List<Boolean_operatorContext> boolean_operator() {
			return getRuleContexts(Boolean_operatorContext.class);
		}
		public Boolean_operatorContext boolean_operator(int i) {
			return getRuleContext(Boolean_operatorContext.class,i);
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
			setState(27);
			factor();
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << NOT) | (1L << SPACE))) != 0)) {
				{
				{
				setState(28);
				boolean_operator();
				setState(29);
				factor();
				}
				}
				setState(35);
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
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public TagContext tag() {
			return getRuleContext(TagContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LPARANTH() { return getToken(searchParser.LPARANTH, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode RPARANTH() { return getToken(searchParser.RPARANTH, 0); }
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
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				text();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(37);
				tag();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(38);
				expression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(39);
				match(LPARANTH);
				setState(40);
				term();
				setState(41);
				match(RPARANTH);
				}
				break;
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

	public static class Boolean_operatorContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(searchParser.AND, 0); }
		public TerminalNode OR() { return getToken(searchParser.OR, 0); }
		public TerminalNode NOT() { return getToken(searchParser.NOT, 0); }
		public TerminalNode SPACE() { return getToken(searchParser.SPACE, 0); }
		public Boolean_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_operator; }
	}

	public final Boolean_operatorContext boolean_operator() throws RecognitionException {
		Boolean_operatorContext _localctx = new Boolean_operatorContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_boolean_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << NOT) | (1L << SPACE))) != 0)) ) {
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

	public static class OperatorContext extends ParserRuleContext {
		public TerminalNode GT() { return getToken(searchParser.GT, 0); }
		public TerminalNode LT() { return getToken(searchParser.LT, 0); }
		public TerminalNode EQ() { return getToken(searchParser.EQ, 0); }
		public TerminalNode GTE() { return getToken(searchParser.GTE, 0); }
		public TerminalNode LTE() { return getToken(searchParser.LTE, 0); }
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
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

	public static class TextContext extends ParserRuleContext {
		public TerminalNode KEYWORD() { return getToken(searchParser.KEYWORD, 0); }
		public TerminalNode NUMBER() { return getToken(searchParser.NUMBER, 0); }
		public ExactTextContext exactText() {
			return getRuleContext(ExactTextContext.class,0);
		}
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_text);
		try {
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KEYWORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				match(KEYWORD);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				match(NUMBER);
				}
				break;
			case QUOTE:
				enterOuterAlt(_localctx, 3);
				{
				setState(51);
				exactText();
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

	public static class ExactTextContext extends ParserRuleContext {
		public List<TerminalNode> QUOTE() { return getTokens(searchParser.QUOTE); }
		public TerminalNode QUOTE(int i) {
			return getToken(searchParser.QUOTE, i);
		}
		public List<TerminalNode> KEYWORD() { return getTokens(searchParser.KEYWORD); }
		public TerminalNode KEYWORD(int i) {
			return getToken(searchParser.KEYWORD, i);
		}
		public List<TerminalNode> SPACE() { return getTokens(searchParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(searchParser.SPACE, i);
		}
		public ExactTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exactText; }
	}

	public final ExactTextContext exactText() throws RecognitionException {
		ExactTextContext _localctx = new ExactTextContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_exactText);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(QUOTE);
			setState(55);
			match(KEYWORD);
			setState(58); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(56);
				match(SPACE);
				setState(57);
				match(KEYWORD);
				}
				}
				setState(60); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SPACE );
			setState(62);
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

	public static class TagContext extends ParserRuleContext {
		public TerminalNode EQASSIGN() { return getToken(searchParser.EQASSIGN, 0); }
		public TagValueContext tagValue() {
			return getRuleContext(TagValueContext.class,0);
		}
		public TerminalNode TAG_ID() { return getToken(searchParser.TAG_ID, 0); }
		public TerminalNode NUMERICAL_TAG_ID() { return getToken(searchParser.NUMERICAL_TAG_ID, 0); }
		public TagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tag; }
	}

	public final TagContext tag() throws RecognitionException {
		TagContext _localctx = new TagContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_tag);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			_la = _input.LA(1);
			if ( !(_la==TAG_ID || _la==NUMERICAL_TAG_ID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(65);
			match(EQASSIGN);
			setState(66);
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
		public TerminalNode KEYWORD() { return getToken(searchParser.KEYWORD, 0); }
		public TerminalNode NUMBER() { return getToken(searchParser.NUMBER, 0); }
		public ExactTextContext exactText() {
			return getRuleContext(ExactTextContext.class,0);
		}
		public TagValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tagValue; }
	}

	public final TagValueContext tagValue() throws RecognitionException {
		TagValueContext _localctx = new TagValueContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_tagValue);
		try {
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KEYWORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				match(KEYWORD);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				match(NUMBER);
				}
				break;
			case QUOTE:
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
				exactText();
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

	public static class ExpressionContext extends ParserRuleContext {
		public NumericalExprContext numericalExpr() {
			return getRuleContext(NumericalExprContext.class,0);
		}
		public Metric_EXPRContext metric_EXPR() {
			return getRuleContext(Metric_EXPRContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expression);
		try {
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMERICAL_TAG_ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				numericalExpr();
				}
				break;
			case METRIC_ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				metric_EXPR();
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

	public static class Metric_EXPRContext extends ParserRuleContext {
		public TerminalNode METRIC_ID() { return getToken(searchParser.METRIC_ID, 0); }
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(searchParser.NUMBER, 0); }
		public Metric_EXPRContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metric_EXPR; }
	}

	public final Metric_EXPRContext metric_EXPR() throws RecognitionException {
		Metric_EXPRContext _localctx = new Metric_EXPRContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_metric_EXPR);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(METRIC_ID);
			setState(78);
			operator();
			setState(79);
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

	public static class NumericalExprContext extends ParserRuleContext {
		public TerminalNode NUMERICAL_TAG_ID() { return getToken(searchParser.NUMERICAL_TAG_ID, 0); }
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(searchParser.NUMBER, 0); }
		public NumericalExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericalExpr; }
	}

	public final NumericalExprContext numericalExpr() throws RecognitionException {
		NumericalExprContext _localctx = new NumericalExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_numericalExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(NUMERICAL_TAG_ID);
			setState(82);
			operator();
			setState(83);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\25X\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3\"\n\3\f\3\16\3%\13\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4.\n\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\5\7\67"+
		"\n\7\3\b\3\b\3\b\3\b\6\b=\n\b\r\b\16\b>\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\5\nJ\n\n\3\13\3\13\5\13N\n\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3"+
		"\r\2\2\16\2\4\6\b\n\f\16\20\22\24\26\30\2\5\4\2\6\b\23\23\4\2\t\13\r\16"+
		"\3\2\3\4\2U\2\32\3\2\2\2\4\35\3\2\2\2\6-\3\2\2\2\b/\3\2\2\2\n\61\3\2\2"+
		"\2\f\66\3\2\2\2\168\3\2\2\2\20B\3\2\2\2\22I\3\2\2\2\24M\3\2\2\2\26O\3"+
		"\2\2\2\30S\3\2\2\2\32\33\5\4\3\2\33\34\7\2\2\3\34\3\3\2\2\2\35#\5\6\4"+
		"\2\36\37\5\b\5\2\37 \5\6\4\2 \"\3\2\2\2!\36\3\2\2\2\"%\3\2\2\2#!\3\2\2"+
		"\2#$\3\2\2\2$\5\3\2\2\2%#\3\2\2\2&.\5\f\7\2\'.\5\20\t\2(.\5\24\13\2)*"+
		"\7\21\2\2*+\5\4\3\2+,\7\22\2\2,.\3\2\2\2-&\3\2\2\2-\'\3\2\2\2-(\3\2\2"+
		"\2-)\3\2\2\2.\7\3\2\2\2/\60\t\2\2\2\60\t\3\2\2\2\61\62\t\3\2\2\62\13\3"+
		"\2\2\2\63\67\7\20\2\2\64\67\7\17\2\2\65\67\5\16\b\2\66\63\3\2\2\2\66\64"+
		"\3\2\2\2\66\65\3\2\2\2\67\r\3\2\2\289\7\24\2\29<\7\20\2\2:;\7\23\2\2;"+
		"=\7\20\2\2<:\3\2\2\2=>\3\2\2\2><\3\2\2\2>?\3\2\2\2?@\3\2\2\2@A\7\24\2"+
		"\2A\17\3\2\2\2BC\t\4\2\2CD\7\f\2\2DE\5\22\n\2E\21\3\2\2\2FJ\7\20\2\2G"+
		"J\7\17\2\2HJ\5\16\b\2IF\3\2\2\2IG\3\2\2\2IH\3\2\2\2J\23\3\2\2\2KN\5\30"+
		"\r\2LN\5\26\f\2MK\3\2\2\2ML\3\2\2\2N\25\3\2\2\2OP\7\5\2\2PQ\5\n\6\2QR"+
		"\7\17\2\2R\27\3\2\2\2ST\7\4\2\2TU\5\n\6\2UV\7\17\2\2V\31\3\2\2\2\b#-\66"+
		">IM";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
// Generated from MetaGrammar.g4 by ANTLR 4.9

package generator.gen;

import generator.ast.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.*;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MetaGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, NotermIdentifier=11, TokenIdentifier=12, Alias=13, IntegerLiteral=14, 
		FloatLiteral=15, CodeInject=16, Regexp=17, WS=18;
	public static final int
		RULE_gram = 0, RULE_gramName = 1, RULE_header = 2, RULE_notermDeclBlock = 3, 
		RULE_tokenDeclBlock = 4, RULE_notermDecl = 5, RULE_tokenDecl = 6, RULE_ruleWay = 7, 
		RULE_ruleEntry = 8, RULE_noterm = 9, RULE_token = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"gram", "gramName", "header", "notermDeclBlock", "tokenDeclBlock", "notermDecl", 
			"tokenDecl", "ruleWay", "ruleEntry", "noterm", "token"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'grammar'", "';'", "'header'", "'returns'", "':'", "'|'", "'->'", 
			"'skip'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "NotermIdentifier", 
			"TokenIdentifier", "Alias", "IntegerLiteral", "FloatLiteral", "CodeInject", 
			"Regexp", "WS"
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
	public String getGrammarFileName() { return "generator/MetaGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MetaGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class GramContext extends ParserRuleContext {
		public Grammar gr;
		public GramNameContext name;
		public HeaderContext head;
		public NotermDeclBlockContext ntd;
		public TokenDeclBlockContext tkd;
		public GramNameContext gramName() {
			return getRuleContext(GramNameContext.class,0);
		}
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public NotermDeclBlockContext notermDeclBlock() {
			return getRuleContext(NotermDeclBlockContext.class,0);
		}
		public TokenDeclBlockContext tokenDeclBlock() {
			return getRuleContext(TokenDeclBlockContext.class,0);
		}
		public GramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gram; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterGram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitGram(this);
		}
	}

	public final GramContext gram() throws RecognitionException {
		GramContext _localctx = new GramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_gram);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			((GramContext)_localctx).name = gramName();
			setState(23);
			((GramContext)_localctx).head = header();
			setState(24);
			((GramContext)_localctx).ntd = notermDeclBlock();
			setState(25);
			((GramContext)_localctx).tkd = tokenDeclBlock();
			((GramContext)_localctx).gr =  new Grammar(((GramContext)_localctx).name.name, ((GramContext)_localctx).head.head, ((GramContext)_localctx).ntd.ruleList, ((GramContext)_localctx).tkd.ruleList);
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

	public static class GramNameContext extends ParserRuleContext {
		public String name;
		public Token id;
		public TerminalNode TokenIdentifier() { return getToken(MetaGrammarParser.TokenIdentifier, 0); }
		public GramNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gramName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterGramName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitGramName(this);
		}
	}

	public final GramNameContext gramName() throws RecognitionException {
		GramNameContext _localctx = new GramNameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_gramName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(T__0);
			setState(29);
			((GramNameContext)_localctx).id = match(TokenIdentifier);
			setState(30);
			match(T__1);
			((GramNameContext)_localctx).name =  (((GramNameContext)_localctx).id!=null?((GramNameContext)_localctx).id.getText():null);
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

	public static class HeaderContext extends ParserRuleContext {
		public String head;
		public Token ci;
		public TerminalNode CodeInject() { return getToken(MetaGrammarParser.CodeInject, 0); }
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitHeader(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_header);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			match(T__2);
			setState(34);
			((HeaderContext)_localctx).ci = match(CodeInject);
			((HeaderContext)_localctx).head =  (((HeaderContext)_localctx).ci!=null?((HeaderContext)_localctx).ci.getText():null);
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

	public static class NotermDeclBlockContext extends ParserRuleContext {
		public List<Rule> ruleList;
		public NotermDeclContext rl;
		public List<NotermDeclContext> notermDecl() {
			return getRuleContexts(NotermDeclContext.class);
		}
		public NotermDeclContext notermDecl(int i) {
			return getRuleContext(NotermDeclContext.class,i);
		}
		public NotermDeclBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notermDeclBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterNotermDeclBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitNotermDeclBlock(this);
		}
	}

	public final NotermDeclBlockContext notermDeclBlock() throws RecognitionException {
		NotermDeclBlockContext _localctx = new NotermDeclBlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_notermDeclBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

			            ((NotermDeclBlockContext)_localctx).ruleList =  new ArrayList<>();
			        
			setState(41); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(38);
				((NotermDeclBlockContext)_localctx).rl = notermDecl();
				_localctx.ruleList.add(((NotermDeclBlockContext)_localctx).rl.rl);
				}
				}
				setState(43); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NotermIdentifier );
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

	public static class TokenDeclBlockContext extends ParserRuleContext {
		public List<MetaToken> ruleList;
		public TokenDeclContext tk;
		public List<TokenDeclContext> tokenDecl() {
			return getRuleContexts(TokenDeclContext.class);
		}
		public TokenDeclContext tokenDecl(int i) {
			return getRuleContext(TokenDeclContext.class,i);
		}
		public TokenDeclBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tokenDeclBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterTokenDeclBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitTokenDeclBlock(this);
		}
	}

	public final TokenDeclBlockContext tokenDeclBlock() throws RecognitionException {
		TokenDeclBlockContext _localctx = new TokenDeclBlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_tokenDeclBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

			            ((TokenDeclBlockContext)_localctx).ruleList =  new ArrayList<>();
			        
			setState(49); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(46);
				((TokenDeclBlockContext)_localctx).tk = tokenDecl();
				_localctx.ruleList.add(((TokenDeclBlockContext)_localctx).tk.tk);
				}
				}
				setState(51); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TokenIdentifier );
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

	public static class NotermDeclContext extends ParserRuleContext {
		public Rule rl;
		public Token name;
		public Token arg;
		public Token val;
		public RuleWayContext way;
		public TerminalNode NotermIdentifier() { return getToken(MetaGrammarParser.NotermIdentifier, 0); }
		public List<RuleWayContext> ruleWay() {
			return getRuleContexts(RuleWayContext.class);
		}
		public RuleWayContext ruleWay(int i) {
			return getRuleContext(RuleWayContext.class,i);
		}
		public List<TerminalNode> CodeInject() { return getTokens(MetaGrammarParser.CodeInject); }
		public TerminalNode CodeInject(int i) {
			return getToken(MetaGrammarParser.CodeInject, i);
		}
		public NotermDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notermDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterNotermDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitNotermDecl(this);
		}
	}

	public final NotermDeclContext notermDecl() throws RecognitionException {
		NotermDeclContext _localctx = new NotermDeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_notermDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

			            String ruleName = null;
			            String ruleArg = null;
			            String ruleVal = null;
			            List<RuleWay> ruleWays = new ArrayList<>();
			        
			setState(54);
			((NotermDeclContext)_localctx).name = match(NotermIdentifier);
			ruleName = (((NotermDeclContext)_localctx).name!=null?((NotermDeclContext)_localctx).name.getText():null);
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CodeInject) {
				{
				setState(56);
				((NotermDeclContext)_localctx).arg = match(CodeInject);
				ruleArg = (((NotermDeclContext)_localctx).arg!=null?((NotermDeclContext)_localctx).arg.getText():null).substring(1, (((NotermDeclContext)_localctx).arg!=null?((NotermDeclContext)_localctx).arg.getText():null).length() - 1);
				}
			}

			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(60);
				match(T__3);
				setState(61);
				((NotermDeclContext)_localctx).val = match(CodeInject);
				ruleVal = (((NotermDeclContext)_localctx).val!=null?((NotermDeclContext)_localctx).val.getText():null).substring(1, (((NotermDeclContext)_localctx).val!=null?((NotermDeclContext)_localctx).val.getText():null).length() - 1);
				}
			}

			setState(65);
			match(T__4);
			setState(66);
			((NotermDeclContext)_localctx).way = ruleWay();
			ruleWays.add(((NotermDeclContext)_localctx).way.way);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(68);
				match(T__5);
				setState(69);
				((NotermDeclContext)_localctx).way = ruleWay();
				ruleWays.add(((NotermDeclContext)_localctx).way.way);
				}
				}
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(77);
			match(T__1);

			            ((NotermDeclContext)_localctx).rl =  new Rule(ruleName, ruleArg, ruleVal, ruleWays);
			        
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

	public static class TokenDeclContext extends ParserRuleContext {
		public MetaToken tk;
		public Token name;
		public Token re;
		public TerminalNode TokenIdentifier() { return getToken(MetaGrammarParser.TokenIdentifier, 0); }
		public TerminalNode Regexp() { return getToken(MetaGrammarParser.Regexp, 0); }
		public TokenDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tokenDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterTokenDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitTokenDecl(this);
		}
	}

	public final TokenDeclContext tokenDecl() throws RecognitionException {
		TokenDeclContext _localctx = new TokenDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_tokenDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

			            String tokenName = null;
			            String tokenRegexp = null;
			            boolean skip = false;
			        
			setState(81);
			((TokenDeclContext)_localctx).name = match(TokenIdentifier);
			setState(82);
			match(T__4);
			setState(83);
			((TokenDeclContext)_localctx).re = match(Regexp);
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(84);
				match(T__6);
				setState(85);
				match(T__7);
				skip = true;
				}
			}

			setState(89);
			match(T__1);

			            ((TokenDeclContext)_localctx).tk =  new MetaToken((((TokenDeclContext)_localctx).name!=null?((TokenDeclContext)_localctx).name.getText():null), (((TokenDeclContext)_localctx).re!=null?((TokenDeclContext)_localctx).re.getText():null).substring(1, (((TokenDeclContext)_localctx).re!=null?((TokenDeclContext)_localctx).re.getText():null).length() - 1), skip);
			        
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

	public static class RuleWayContext extends ParserRuleContext {
		public RuleWay way;
		public RuleEntryContext re;
		public Token ci;
		public List<RuleEntryContext> ruleEntry() {
			return getRuleContexts(RuleEntryContext.class);
		}
		public RuleEntryContext ruleEntry(int i) {
			return getRuleContext(RuleEntryContext.class,i);
		}
		public TerminalNode CodeInject() { return getToken(MetaGrammarParser.CodeInject, 0); }
		public RuleWayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleWay; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterRuleWay(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitRuleWay(this);
		}
	}

	public final RuleWayContext ruleWay() throws RecognitionException {
		RuleWayContext _localctx = new RuleWayContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ruleWay);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

			            List<Invokation> invList = new ArrayList<>();
			            String code = null;
			        
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NotermIdentifier) | (1L << TokenIdentifier) | (1L << Alias))) != 0)) {
				{
				{
				setState(93);
				((RuleWayContext)_localctx).re = ruleEntry();
				invList.add(((RuleWayContext)_localctx).re.inv);
				}
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CodeInject) {
				{
				setState(101);
				((RuleWayContext)_localctx).ci = match(CodeInject);
				code = (((RuleWayContext)_localctx).ci!=null?((RuleWayContext)_localctx).ci.getText():null).substring(1, (((RuleWayContext)_localctx).ci!=null?((RuleWayContext)_localctx).ci.getText():null).length() - 1);
				}
			}


			            ((RuleWayContext)_localctx).way =  new RuleWay(invList, code);
			        
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

	public static class RuleEntryContext extends ParserRuleContext {
		public Invokation inv;
		public NotermContext nt;
		public TokenContext tk;
		public NotermContext noterm() {
			return getRuleContext(NotermContext.class,0);
		}
		public TokenContext token() {
			return getRuleContext(TokenContext.class,0);
		}
		public RuleEntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleEntry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterRuleEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitRuleEntry(this);
		}
	}

	public final RuleEntryContext ruleEntry() throws RecognitionException {
		RuleEntryContext _localctx = new RuleEntryContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ruleEntry);
		try {
			setState(113);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				((RuleEntryContext)_localctx).nt = noterm();
				((RuleEntryContext)_localctx).inv =  ((RuleEntryContext)_localctx).nt.inv;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				((RuleEntryContext)_localctx).tk = token();
				((RuleEntryContext)_localctx).inv =  ((RuleEntryContext)_localctx).tk.inv;
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

	public static class NotermContext extends ParserRuleContext {
		public RuleInvokation inv;
		public Token alias;
		public Token name;
		public Token arg;
		public TerminalNode NotermIdentifier() { return getToken(MetaGrammarParser.NotermIdentifier, 0); }
		public TerminalNode Alias() { return getToken(MetaGrammarParser.Alias, 0); }
		public TerminalNode CodeInject() { return getToken(MetaGrammarParser.CodeInject, 0); }
		public NotermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noterm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterNoterm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitNoterm(this);
		}
	}

	public final NotermContext noterm() throws RecognitionException {
		NotermContext _localctx = new NotermContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_noterm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

			            String ruleName = null;
			            String ruleAlias = null;
			            String ruleArg = null;
			        
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alias) {
				{
				setState(116);
				((NotermContext)_localctx).alias = match(Alias);
				ruleAlias = (((NotermContext)_localctx).alias!=null?((NotermContext)_localctx).alias.getText():null).substring(1, (((NotermContext)_localctx).alias!=null?((NotermContext)_localctx).alias.getText():null).length() - 1);
				}
			}

			setState(120);
			((NotermContext)_localctx).name = match(NotermIdentifier);
			ruleName = (((NotermContext)_localctx).name!=null?((NotermContext)_localctx).name.getText():null);
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(122);
				match(T__8);
				setState(123);
				((NotermContext)_localctx).arg = match(CodeInject);
				setState(124);
				match(T__9);
				ruleArg = (((NotermContext)_localctx).arg!=null?((NotermContext)_localctx).arg.getText():null).substring(1, (((NotermContext)_localctx).arg!=null?((NotermContext)_localctx).arg.getText():null).length() - 1);
				}
			}


			            ((NotermContext)_localctx).inv =  new RuleInvokation(ruleName, ruleAlias, ruleArg);
			        
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

	public static class TokenContext extends ParserRuleContext {
		public TokenInvokation inv;
		public Token alias;
		public Token name;
		public TerminalNode TokenIdentifier() { return getToken(MetaGrammarParser.TokenIdentifier, 0); }
		public TerminalNode Alias() { return getToken(MetaGrammarParser.Alias, 0); }
		public TokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterToken(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitToken(this);
		}
	}

	public final TokenContext token() throws RecognitionException {
		TokenContext _localctx = new TokenContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_token);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

			            String tokenName = null;
			            String tokenAlias = null;
			        
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Alias) {
				{
				setState(131);
				((TokenContext)_localctx).alias = match(Alias);
				tokenAlias = (((TokenContext)_localctx).alias!=null?((TokenContext)_localctx).alias.getText():null).substring(1, (((TokenContext)_localctx).alias!=null?((TokenContext)_localctx).alias.getText():null).length() - 1);
				}
			}

			setState(135);
			((TokenContext)_localctx).name = match(TokenIdentifier);
			tokenName = (((TokenContext)_localctx).name!=null?((TokenContext)_localctx).name.getText():null);

			            ((TokenContext)_localctx).inv =  new TokenInvokation(tokenName, tokenAlias);
			        
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\24\u008e\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\6\5,\n\5\r\5\16\5-\3\6\3\6\3\6\3\6\6\6\64\n\6\r\6"+
		"\16\6\65\3\7\3\7\3\7\3\7\3\7\5\7=\n\7\3\7\3\7\3\7\5\7B\n\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\7\7K\n\7\f\7\16\7N\13\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\5\bZ\n\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\7\tc\n\t\f\t\16\tf\13"+
		"\t\3\t\3\t\5\tj\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\5\nt\n\n\3\13\3\13"+
		"\3\13\5\13y\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0081\n\13\3\13\3"+
		"\13\3\f\3\f\3\f\5\f\u0088\n\f\3\f\3\f\3\f\3\f\3\f\2\2\r\2\4\6\b\n\f\16"+
		"\20\22\24\26\2\2\2\u008e\2\30\3\2\2\2\4\36\3\2\2\2\6#\3\2\2\2\b\'\3\2"+
		"\2\2\n/\3\2\2\2\f\67\3\2\2\2\16R\3\2\2\2\20^\3\2\2\2\22s\3\2\2\2\24u\3"+
		"\2\2\2\26\u0084\3\2\2\2\30\31\5\4\3\2\31\32\5\6\4\2\32\33\5\b\5\2\33\34"+
		"\5\n\6\2\34\35\b\2\1\2\35\3\3\2\2\2\36\37\7\3\2\2\37 \7\16\2\2 !\7\4\2"+
		"\2!\"\b\3\1\2\"\5\3\2\2\2#$\7\5\2\2$%\7\22\2\2%&\b\4\1\2&\7\3\2\2\2\'"+
		"+\b\5\1\2()\5\f\7\2)*\b\5\1\2*,\3\2\2\2+(\3\2\2\2,-\3\2\2\2-+\3\2\2\2"+
		"-.\3\2\2\2.\t\3\2\2\2/\63\b\6\1\2\60\61\5\16\b\2\61\62\b\6\1\2\62\64\3"+
		"\2\2\2\63\60\3\2\2\2\64\65\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66\13\3"+
		"\2\2\2\678\b\7\1\289\7\r\2\29<\b\7\1\2:;\7\22\2\2;=\b\7\1\2<:\3\2\2\2"+
		"<=\3\2\2\2=A\3\2\2\2>?\7\6\2\2?@\7\22\2\2@B\b\7\1\2A>\3\2\2\2AB\3\2\2"+
		"\2BC\3\2\2\2CD\7\7\2\2DE\5\20\t\2EL\b\7\1\2FG\7\b\2\2GH\5\20\t\2HI\b\7"+
		"\1\2IK\3\2\2\2JF\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MO\3\2\2\2NL\3\2"+
		"\2\2OP\7\4\2\2PQ\b\7\1\2Q\r\3\2\2\2RS\b\b\1\2ST\7\16\2\2TU\7\7\2\2UY\7"+
		"\23\2\2VW\7\t\2\2WX\7\n\2\2XZ\b\b\1\2YV\3\2\2\2YZ\3\2\2\2Z[\3\2\2\2[\\"+
		"\7\4\2\2\\]\b\b\1\2]\17\3\2\2\2^d\b\t\1\2_`\5\22\n\2`a\b\t\1\2ac\3\2\2"+
		"\2b_\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2ei\3\2\2\2fd\3\2\2\2gh\7\22"+
		"\2\2hj\b\t\1\2ig\3\2\2\2ij\3\2\2\2jk\3\2\2\2kl\b\t\1\2l\21\3\2\2\2mn\5"+
		"\24\13\2no\b\n\1\2ot\3\2\2\2pq\5\26\f\2qr\b\n\1\2rt\3\2\2\2sm\3\2\2\2"+
		"sp\3\2\2\2t\23\3\2\2\2ux\b\13\1\2vw\7\17\2\2wy\b\13\1\2xv\3\2\2\2xy\3"+
		"\2\2\2yz\3\2\2\2z{\7\r\2\2{\u0080\b\13\1\2|}\7\13\2\2}~\7\22\2\2~\177"+
		"\7\f\2\2\177\u0081\b\13\1\2\u0080|\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082"+
		"\3\2\2\2\u0082\u0083\b\13\1\2\u0083\25\3\2\2\2\u0084\u0087\b\f\1\2\u0085"+
		"\u0086\7\17\2\2\u0086\u0088\b\f\1\2\u0087\u0085\3\2\2\2\u0087\u0088\3"+
		"\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\7\16\2\2\u008a\u008b\b\f\1\2\u008b"+
		"\u008c\b\f\1\2\u008c\27\3\2\2\2\16-\65<ALYdisx\u0080\u0087";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
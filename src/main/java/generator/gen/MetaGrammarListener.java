// Generated from MetaGrammar.g4 by ANTLR 4.9

package generator.gen;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MetaGrammarParser}.
 */
public interface MetaGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#gram}.
	 * @param ctx the parse tree
	 */
	void enterGram(MetaGrammarParser.GramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#gram}.
	 * @param ctx the parse tree
	 */
	void exitGram(MetaGrammarParser.GramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#gramName}.
	 * @param ctx the parse tree
	 */
	void enterGramName(MetaGrammarParser.GramNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#gramName}.
	 * @param ctx the parse tree
	 */
	void exitGramName(MetaGrammarParser.GramNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(MetaGrammarParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(MetaGrammarParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#notermDeclBlock}.
	 * @param ctx the parse tree
	 */
	void enterNotermDeclBlock(MetaGrammarParser.NotermDeclBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#notermDeclBlock}.
	 * @param ctx the parse tree
	 */
	void exitNotermDeclBlock(MetaGrammarParser.NotermDeclBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#tokenDeclBlock}.
	 * @param ctx the parse tree
	 */
	void enterTokenDeclBlock(MetaGrammarParser.TokenDeclBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#tokenDeclBlock}.
	 * @param ctx the parse tree
	 */
	void exitTokenDeclBlock(MetaGrammarParser.TokenDeclBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#notermDecl}.
	 * @param ctx the parse tree
	 */
	void enterNotermDecl(MetaGrammarParser.NotermDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#notermDecl}.
	 * @param ctx the parse tree
	 */
	void exitNotermDecl(MetaGrammarParser.NotermDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#tokenDecl}.
	 * @param ctx the parse tree
	 */
	void enterTokenDecl(MetaGrammarParser.TokenDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#tokenDecl}.
	 * @param ctx the parse tree
	 */
	void exitTokenDecl(MetaGrammarParser.TokenDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#ruleWay}.
	 * @param ctx the parse tree
	 */
	void enterRuleWay(MetaGrammarParser.RuleWayContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#ruleWay}.
	 * @param ctx the parse tree
	 */
	void exitRuleWay(MetaGrammarParser.RuleWayContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#ruleEntry}.
	 * @param ctx the parse tree
	 */
	void enterRuleEntry(MetaGrammarParser.RuleEntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#ruleEntry}.
	 * @param ctx the parse tree
	 */
	void exitRuleEntry(MetaGrammarParser.RuleEntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#noterm}.
	 * @param ctx the parse tree
	 */
	void enterNoterm(MetaGrammarParser.NotermContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#noterm}.
	 * @param ctx the parse tree
	 */
	void exitNoterm(MetaGrammarParser.NotermContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#token}.
	 * @param ctx the parse tree
	 */
	void enterToken(MetaGrammarParser.TokenContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#token}.
	 * @param ctx the parse tree
	 */
	void exitToken(MetaGrammarParser.TokenContext ctx);
}
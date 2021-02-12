package generator;

import generator.ast.Grammar;
import generator.gen.MetaGrammarLexer;
import generator.gen.MetaGrammarParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        MetaGrammarLexer lexer = new MetaGrammarLexer(CharStreams.fromStream(new FileInputStream("./src/calc/CalcGrammar.gr")));
        MetaGrammarParser parser = new MetaGrammarParser(new CommonTokenStream(lexer));
        Grammar grammar = parser.gram().gr;
        grammar.deduceRules();
        grammar.findFirst();
        grammar.findFollow();
        grammar.checkLL1();
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("./src/calc/gen/" + grammar.name + "Parser.java")));
        for (String s : grammar.printParser()) {
            writer.println(s);
        }
        writer.close();
    }
}

package generator;

import generator.ast.Grammar;
import generator.gen.MetaGrammarLexer;
import generator.gen.MetaGrammarParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.*;

public class Generator {
    public static void generateGrammar(String inputFile, String outputDir) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        MetaGrammarLexer lexer = new MetaGrammarLexer(CharStreams.fromStream(new FileInputStream(inputFile)));
        MetaGrammarParser parser = new MetaGrammarParser(new CommonTokenStream(lexer));
        Grammar grammar = parser.gram().gr;
        grammar.deduceRules();
        grammar.findFirst();
        grammar.findFollow();
        grammar.checkLL1();
        PrintWriter parserWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File(outputDir, grammar.name + "Parser.java"))));
        for (String s : grammar.printParser()) {
            parserWriter.println(s);
        }
        parserWriter.close();
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 2 || args[0] == null || args[1] == null) {
            throw new IOException("Illegal arguments");
        }
        String inputFile = args[0];
        String outputDir = args[1];
        generateGrammar(inputFile, outputDir);
    }
}

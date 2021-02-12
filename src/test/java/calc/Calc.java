package calc;

import calc.gen.CalcGrammarParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calc {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            CalcGrammarParser.ShContext context = new CalcGrammarParser(reader.readLine()).parse();
            System.out.println(context.res);
        }
    }
}

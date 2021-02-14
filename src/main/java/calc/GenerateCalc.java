package calc;


import generator.Generator;

import java.io.IOException;

public class GenerateCalc {
    public static void main(String[] args) throws IOException {
        Generator.generateGrammar("src/main/java/calc/CalcGrammar.gr", "src/main/java/calc/gen");
    }
}

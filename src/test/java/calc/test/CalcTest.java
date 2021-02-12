package calc.test;

import calc.gen.CalcGrammarParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalcTest {
    private static int parseResult(String s) {
        return new CalcGrammarParser(s).parse().res;
    }

    @Test
    public void ConstantTest() {
        assertEquals(1, parseResult("1"));
    }

    @Test
    public void UnaryMinusTest() {
        assertEquals(-100, parseResult("---100"));
    }

    @Test
    public void SimpleExpressionTest() {
        assertEquals(4, parseResult("2 + 2"));
    }

    @Test
    public void BracketsTest() {
        assertEquals(255, parseResult("(3 + 14) * 15"));
    }

    @Test
    public void PriorityTest() {
        assertEquals(1, parseResult("1 - 2 + 3 * 4 / 5"));
    }

    @Test
    public void ComplexExpressionTest() {
        assertEquals(-5, parseResult("(1+2)*(-3*(7-4)+2)/square(2)"));
    }

    @Test
    public void ComplexFuncTest() {
        assertEquals(4, parseResult("square(-100 + abs(-100) + 2) / square(1)"));
    }

    @Test
    public void SimpleShiftTest() {
        assertEquals(88, parseResult("11 << 3"));
    }

    @Test
    public void ShiftAssocTest() {
        assertEquals(10, parseResult("10 << 2 + 3 >> 3 + 2"));
    }

    @Test
    public void ShiftComplexTest() {
        assertEquals(12, parseResult("(2 + 2 * 2 << 1 + 1) / (16 >> 3)"));
    }


}

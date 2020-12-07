package week1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodeDojoTest {
    @Test
    public void testReturns1() {
        var calc = new StringCalculator();

        var result = calc.add("1");

        assertEquals("1", result);
    }

    @Test
    public void testCSVString() {
        var calc = new StringCalculator();

        var result = calc.add("1,2");

        assertEquals( "3", result);
    }

    @Test
    public void testEmptyStringReturn0() {
        var calc = new StringCalculator();

        var result = calc.add("");

        assertEquals( "0", result);
    }

    @Test
    public void testNull() {
        var calc = new StringCalculator();

        var result = calc.add(null);

        assertEquals("0", result);
    }

    @Test
    public void testNewLineSeprator() {
        var calc = new StringCalculator();

        var result = calc.add("1.1,2.2");

        assertEquals( "3.3", result);
    }
}
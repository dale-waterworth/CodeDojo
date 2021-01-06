package week1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTests {
    private StringCalculator _stringCalculator;

    @BeforeEach
    public void init() {
        _stringCalculator = new StringCalculator();
    }

    @Test
    public void AddingSingleNumber_ReturnsItself() {
        var input = "1";

        var result = _stringCalculator.add(input);

        assertEquals(input, result);
    }

    @Test
    public void AddingTwoCommaSeparatedNumbers_ReturnSum() {
        var input = "1,2";

        var result = _stringCalculator.add(input);

        assertEquals("3", result);
    }

    @Test
    public void AddingTwoCommaSeparatedNumbers_WithSpaces_ReturnSum() {
        var input = "1 ,     2";

        var result = _stringCalculator.add(input);

        assertEquals("3", result);
    }

    @Test
    public void AddingThreeCommaSeparatedNumbers_ReturnSum() {
        var input = "1,2,3";

        var result = _stringCalculator.add(input);

        assertEquals("6", result);
    }

    @Test
    public void AddingEmptyString_ReturnsZero() {
        var input = "";

        var result = _stringCalculator.add(input);

        assertEquals("0", result);
    }

    @Test
    public void AddingNull_DoesNotThrowException_ReturnsZero() {
        var result = _stringCalculator.add(null);

        assertEquals("0", result);
    }

    @Test
    public void AddingSingleDecimalNumber_ReturnsItself() {
        var input = "1.1";

        var result = _stringCalculator.add(input);

        assertEquals("1.1", result);
    }

    @Test
    public void AddingTwoCommaSeparatedDecimalNumbers_ReturnsSum() {
        var input = "1.1,2.2";

        var result = _stringCalculator.add(input);

        assertEquals("3.3", result);
    }

    @Test
    public void AddingThreeCommaSeparatedDecimalNumbers_ReturnsSum() {
        var input = "1.1,2.2,3.3";

        var result = _stringCalculator.add(input);

        assertEquals("6.6", result);
    }

    @Test
    public void AddingTwoCommaSeparatedDecimalNumbers_WithSpaces_ReturnsSum() {
        var input = "1.1  ,   2.2";

        var result = _stringCalculator.add(input);

        assertEquals("3.3", result);
    }

    // "1\n2,3" should return "6".
    @Test
    public void FindingNewLineAndCommaSeparator() {
        var input = "1\n2,3";

        var result = _stringCalculator.add(input);

        assertEquals("6", result);
    }

    @Test
    public void splitByDelimiterSplitsOnNewlineAndComma() {
        var input = "1\n2,3";

        var result = _stringCalculator.splitByDelimiter(input);

        assertEquals(3, result.length);
    }

    // "175.2,\n35"
    // "Number expected but '\n' found at position 6."
    @Test
    public void WhenMultipleDelimeter_ThrowsException() {
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            var input = "175.2,\n35";
            _stringCalculator.add(input);
        });

        var expectedMessage = "Number expected but '\\n' found at position 6.";
        assertEquals(expectedMessage, exception.getMessage());
    }
    // TODO: What happens if we add more fancy characters e.g. "1,2,!!!,?,@,4,:D"
}

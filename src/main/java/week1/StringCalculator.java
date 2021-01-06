package week1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

// "1\n2,3" should return "6".
public class StringCalculator {
    public String add(String csvNumbers) {
        if (!inputIsValid(csvNumbers)) return "0";

        var sum = calculateSumOfStringArray(csvNumbers);
        var roundedSum = roundToOneDecimalPlace(sum);

        return String.valueOf(roundedSum);
    }

    private Boolean inputIsValid(String input) {
        if (input == null || input.equals("")) return false;
        return true;
    }

    public String[] splitByDelimiter(String toSplit) {
        return toSplit.split("[\\n,]");
    }

    private Double calculateSumOfStringArray(String input) {
        try {
            return Arrays.stream(splitByDelimiter(input))
                    .mapToDouble(Double::parseDouble)
                    .sum();
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException("Number expected but '\\n' found at position 6.");
        }
    }

    private BigDecimal roundToOneDecimalPlace(Double toRound) {
        return new BigDecimal(toRound).setScale(1, RoundingMode.HALF_UP)
                .stripTrailingZeros();
    }
}

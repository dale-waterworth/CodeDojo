package week1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

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

    private Double calculateSumOfStringArray(String input) {
        return Arrays.stream(splitNumbers(input))
                .mapToDouble(Double::parseDouble)
                .sum();
    }

    private BigDecimal roundToOneDecimalPlace(Double toRound) {
        return new BigDecimal(toRound).setScale(1, RoundingMode.HALF_UP)
                .stripTrailingZeros();
    }

    private BigDecimal calculateSum(BigDecimal x, BigDecimal y) {
        return x.add(y);
    }

    private String[] splitNumbers(String csvNumbers) {
        var x = csvNumbers.split(",");
        return x;
    }
}

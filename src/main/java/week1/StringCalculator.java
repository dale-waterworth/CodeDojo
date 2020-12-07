package week1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class StringCalculator {
    public String add(String csvNumbers) {
        if (csvNumbers == null || csvNumbers.equals("")) {
            return "0";
        }

        var sum = Arrays.stream(splitNumbers(csvNumbers))
                .mapToDouble(Double::parseDouble).sum();

        var roundedUpSum = new BigDecimal(sum).setScale(1, RoundingMode.HALF_UP).stripTrailingZeros();

        return String.valueOf(roundedUpSum);
    }

    private BigDecimal calculateSum(BigDecimal x, BigDecimal y) {
        return x.add(y);
    }

    private String[] splitNumbers(String csvNumbers) {
        var x = csvNumbers.split(",");
        return x;
    }
}

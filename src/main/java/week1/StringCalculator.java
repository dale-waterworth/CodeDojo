package week1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class StringCalculator {
    public String add(String csvNumbers) {
        if (csvNumbers == null || csvNumbers.equals("")) {
            return "0";
        }

        /**
         * Refactor - 
         * if(ints)
         * 
         * else (decimal)
         */

       /* var sum = Arrays.stream(splitNumbers(csvNumbers))
                .map(this::extractNumber)
                .reduce(0.0, (x, y) -> calculateSum(x, y));*/
        
      /*  var sum =  Arrays.stream(splitNumbers(csvNumbers))
               .mapToDouble(this::extractNumber)
               .sum();*/

        var sum = Arrays.stream(splitNumbers(csvNumbers))
                .map(this::extractNumber)
                .reduce(BigDecimal.ZERO, (x, y) -> calculateSum(x, y));


        // sum = 3.30000000003
        var answer = sum.toString();
        var x = sum.setScale(0, RoundingMode.UP);
        
        if (sum == x) {
            answer = x.toString();
        }

        return answer;
    }

    private BigDecimal calculateSum(BigDecimal x, BigDecimal y) {
        return x.add(y);
    }

    private BigDecimal extractNumber(String number) {
        var number2 = BigDecimal.ZERO;
        try {
           // number2 = BigDecimal.parseDouble(number);
            
            number2 = BigDecimal.valueOf(Double.parseDouble(number));
        } catch (Exception e) {

        }
        return number2;
    }

    private String[] splitNumbers(String csvNumbers) {
        var x = csvNumbers.split(",");
        return x;
    }

    /*private TryParseInt(str,defaultValue) {
        var retValue = defaultValue;
        if(str !== null) {
            if(str.length > 0) {
                if (!isNaN(str)) {
                    retValue = parseInt(str);
                }
            }
        }
        return retValue;
    }*/
}

package crack.code.interview.algorithms.medium;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringToInteger {

    public static void main(String[] args) {
        String input = "+-2";
        System.out.println("StringToInteger: " + myAtoi(input));
    }

    public static int myAtoiOption1(String str) {

        int result = 0;

        if (str.isEmpty()) {
            return result;
        }

        Pattern pattern = Pattern.compile("^\\s*([+-]?[0-9]+)");
        Matcher matcher = pattern.matcher(str);

        if (matcher.find()) {
            String possibleIntValue = matcher.group(0);

            double resultDouble = Double.parseDouble(possibleIntValue);

            resultDouble = Math.min(Integer.MAX_VALUE, resultDouble);
            resultDouble = Math.max(Integer.MIN_VALUE, resultDouble);
            return (int) resultDouble;
        }

        return result;
    }


    public static int myAtoi(String str) {

        str = str.trim();

        if (str.isEmpty()) {
            return 0;
        }

        int n = str.length();
        int sign = 1;
        double value = 0;
        for (int i = 0; i < n; i++) {

            if (i== 0 && str.charAt(i) == '+') {
            } else if (i== 0 && str.charAt(i) == '-') {
                sign = -1;
            } else if (Character.isDigit(str.charAt(i))) {
                int currentDigit = Character.getNumericValue(str.charAt(i));
                value = (value * 10) + currentDigit;
            } else {
                break;
            }
        }
        value = value * sign;
        value = Math.min(Integer.MAX_VALUE, value);
        value = Math.max(Integer.MIN_VALUE, value);

        return (int) value;
    }


}

package crack.code.interview.algorithms.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Reverse Integer.
 *
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer
 * range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the
 * reversed integer overflows.
 */
public class ReverseInteger {

    public static void main(String[] args) {
        int input = 1534236469;
        System.out.println("Reverse Integer of: " + input + "-is-" + reverse(input));
    }

    public static int reverse(int x) {

        String value = String.valueOf(x);
        List<String> valueList = new ArrayList<>();
        for (int i = 0; i < value.length(); i++){
            valueList.add(String.valueOf(value.charAt(i)));
        }
        boolean isNegative = false;
        int index = 0;
        if (!valueList.isEmpty() && "-".equals(valueList.get(0))) {
            isNegative = true;
            index = 1;
        }
        StringBuilder response = new StringBuilder();
        for (int i = valueList.size(); i > 0; i--){
            String currentValue = valueList.get(i-1);
            Integer currentValueInt = Integer.parseInt(currentValue);
            if (currentValueInt < 0) {
                isNegative = true;
            }
            response.append(currentValueInt.shortValue());
        }
        Integer reverseInt = Integer.parseInt(response.toString());
        if (isNegative) {
            reverseInt = reverseInt * -1;
        }
        return reverseInt;
    }
}

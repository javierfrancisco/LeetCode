package crack.code.interview.algorithms.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IntegerToRoman {

    public static void main(String[] args) {
        int input = 3250;
        System.out.println("IntegerToRoman: " + intToRoman(input));
    }

    public static String intToRoman2(int num) {

        Map<Integer,String> romanAlphabet = new HashMap<>();
        romanAlphabet.put(1,"I");
        romanAlphabet.put(5,"V");
        romanAlphabet.put(10,"X");
        romanAlphabet.put(50,"L");
        romanAlphabet.put(100,"C");
        romanAlphabet.put(500,"D");
        romanAlphabet.put(1000,"M");

        StringBuilder romanNumber = new StringBuilder();
        int decimalPosition = 1000;
        while (decimalPosition >= 1) {
            int currentValue = num / decimalPosition;
            int calculatedValue = currentValue * decimalPosition;
            if (currentValue > 0 &&  currentValue < 4){
                for (int i = 0; i < currentValue; i++) romanNumber.append(romanAlphabet.get(decimalPosition));
            } else if (currentValue == 4){
                romanNumber.append(romanAlphabet.get(decimalPosition));
                romanNumber.append(romanAlphabet.get(decimalPosition  * 5));
            } else if (currentValue == 5){
                romanNumber.append(romanAlphabet.get(decimalPosition  * 5));
            } else if (currentValue > 5 && currentValue < 9){
                romanNumber.append(romanAlphabet.get(decimalPosition  * 5));
                for (int i = 5; i < currentValue; i++) romanNumber.append(romanAlphabet.get(decimalPosition));
            } else if (currentValue == 9){
                romanNumber.append(romanAlphabet.get(decimalPosition));
                romanNumber.append(romanAlphabet.get(decimalPosition  * 10));
            }
            num = num - calculatedValue;
            decimalPosition = decimalPosition / 10;
        }

        return romanNumber.toString();
    }


    public static String intToRoman(int num) {

        StringBuilder result = new StringBuilder();
        int[] div = {1000, 900, 500, 400, 100, 90,
                50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC",
                "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < div.length;) {
            if (num >= div[i]) {
                result.append(roman[i]);
                num -= div[i];
            } else {
                i++;
            }
        }

        return result.toString();
    }


    }

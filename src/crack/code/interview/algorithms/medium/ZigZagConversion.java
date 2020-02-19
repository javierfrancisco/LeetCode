package crack.code.interview.algorithms.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 *
 */
public class ZigZagConversion {


    public static void main(String[] args) {
        String input = "ABCD";
        System.out.println("ZigZagConversion: " + convert(input, 2));
    }

    public static String convert(String s, int numRows) {

        if (s.isEmpty() || numRows == 1) {
            return s;
        }
        int valueLength = s.length();
        int cycleLength = (numRows * 2) -2;
        char[] conversion = new char[valueLength];
        int position = 0;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < valueLength; j+=cycleLength) {

                conversion[position] = s.charAt(j + i);

                //if row is not first or last (edge) and next value is within limits
                if (i != 0 && i != numRows -1 && j + cycleLength - i < valueLength) {
                    position += 1;
                    conversion[position] = s.charAt(j + cycleLength - i);
                }

                position += 1;
            }
        }


        return String.valueOf(conversion);
    }

    public static String convertOptionA(String s, int numRows) {

        if (s.isEmpty() || numRows == 1) {
            return s;
        }
        int valueLength = s.length();
        StringBuilder[] conversionRows = new StringBuilder[valueLength];
        for (int i = 0; i < valueLength; i++) {
            conversionRows[i] = new StringBuilder();
        }
        boolean isGoingDown = false;
        int numRow = 0;
        for (int i = 0; i < valueLength; i++) {

            conversionRows[numRow] = conversionRows[numRow].append(s.charAt(i));

            if (numRow == 0 || numRow == numRows - 1) {
                isGoingDown = !isGoingDown;
            }
            numRow += isGoingDown ? 1 : -1;
        }

        StringBuilder conversion = new StringBuilder();
        for (int i = 0; i < valueLength; i++) {
            conversion.append(conversionRows[i]);
        }

        return conversion.toString();
    }

}

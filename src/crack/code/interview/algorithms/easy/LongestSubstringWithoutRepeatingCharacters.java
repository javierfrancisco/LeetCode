package crack.code.interview.algorithms.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String input = "bcdebb";
        System.out.println("Longest subs: " + lengthOfLongestSubstring(input));
    }

    public static int lengthOfLongestSubstring(String s) {

        int n = s.length();
        int i = 0;
        int j = 0;
        int ans = 0;
        Set<Character> set = new HashSet<>();

        while (j < n) {
            if (!set.contains(s.charAt(j))) {
                //move window to right
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                //move window from left
                set.remove(s.charAt(i++));
            }
        }

        return ans;
    }

}

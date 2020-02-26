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

    /**
     * By using HashSet as a sliding window, checking if a character in the current can be done in O(1)O(1).
     *
     * A sliding window is an abstract concept commonly used in array/string problems.
     * A window is a range of elements in the array/string which usually defined by the start and end indices,
     * i.e. [i, j)[i,j) (left-closed, right-open). A sliding window is a window "slides" its two boundaries to
     * the certain direction. For example, if we slide [i, j)[i,j) to the right by 11 element, then it becomes
     * [i+1, j+1)[i+1,j+1) (left-closed, right-open).
     *
     * Back to our problem. We use HashSet to store the characters in current window
     * [i, j)[i,j) (j = ij=i initially). Then we slide the index jj to the right.
     * If it is not in the HashSet, we slide jj further. Doing so until s[j] is already in the HashSet.
     * At this point, we found the maximum size of substrings without duplicate characters start with index ii.
     * If we do this for all ii, we get our answer.
     *
     * @param s
     * @return
     */
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

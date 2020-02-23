package crack.code.interview.algorithms.medium;

public class MinimumNumberOfStepsToMakeTwoStringsAnagram {

    public static void main (String... args) {

        String s = "juevesh";
        String t = "viernes";
        System.out.println("Result:" + minSteps(s,t));
    }

    /**
     * Algo:
     * Build int arrays for each String where each index is a char position and the value is the frequency
     * For all characters in s
     * If frequency is same then move one position
     * If frequency on s[i] < t[i], find a position x, where s[x] > t[x], then replace
     * If frequency is more, move right, and look where frequency is less then replace.
     * if frequency is less, move right, and look where frequency is more then replace.
     *
     * @param s
     * @param t
     * @return
     */
    public static int minSteps(String s, String t) {

        int n  = s.length();
        int charsSize = 28;
        int charDiff = 97;
        int[] sCharFrequency = new int[charsSize];
        int[] tCharFrequency = new int[charsSize];

        for (int i = 0; i < n; i++) {
            int currentSChar = s.charAt(i) - charDiff;
            int currentTChar = t.charAt(i) - charDiff;
            sCharFrequency[currentSChar] = sCharFrequency[currentSChar] + 1;
            tCharFrequency[currentTChar] = tCharFrequency[currentTChar] + 1;
        }

        int pointerA = 0;
        int minimumNumOfSteps = 0;
        for (int i = 0; i < charsSize; i++) {
            if (sCharFrequency[pointerA] < tCharFrequency[pointerA]) {
                int m = tCharFrequency[pointerA] - sCharFrequency[pointerA];
                for (int j = 0; j < m; j++) {
                    int sPointer = i;
                    while (sCharFrequency[sPointer] <= tCharFrequency[sPointer] ) {
                        sPointer++;
                    }
                    tCharFrequency[sPointer] = tCharFrequency[sPointer] + 1;
                    tCharFrequency[i] = tCharFrequency[i] - 1;
                    minimumNumOfSteps++;
                }
            } else if (sCharFrequency[pointerA] > tCharFrequency[pointerA]) {
                int m = sCharFrequency[pointerA] - tCharFrequency[pointerA];
                for (int j = 0; j < m; j++) {
                    int sPointer = i;
                    while (tCharFrequency[sPointer]  == 0 || sCharFrequency[sPointer] >= tCharFrequency[sPointer]) {
                        sPointer++;
                    }
                    tCharFrequency[sPointer] = tCharFrequency[sPointer] - 1;
                    tCharFrequency[i] = tCharFrequency[i] + 1;
                    minimumNumOfSteps++;
                }
            }
            pointerA++;
        }
        return minimumNumOfSteps;
    }
}

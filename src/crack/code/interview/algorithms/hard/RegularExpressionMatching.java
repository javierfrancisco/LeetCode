package crack.code.interview.algorithms.hard;

import java.util.Arrays;

public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] input = new int[]{1,2,0};
        System.out.println("firstMissingPositive: " + firstMissingPositive(input));
    }


    public static int firstMissingPositiveA(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length;
        int missingValue = 1;

        for (int i = 0; i < n; i++){
            if (nums[i] > 0 && nums[i] == missingValue) {
                missingValue++;
            }
        }

        return missingValue;
    }

    public static int firstMissingPositive(int[] nums) {

        int n = nums.length;
        //int missingValue = 1;
        boolean containsOne = false;

        //Check if 1 is present in the array. If not, you're done and 1 is the answer
        for (int i = 0; i < n; i++){
            if (nums[i] == 1) {
                containsOne = true;
            }
        }
        if (!containsOne) {
            return 1;
        }

        //If nums = [1], the answer is 2.
        if (n == 1){
            return 2;
        }

        //Replace negative numbers, zeros, and numbers larger than n by 1s.
        for (int i = 0; i < n; i++){

            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        //Walk along the array. Change the sign of a-th element if you meet number a.
        // Be careful with duplicates : do sign change only once. Use index 0 to save
        // an information about presence of number n since index n is not available.
        for (int i = 0; i < n; i++){
            int a = Math.abs(nums[i]);
            if (a == n) {
                nums[0] = - Math.abs(nums[0]);
            } else {
                nums[a] = - Math.abs(nums[a]);
            }
        }
        //Walk again along the array. Return the index of the first positive element.
        for (int i = 1; i < n; i++){
            int a = nums[i];
            if (a > 0) {
                return i ;
            }
        }
        if (nums[0] > 0){
            return n;
        }

        //If nums[0] > 0 return n.

        //If on the previous step you didn't find the positive element in nums,
        // that means that the answer is n + 1.
        return n + 1;
    }
}

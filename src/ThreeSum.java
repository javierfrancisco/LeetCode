import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * The solution set must not contain duplicate triplets.
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum {


    public static void main(String[] args) {


        int[] nums = {-1, 0, 1, 2, -1, -4};
        // int[] nums = {0, 0, 0, 0,0, 0};

        List<List<Integer>> results = threeSum(nums);

        results.stream().iterator().forEachRemaining(System.out::println);
        //System.out.println("---Natural Sorting by Name---");
        //results.forEach(Collections::sort);
        //results.stream().distinct().iterator().forEachRemaining(System.out::println);
        //System.out.println("------");
    }


    public static List<List<Integer>> threeSum(int[] nums) {

        List<Integer> list = Arrays.stream(nums).boxed().collect(toList());
        list = list.stream().sorted().collect(toList());
        int arr_size = nums.length;
        int A[] = list.stream().mapToInt(i->i).toArray();
        int sum = 0;

        if (list.size() > 2 && list.get(0) == 0 && list.get(list.size()-1) == 0){

            List<Integer> uniqueCombination = new ArrayList<>();
            uniqueCombination.add(0);
            uniqueCombination.add(0);
            uniqueCombination.add(0);
            List<List<Integer>> result = new ArrayList<>();
            result.add(uniqueCombination);

            return result;
        }

        //list.stream().iterator().forEachRemaining(System.out::println);

        List<Integer> combination = new ArrayList<>();
        List<List<Integer>> results = new ArrayList<>();
        if (A[0] > 0) {
            return results;
        }

        for (int i = 0; i < arr_size - 2; i++) {


            // To find the other two elements, start two index variables
            // from two corners of the array and move them toward each
            // other
            int l = i + 1; // index of the first element in the remaining elements
            int r = arr_size - 1; // index of the last element
            while (l < r) {
                if (A[i] + A[l] + A[r] == sum) {
                    //System.out.print("Triplet is " + A[i] + ", " + A[l] + ", " + A[r]);
                    combination.add(A[i]);
                    combination.add(A[l]);
                    combination.add(A[r]);
                    results.add(combination);
                    combination = new ArrayList<>();
                }

                if (A[i] + A[l] + A[r] < sum){
                    l++;
                }   else {
                    // A[i] + A[l] + A[r] > sum
                    r--;
                }
            }
        }
        results.forEach(Collections::sort);
        return results.stream().distinct().collect(toList());

    }



}

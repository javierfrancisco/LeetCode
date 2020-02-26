package crack.code.interview.algorithms.medium;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ReduceArraySizeToTheHalf {

    public static void main(String[] args) {
        //int[] input = new int[]{3,3,3,3,5,5,5,2,2,7};//2
        //[] input = new int[]{1,2,3,4,5,6,7,8,9,10};//5
        int[] input = new int[]{1000,1000,3,71};//1
        //int[] input = new int[]{1,2,3,4,5,6,7,8,9,10};//5
        System.out.println("StringToInteger: " + minSetSize(input));
    }


    public static int minSetSize(int[] arr) {

        int n = arr.length;
        int targetSize = n/2;
        Map<Integer, Integer> intFrequencyMap = new HashMap<>();
        for (int currentValue : arr) {
            if (intFrequencyMap.containsKey(currentValue)) {
                intFrequencyMap.put(currentValue, intFrequencyMap.get(currentValue) + 1);
            } else {
                intFrequencyMap.put(currentValue, 1);
            }
        }

        Collection<Integer> frequency =  intFrequencyMap.values();
        Integer[] frequencyArr = frequency.toArray(new Integer[frequency.size()]);
        Arrays.sort(frequencyArr, (a, b) -> Integer.compare(b, a));

        int reduxSize = 0;
        int index = 0;
        while (reduxSize < targetSize){
            int currentFrequency = frequencyArr[index];
            reduxSize += currentFrequency;
            index++;
        }
        return index;
    }
}

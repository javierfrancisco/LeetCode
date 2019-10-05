package crack.code.interview;

import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
public class MergeIntervals {


    public static void main(String[] args) {

        int[][] a = {{19,20},{1,3},{2,6},{8,10},{15,18}};
        int[][] res = {{1,6},{8,10},{15,18}};

        printArray(merge(a));
    }

    public static int[][] merge(int[][] intervals) {

        if (intervals.length == 0) {
            return new int[0][0];
        }
        List<Range> ranges = new ArrayList<>();
        for(int i = 0 ; i < intervals.length; i++) {
            ranges.add(new Range(intervals[i][0], intervals[i][1]));
        }
        Collections.sort(ranges, Comparator.comparing(Range::getLowRange));

        List<Range> result = new LinkedList<>();
        Range current = ranges.get(0);
        result.add(current);
        for(int i = 1 ; i < ranges.size() ; i++) {

            current = result.remove(result.size()-1);
            Range next = ranges.get(i);

            if (current.getHighRange() >= next.getLowRange()){
                //merge
                result.add(new Range(current.getLowRange(), Math.max(current.getHighRange(), next.getHighRange())));
            } else {
                result.add(current);
                result.add(next);
            }
        }

        int[][] intervalsResult = new int[result.size()][2];
        int i = 0;
        for (Range item: result) {
            intervalsResult[i][0] = item.getLowRange();
            intervalsResult[i][1] = item.getHighRange();
            i++;
        }

        return intervalsResult;
    }



    public static void printArray(int[][] intervals) {
        for(int i = 0; i < intervals.length; i++){
            for(int j = 0; j < 2; j++){
                System.out.println(">"+intervals[i][j]+"<");
            }
        }
    }
}


class Range {

    private int lowRange;
    private int highRange;

    public Range(int lowRange, int highRange){
        this.setLowRange(lowRange);
        this.setHighRange(highRange);
    }

    public int getLowRange() {
        return lowRange;
    }

    public void setLowRange(int lowRange) {
        this.lowRange = lowRange;
    }

    public int getHighRange() {
        return highRange;
    }

    public void setHighRange(int highRange) {
        this.highRange = highRange;
    }
}

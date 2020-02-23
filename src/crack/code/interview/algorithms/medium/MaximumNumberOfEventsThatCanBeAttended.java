package crack.code.interview.algorithms.medium;

import java.util.*;

public class MaximumNumberOfEventsThatCanBeAttended {


    public static void main (String... args) {
        //int[][] events = new int[][]{{1,2},{2,3},{3,4},{1,2}};
        //[[1,4],[4,4],[2,2],[3,4],[1,1]]
        //int[][] events = new int[][]{{1,4},{4,4},{2,2},{3,4},{1,1}};//4
        //[[1,100000]]
        //int[][] events = new int[][]{{1,100000}};//4
        //[[1,2],[2,3],[3,4],[1,2]]
        //int[][] events = new int[][]{{1,2},{2,3},{3,4},{1,2}};//4
        //[[1,5],[1,5],[1,5],[2,3],[2,3]]
        //int[][] events = new int[][]{{1,5},{1,5},{1,5},{2,3},{2,309}};//5
        //[[1,2],[1,2],[1,6],[1,2],[1,2]]//3
        //int[][] events = new int[][]{{1,2},{1,2},{1,6},{1,2},{1,2}};//3
        //[[1,2],[2,2],[3,3],[3,4],[3,4]]
        int[][] events = new int[][]{{1,2},{2,2},{3,3},{3,4},{3,4}};
        //[[1,2],[1,2],[3,3],[1,5],[1,5]]//5
        //int[][] events = new int[][]{{1,2},{1,2},{3,3},{1,5},{1,4}};
        //[[1,3],[1,3],[1,3],[3,4]]//4
        //int[][] events = new int[][]{{1,3},{1,3},{1,3},{3,4}};
        //System.out.println("Result:" + maxEvents(events));
        //int[][] events = new int[][]{{1,1},{1,2},{1,3},{1,4},{1,5},{1,6},{1,7}};
        System.out.println("Result:" + maxEvents(events));
    }


    public static int maxEvents(int[][] events) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int i = 0, res = 0, n = events.length;
        for (int d = 1; d <= 100000; ++d) {
            while (!pq.isEmpty() && pq.peek() < d)
                pq.poll();
            while (i < n && events[i][0] == d)
                pq.offer(events[i++][1]);
            if (!pq.isEmpty()) {
                pq.poll();
                ++res;
            }
        }
        return res;
    }
}

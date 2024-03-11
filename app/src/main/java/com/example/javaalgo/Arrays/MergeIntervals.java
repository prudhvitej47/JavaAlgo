package com.example.javaalgo.Arrays;

import java.util.*;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparing(interval -> interval[0]));

        for (int i = 0; i < intervals.length; i++) {
            q.add(intervals[i]);
        }

        int[] temp = q.poll();

        while (!q.isEmpty()) {
            int[] currInterval = q.poll();

            if (currInterval[0] <= temp[1]) {
                temp[1] = Math.max(currInterval[1], temp[1]);
            } else {
                result.add(temp);
                temp = currInterval;
            }
        }
        result.add(temp);

        int[][] ans = new int[result.size()][];
        return result.toArray(ans);
    }

    public static void main(String[] args) {
//        int[][] intervals = new int[][]{
//                {1,3},
//                {2,6},
//                {8,10},
//                {15,18}
//        };

        int[][] intervals = new int[][]{
                {1,4},
                {2,3}
        };

        int[][] result = merge(intervals);
        for (int[] arr: result) {
            for (int i: arr) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}

package com.example.javaalgo.Arrays;

import java.util.ArrayList;
import java.util.List;

// You are given an array of non-overlapping intervals and intervals are sorted in ascending order by starti
// You are given a new interval. Insert it into intervals such that intervals is still sorted by ascending order of starti
// and there are no overlapping intervals
public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        boolean inserted = false;
        List<int[]> result = new ArrayList<>();

        int[] prevInterval = intervals.length != 0 ? intervals[0] : newInterval;
        if (prevInterval[1] >= newInterval[0] && prevInterval[0] <= newInterval[1]) {
            inserted = true;
            prevInterval = new int[]{Math.min(newInterval[0], prevInterval[0]), Math.max(newInterval[1], prevInterval[1])};
        }

        for (int i = 1; i < intervals.length; i++) {
            int[] currInterval = intervals[i];

            if (!inserted && prevInterval[1] >= newInterval[0]) {
                inserted = true;

                if (prevInterval[0] > newInterval[1]) {
                    result.add(newInterval);
                } else {
                    prevInterval = new int[]{Math.min(newInterval[0], prevInterval[0]), Math.max(newInterval[1], prevInterval[1])};
                }
            }

            if (prevInterval[1] >= currInterval[0]) {
                prevInterval = new int[]{Math.min(currInterval[0], prevInterval[0]), Math.max(currInterval[1], prevInterval[1])};
            } else {
                result.add(prevInterval);
                prevInterval = currInterval;
            }
        }

        if (!inserted && prevInterval[1] >= newInterval[0]) {
            inserted = true;

            if (prevInterval[0] > newInterval[1]) {
                result.add(newInterval);
            } else {
                prevInterval = new int[]{Math.min(newInterval[0], prevInterval[0]), Math.max(newInterval[1], prevInterval[1])};
            }
        }

        result.add(prevInterval);

        if (!inserted)
            result.add(newInterval);

        int[][] ans = new int[result.size()][];
        return result.toArray(ans);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {12,15}
        };
        int[] newInterval = new int[]{1,3};

        int[][] result = insert(intervals, newInterval);
        for (int[] arr: result) {
            for (int i: arr) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}

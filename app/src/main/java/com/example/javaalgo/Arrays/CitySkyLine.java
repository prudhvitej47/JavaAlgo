package com.example.javaalgo.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CitySkyLine {

    private static List<List<Integer>> merge(List<List<Integer>> left, List<List<Integer>> right) {
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0; // left's index
        int j = 0; // right's index
        int leftY = 0;
        int rightY = 0;

        while (i < left.size() && j < right.size()) {
            // Choose the point with the smaller x.
            if (left.get(i).get(0) < right.get(j).get(0)) {
                leftY = left.get(i).get(1); // Update the ongoing `leftY`.
                addPoint(ans, left.get(i).get(0), Math.max(left.get(i++).get(1), rightY));
            } else {
                rightY = right.get(j).get(1); // Update the ongoing `rightY`.
                addPoint(ans, right.get(j).get(0), Math.max(right.get(j++).get(1), leftY));
            }
        }

        while (i < left.size()) {
            addPoint(ans, left.get(i).get(0), left.get(i++).get(1));
        }

        while (j < right.size()) {
            addPoint(ans, right.get(j).get(0), right.get(j++).get(1));
        }

        return ans;
    }

    private static void addPoint(List<List<Integer>> ans, int x, int y) {
        if (!ans.isEmpty() && ans.get(ans.size() - 1).get(0) == x) {
            ans.get(ans.size() - 1).set(1, y);
            return;
        }
        if (!ans.isEmpty() && ans.get(ans.size() - 1).get(1) == y)
            return;
        ans.add(new ArrayList<>(Arrays.asList(x, y)));
    }

    public static void main(String[] args) {
        System.out.println(
                merge(
                        List.of(List.of(2,10), List.of(3,15), List.of(7,10), List.of(9,0)),
                        List.of(List.of(5,12), List.of(12,0))
                )
        );
    }
}

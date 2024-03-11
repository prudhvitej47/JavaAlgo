package com.example.javaalgo.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    // Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target.
    // You may return the combinations in any order.
    public static void combinationSumUtil(int[] candidates, int index, int sum, ArrayList<Integer> temp, List<List<Integer>> result) {

        if (sum == 0) {
            // System.out.println("Found sum " + sum + " at " + temp);
            result.add(new ArrayList<>(temp));
            return;
        }

        // System.out.println("Received candidate " + candidates[index] + " with sum " + sum + " and list " + temp);

        for (int i = index; i < candidates.length; i++) {
            if (sum - candidates[i] >= 0) {
                temp.add(candidates[i]);

                // System.out.println("Calling " + candidates[i] + " with sum " + (sum - candidates[i]));
                combinationSumUtil(candidates, i, sum - candidates[i], temp, result);

                temp.remove(temp.size() - 1);
            }
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        combinationSumUtil(candidates, 0, target, new ArrayList<>(), result);

        return result;
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        List<List<Integer>> result = combinationSum(candidates, 7);

        for (List<Integer> arr: result) {
            for (Integer i: arr) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }
    }
}

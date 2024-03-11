package com.example.javaalgo.Arrays;

import java.util.*;

// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int index = i;
            hashMap.merge(nums[index], new ArrayList<>(List.of(index)), (i1, i2) -> {
                i1.add(index);
                return i1;
            });
        }

        for (Map.Entry<Integer, ArrayList<Integer>> e: hashMap.entrySet()) {
            Integer first = e.getKey();
            Integer required = target - first;

            if (required.equals(first) && e.getValue().size() > 1) {
                result[0] = e.getValue().get(0);
                result[1] = e.getValue().get(1);
                break;
            } else if (hashMap.containsKey(required)) {
                result[0] = e.getValue().get(0);
                result[1] = hashMap.get(required).get(0);
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,-2,-3,-4,-5};
        System.out.println(Arrays.toString(twoSum(nums, -8)));
    }
}

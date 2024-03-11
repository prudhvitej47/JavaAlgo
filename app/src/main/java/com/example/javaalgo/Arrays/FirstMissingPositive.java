package com.example.javaalgo.Arrays;

// Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
//You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {

            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                // swap nums[i] with nums[nums[i] - 1]
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i])
                return i + 1;
        }

        return nums.length + 1;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1,2,0}));
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(firstMissingPositive(new int[]{7,8,9,11,12}));
        System.out.println(firstMissingPositive(new int[]{1,2,3,4}));
    }
}

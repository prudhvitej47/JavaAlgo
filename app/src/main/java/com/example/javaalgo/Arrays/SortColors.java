package com.example.javaalgo.Arrays;

import java.util.Arrays;

// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
// Do it in one pass and constant memory
public class SortColors {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sortColors(int[] nums) {
        int l = 0;
        int i = 0;
        int r = nums.length - 1;

        while (i <= r) {
            if (nums[i] == 0) {
                swap(nums, l, i);
                i++;
                l++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                // not increasing `i` as `i` can have 1 or 2 in it still
                swap(nums, i, r);
                r--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}

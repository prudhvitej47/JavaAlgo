package com.example.javaalgo.BinarySearch;

// distinct values
// after: 4,5,6,7,8,9,0,1,2,3
public class SearchRotatedSorted {

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right)/2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                // left is less than mid - so sorted array
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // left is greater than mid - sorted array is still towards right
                if (target >= nums[left] || target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,8,9,0,1,2,3};
        System.out.println(search(nums, 2));
    }
}

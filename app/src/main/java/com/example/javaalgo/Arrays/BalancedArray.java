package com.example.javaalgo.Arrays;

// An array is balanced if the sum of the left half of the array elements is equal to the sum of right half
// min value required to balance the array
public class BalancedArray {

    static long minValueToBalance(long[] a ,int n) {
        int count = 0;
        long firstHalfCount = 0;
        long secondHalfCount = 0;

        for (int i = 0; i < n; i++) {
            if (++count > n/2) {
                secondHalfCount += a[i];
            } else {
                firstHalfCount += a[i];
            }
        }

        return Math.abs(firstHalfCount - secondHalfCount);
    }

    public static void main(String[] args) {
        long[] arr = new long[]{20, 10};
        System.out.println(minValueToBalance(arr, arr.length));
    }
}

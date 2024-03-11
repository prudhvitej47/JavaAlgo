package com.example.javaalgo.BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class MedianTwoSortedArrays {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(7, 12, 15, 16, 18));
        ArrayList<Integer> B = new ArrayList<>(List.of(1, 2, 3, 6, 8, 10));

        System.out.println("Median: " + medianOfTwoSortedArrays(A, B));
    }

    static double medianOfTwoSortedArrays(ArrayList<Integer> A, ArrayList<Integer> B) {

        // pick the biggest array
        if (A.size() < B.size()) {
            return medianOfTwoSortedArrays(B, A);
        }

        int start = 0;
        int end = A.size();
        int actualMedianPoint = (A.size() + B.size() + 1) / 2;

        while (start <= end) {

            int mid = (start + end) / 2;

            // A's left partition
            int leftPartitionASize = mid;

            // B's left partition
            int leftPartitionBSize = actualMedianPoint - mid;

            int leftPartitionALastIndex = leftPartitionASize - 1;
            int leftPartitionBLastIndex = leftPartitionBSize - 1;
            int rightPartitionAFirstIndex = leftPartitionASize;
            int rightPartitionBFirstIndex = leftPartitionBSize;

            int leftALast = leftPartitionALastIndex >= 0 ? A.get(leftPartitionALastIndex) : Integer.MIN_VALUE;
            int leftBLast = leftPartitionBLastIndex >= 0 ? B.get(leftPartitionBLastIndex) : Integer.MIN_VALUE;
            int rightAFirst = rightPartitionAFirstIndex < A.size() ? A.get(rightPartitionAFirstIndex) : Integer.MAX_VALUE;
            int rightBFirst = rightPartitionBFirstIndex < B.size() ? B.get(rightPartitionBFirstIndex) : Integer.MAX_VALUE;

            // correct left partitions in both A and B
            if (leftALast <= rightBFirst && leftBLast <= rightAFirst) {
                System.out.println(leftALast + " " + rightBFirst + "; " + leftBLast + " " + rightAFirst);
                // if even return
                if ((A.size() + B.size()) % 2 == 0) {
                    return (double) (Math.max(leftALast, leftBLast) + Math.min(rightAFirst, rightBFirst)) / 2;
                }
                // if odd return
                return Math.max(leftALast, leftBLast);
            } else if (leftALast > rightBFirst) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return 0.0;
    }
}

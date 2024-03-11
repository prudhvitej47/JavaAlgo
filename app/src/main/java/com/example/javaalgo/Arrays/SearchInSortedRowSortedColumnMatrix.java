package com.example.javaalgo.Arrays;

public class SearchInSortedRowSortedColumnMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0;
        int j = n - 1;

        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                // if greater than the entire column will have elements greater than target
                j--;
            } else {
                // if smaller than go down
                i++;
            }
        }

        return false;
    }
}

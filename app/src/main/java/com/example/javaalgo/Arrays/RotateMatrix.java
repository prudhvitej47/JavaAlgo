package com.example.javaalgo.Arrays;

// given n x n matrix, rotate anti-clockwise
public class RotateMatrix {

    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // swapping items in clockwise pattern
        // (i,j) -> (j,n-1-i)
        // (j,n-1-i) -> (n-1-i,n-1-j)
        // (n-1-i,n-1-j) -> (n-1-j,i)
        // (n-1-j,i) -> (i,j)

        for (int i = 0; i < n/2; i++) {
            for (int j = i; j < n-1-i; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,   2,  3, 4},
                {5,   6,  7, 8},
                {9,  10, 11, 12},
                {13, 14, 15, 16}
        };

        rotate(matrix);

        for (int[] row: matrix) {
            for (int col: row) {
                System.out.print(col + ",");
            }
            System.out.println();
        }
    }
}

package com.example.javaalgo.Arrays;

// Given an m x n integer matrix, if an element is 0, set its entire row and column to 0's.
public class SetZeroesMatrix {

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0 || j == 0) {
                        if (i == 0 && row != 1) {
                            row = 1;
                        }

                        if (j == 0 && col != 1) {
                            col = 1;
                        }
                    } else {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (row == 1) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        if (col == 1) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{
//                {0,1,2,0},
//                {3,4,5,2},
//                {1,3,1,5},
//        };

//        int[][] matrix = new int[][]{
//                {1},
//        };

//        int[][] matrix = new int[][]{
//                {0,9,2,4},
//                {2,0,1,6},
//                {4,9,3,1},
//                {0,2,4,0},
//        };

        int[][] matrix = new int[][]{
                {8,3,6,9,7,8,0,6},
                {0,3,7,0,0,4,3,8},
                {5,3,6,7,1,6,2,6},
                {8,7,2,5,0,6,4,0},
                {0,2,9,9,3,9,7,3},
        };

        setZeroes(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }
    }
}

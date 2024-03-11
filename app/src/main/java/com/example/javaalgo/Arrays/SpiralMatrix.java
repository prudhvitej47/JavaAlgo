package com.example.javaalgo.Arrays;

import java.util.ArrayList;
import java.util.List;

// given m x n matrix
public class SpiralMatrix {

    // print 4 sides starting from (i,j) with m rows and n cols
    public static void addOneRun(int[][] matrix, int row, int col, int m, int n, List<Integer> result) {
        for (int j = col; j <= col + n - 1; j++) {
            result.add(matrix[row][j]);
        }

        for (int i = row + 1; i <= row + m - 1; i++) {
            result.add(matrix[i][col + n - 1]);
        }

        if (m != 1) {
            for (int j = col + n - 2; j >= col; j--) {
                result.add(matrix[row + m - 1][j]);
            }
        }

        if (n != 1) {
            for (int i = row + m - 2; i > row; i--) {
                result.add(matrix[i][col]);
            }
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0;
        int j = 0;
        int rowLength = m;
        int colLength = n;

        while(i < (m+1)/2 && j < (n+1)/2) {
            System.out.println("Printing for " + i + ", " + j + " and length " + rowLength + ", " + colLength);
            addOneRun(matrix, i, j, rowLength, colLength, result);
            i++;
            j++;
            rowLength -= 2;
            colLength -= 2;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1,   2,  3,  4},
                {5,   6,  7,  8},
                {9,  10, 11, 12},
                {13, 14, 15, 16}
        };

//        int[][] matrix = new int[][] {
//                {1,2,3},
//                {4,5,6},
//                {7,8,9}
//        };

//        int[][] matrix = new int[][]{
//                {6,9,7},
//        };

        List<Integer> result = spiralOrder(matrix);

        for (Integer i: result)
            System.out.print(i + ", ");
        System.out.println();
    }
}

package com.example.javaalgo.DP;

import java.util.BitSet;

public class MaximalSquares {

    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxLength = 0;

        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j] == '0' ? 0 : 1;
            maxLength = Math.max(maxLength, dp[0][j]);
        }

        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] == '0' ? 0 : 1;
            maxLength = Math.max(maxLength, dp[i][0]);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    int minCommonLength = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    if (minCommonLength != 0) {
                        dp[i][j] = minCommonLength + 1;
                    } else {
                        dp[i][j] = matrix[i][j] == '0' ? 0 : 1;
                    }
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }

        return maxLength * maxLength;
    }

    public static void main(String[] args) {
        /*char[][] matrix = new char[][]{
                {1, 1, 1, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1},
                {0, 1, 1, 1, 1},
                {0, 1, 1, 1, 1},
        };*/
        
        char[][] matrix = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };

        System.out.println(maximalSquare(matrix));

        BitSet bitSet = new BitSet();
        bitSet.clear(0);
        bitSet.clear(1);
        bitSet.clear(2);
        bitSet.set(3);
        System.out.println(bitSet.nextSetBit(0));
    }
}

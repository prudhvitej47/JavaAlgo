package com.example.javaalgo.DP;

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if (s.isEmpty())
            return "";

        int n = s.length();
        char[] charArr = s.toCharArray();
        int start = 0;
        int maxLength = 1;

        // dp[i][j] stores whether there is a substring starting from index i to j
        boolean[][] dp = new boolean[n][n];

        // populating dp for all substrings of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // populating dp for all substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (charArr[i] == charArr[i + 1]) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // for all substrings of length greater than 2
        // populating diagonally and ending with dp[0][n-1] : important
        for (int k = 3; k <= n; k++) {

            for (int i = 0; i < n - k + 1; i++) {

                int j = k + i - 1;
                if (charArr[i] == charArr[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;

                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }

        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("forgeeksskeegfor"));
    }
}

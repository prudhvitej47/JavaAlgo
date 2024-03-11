package com.example.javaalgo.DP;

// Return the number of combinations
// The answer is guaranteed to fit into a signed 32-bit integer.
public class CoinChange2 {

    public static int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {

                if (coins[i - 1] <= j) {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        System.out.println("Total number of combinations: " + change(5, coins));
    }
}

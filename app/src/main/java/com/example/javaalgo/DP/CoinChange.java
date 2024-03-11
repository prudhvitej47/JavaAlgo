package com.example.javaalgo.DP;

// Min number of coins required to make a given value
public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];

        // to make 0 amount you require 0 coins
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= amount; i++) {

            // iterate over all coins less than amount
            for (int k = 0; k < coins.length; k++) {
                if (coins[k] <= i && dp[i - coins[k]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[k]] + 1);
                }
            }
        }

        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        System.out.println("Min number of coins: " + coinChange(coins, 11));

        coins = new int[]{2};
        System.out.println("Min number of coins: " + coinChange(coins, 3));
    }
}

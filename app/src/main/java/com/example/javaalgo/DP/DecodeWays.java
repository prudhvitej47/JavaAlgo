package com.example.javaalgo.DP;

public class DecodeWays {

    public static int numDecodings(String s) {
        if (s.charAt(0) == '0')
            return 0;

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= s.length(); i++) {
            int sum = 0;
            int strIndex = i - 1;

            if (s.charAt(strIndex) >= '1' && s.charAt(strIndex) <= '9') {
                sum += dp[i - 1];
            }

            if (s.charAt(strIndex - 1) != '0') {
                // i - 1 and i combined
                String temp = s.substring(strIndex - 1, strIndex + 1);
                int val = Integer.parseInt(temp);
                if (val >= 10 && val <= 26) {
                    sum += dp[i - 2];
                }
            }

            dp[i] = sum;
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        String str = "11106";
        System.out.println("Number of ways: " + numDecodings(str));
    }
}

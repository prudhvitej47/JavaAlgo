package com.example.javaalgo.DP;

import java.util.List;

public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            if (wordDict.contains(s.substring(0, i))) {
                dp[i] = true;
            } else {
                for (int j = i - 1; j >= 0; j--) {
                    if (wordDict.contains(s.substring(j, i)) && dp[j]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        List<String> dictionary = List.of("mobile","samsung","sam","sung","man","mango",
                "icecream","and","go","i","like","ice","cream");

        System.out.println(wordBreak("ilikesamsung", dictionary));
        System.out.println(wordBreak("mango", dictionary));
        System.out.println(wordBreak("iiiiiiii", dictionary));
        System.out.println(wordBreak("", dictionary));
        System.out.println(wordBreak("ilikelikeimangoiii", dictionary));
        System.out.println(wordBreak("samsungandmango", dictionary));
        System.out.println(wordBreak("samsungandmangok", dictionary));
    }
}

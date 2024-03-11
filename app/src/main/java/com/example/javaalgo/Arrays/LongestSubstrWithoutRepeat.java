package com.example.javaalgo.Arrays;

import java.util.HashMap;

// Given a string s, find the length of the longest substring without repeating characters.
public class LongestSubstrWithoutRepeat {

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty())
            return 0;

        int i = 1;
        int j = 0;
        int count = 1;
        int maxCount = 1;
        char[] inpString = s.toCharArray();

        HashMap<Character, Integer> dict = new HashMap<>();
        dict.put(inpString[0], 1);

        while (i < inpString.length) {
            // System.out.println("At index: " + i + " with val " + inpString[i]);
            dict.merge(inpString[i], 1, (oldVal, defaultVal) -> oldVal + 1);
            count++;

            // removing from back until unique set is found
            while (j < i && dict.get(inpString[i]) != 1) {
                // System.out.println("Removing index from result " + j + " with val " + inpString[j]);
                dict.computeIfPresent(inpString[j], (ch, oldCount) -> oldCount - 1);
                count--;
                j++;
            }

            maxCount = Math.max(maxCount, count);
            i++;
        }

        return maxCount;
    }

    public static void main(String[] args) {
        // System.out.println(lengthOfLongestSubstring("abcabcbb"));
        // System.out.println(lengthOfLongestSubstring("pwwkew"));
        // System.out.println(lengthOfLongestSubstring("bbbbb"));

        System.out.println(lengthOfLongestSubstring("ab ad"));
    }

}

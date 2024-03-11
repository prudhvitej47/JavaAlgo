package com.example.javaalgo.Arrays;

import java.util.HashMap;
import java.util.Objects;

// Given two strings s and t of lengths m and n respectively, return the minimum window substring
// of s such that every character in t (including duplicates) is included in the window.
// If there is no such substring, return the empty string "".
public class MinWindowSubstring {

    public static String minWindow(String s, String t) {
        char[] input = s.toCharArray();
        char[] target = t.toCharArray();

        HashMap<Character, Integer> inputMap = new HashMap<>();
        HashMap<Character, Integer> targetMap = new HashMap<>();

        for (int i = 0; i < target.length; i++) {
            targetMap.merge(target[i], 1, (oldVal, newVal) -> oldVal + 1);
        }

        int l = 0;
        int count = 0;
        int requiredCount = t.length();
        int minStart = -1;
        int minLength = Integer.MAX_VALUE;
        int actCount = 0;

        for (int i = 0; i < input.length; i++) {
            char currChar = input[i];
            inputMap.merge(currChar, 1, (oldVal, newVal) -> oldVal + 1);

            if (targetMap.containsKey(currChar)) {
                if (targetMap.get(currChar) >= inputMap.get(currChar)) {
                    actCount++;
                }
                count++;
            }

            if (count == 0) {
                l++;
                continue;
            }

            int length = i - l + 1;
            if (actCount == requiredCount && length < minLength) {
                minStart = l;
                minLength = length;
            }

            while (count > requiredCount && l <= i && (!targetMap.containsKey(input[l]) || (targetMap.get(input[l]) < inputMap.get(input[l])))) {
                int temp = inputMap.get(input[l]);
                if (temp == 1)
                    inputMap.remove(input[l]);
                else
                    inputMap.put(input[l], temp-1);
                l++;
                if (actCount == requiredCount && i - l + 1 < minLength) {
                    minStart = l;
                    minLength = i - l + 1;
                }
                if (targetMap.containsKey(input[l]))
                    count--;
            }
        }

        if (minStart == -1)
            return "";
        return s.substring(minStart, minStart + minLength);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("XYZCBFODEC", "CODE"));
        System.out.println(minWindow("a", "aa"));
        System.out.println(minWindow("bba", "ab"));
        System.out.println(minWindow("aaaaaaabbbbbcdd", "abcdd"));
    }

}

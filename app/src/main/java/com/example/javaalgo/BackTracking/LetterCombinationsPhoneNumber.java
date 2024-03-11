package com.example.javaalgo.BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
// Return the answer in any order.
// 1 does not map to any letter
// 2 maps to a,b,c
// 3 maps to d,e,f
// 4 maps to g,h,i
// 5 maps to j,k,l
// 6 maps to m,n,o
// 7 maps to p,q,r,s
// 8 maps to t,u,v
// 9 maps to w,x,y,z
// example - digits = "23"
// result - ["ad","ae","af","bd","be","bf","cd","ce","cf"]
public class LetterCombinationsPhoneNumber {

    public static void letterCombinationUtils(String digits, HashMap<Character, List<Character>> digitMap, int index,
                                       StringBuilder temp, List<String> result) {
        if (index == digits.length()) {
            result.add(temp.toString());
            return;
        }

        List<Character> availableChars = digitMap.get(digits.charAt(index));

        for (Character c: availableChars) {
            temp.append(c);
            letterCombinationUtils(digits, digitMap, index + 1, temp, result);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (!digits.isEmpty()) {
            HashMap<Character, List<Character>> digitMap = new HashMap<>(){{
                put('2', List.of('a', 'b', 'c'));
                put('3', List.of('d', 'e', 'f'));
                put('4', List.of('g', 'h', 'i'));
                put('5', List.of('j', 'k', 'l'));
                put('6', List.of('m', 'n', 'o'));
                put('7', List.of('p', 'q', 'r', 's'));
                put('8', List.of('t', 'u', 'v'));
                put('9', List.of('w', 'x', 'y', 'z'));
            }};
            StringBuilder sb = new StringBuilder();
            letterCombinationUtils(digits, digitMap, 0, sb, result);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> str = letterCombinations("23");
        for (String s: str) {
            System.out.println(s);
        }

    }
}

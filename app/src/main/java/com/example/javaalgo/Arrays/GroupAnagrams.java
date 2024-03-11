package com.example.javaalgo.Arrays;

import java.util.*;

public class GroupAnagrams {

    public static String sortString(String str) {
        char[] tempArr = str.toCharArray();
        Arrays.sort(tempArr);
        return new String(tempArr);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        String[] strSorted = new String[strs.length];
        HashMap<String, List<String>> stringMap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            strSorted[i] = sortString(strs[i]);
            stringMap.merge(strSorted[i], new ArrayList<>(List.of(strs[i])), (oldVal, newVal) -> {
                oldVal.addAll(newVal);
                return oldVal;
            });
        }

        for (Map.Entry<String, List<String>> e: stringMap.entrySet()) {
            result.add(e.getValue());
        }

        return result;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(strs);

        char[] ch = Integer.toBinaryString(128).toCharArray();
        System.out.println(ch);
    }
}

package com.example.javaalgo.Trees;

import java.util.*;

public class WordLadder {

    public static int ladderLengthUtil(String currWord, String destWord, int numTransform,
                                       HashSet<String> visited, HashMap<String, List<String>> dict) {
        if (currWord.equals(destWord)) {
            System.out.println("FINALLY at with val " + numTransform);
            return numTransform;
        }

        int minVal = Integer.MAX_VALUE;
        visited.add(currWord);

        System.out.println("At word: " + currWord);

        for (String adjWord: dict.get(currWord)) {
            if (!visited.contains(adjWord)) {
                System.out.println("Going to: " + adjWord);
                minVal = Math.min(minVal, ladderLengthUtil(adjWord, destWord, numTransform + 1, visited, dict));
            }
        }

        visited.remove(currWord);

        return minVal;
    }

    public static boolean differByOne(String wordA, String wordB) {
        if (wordA.length() != wordB.length())
            return false;

        /*int[] ch = new int[26];
        for (int i = 0; i < wordA.length(); i++) {
            ch[wordA.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < wordB.length(); i++) {
            ch[wordB.charAt(i) - 'a'] -= 1;
        }

        int diff = 0;
        for (int j : ch) {
            if (j != 0)
                diff++;

            if (diff > 2)
                return false;
        }
        return diff == 2;*/

        int diff = 0;
        for (int i = 0; i < wordA.length(); i++) {
            if (wordA.charAt(i) != wordB.charAt(i))
                diff++;

            if (diff > 1)
                return false;
        }
        return diff == 1;
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> dict = new HashMap<>();
        wordList.add(beginWord);

        Collections.sort(wordList);

        for (int i = 0; i < wordList.size(); i++) {
            String currWord = wordList.get(i);
            dict.putIfAbsent(currWord, new ArrayList<>());

            for (int j = i + 1; j < wordList.size(); j++) {
                String otherWord = wordList.get(j);
                dict.putIfAbsent(otherWord, new ArrayList<>());

                if (differByOne(currWord, otherWord)) {
                    dict.get(currWord).add(otherWord);
                    dict.get(otherWord).add(currWord);
                }
            }
        }

        int val = ladderLengthUtil(beginWord, endWord, 1, new HashSet<>(), dict);
        if (val == Integer.MAX_VALUE)
            return 0;
        return val;
    }

    public static void main(String[] args) {
        // System.out.println(ladderLength("hit", "cog", new ArrayList<>(List.of("hot","dot","dog","lot","log","cog"))));
        System.out.println(ladderLength("leet", "code", new ArrayList<>(List.of("lest","leet","lose","code","lode","robe","lost"))));

        // System.out.println(differByOne("lame", "lame"));
    }
}

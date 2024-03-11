package com.example.javaalgo.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Given a list of strings, count pairs of strings that are either equal to each other
// or one string is prefix of another
// example: ["back", "come", "door", "gammon", "backdoor", "backgammon", "comeback"]
// output 3
// back - backdoor, back - backgammon, come - comeback
public class WordPrefixSearch {

    // using trie
    static class Node {
        Character val;
        Map<Character, Node> children;
        int count;  // count of words ending at this node

        Node(Character val) {
            this.val = val;
            this.children = new HashMap<>();
            this.count = 0;
        }

        void addChild(Character ch, Node childNode) {
            this.children.put(ch, childNode);
        }

        void incrementCount() {
            this.count += 1;
        }
    }

    static int addChildRec(Node currNode, String word, int index) {
        if (index == word.length()) {
            currNode.incrementCount();
            return currNode.count - 1;
        }

        Character ch = word.charAt(index);
        Node newNode;
        if (currNode.children.containsKey(ch)) {
            newNode = currNode.children.get(ch);
        } else {
            newNode = new Node(ch);
            currNode.addChild(ch, newNode);
        }

        int wordsEndingHere = 0;
        if (currNode.count != 0) {
            wordsEndingHere += currNode.count;
        }

        wordsEndingHere = wordsEndingHere + addChildRec(newNode, word, index + 1);

        return wordsEndingHere;
    }

    public static int wordPrefixSearch(String[] words) {

        Arrays.sort(words);

        Node root = new Node(null);

        int count = 0;
        for (String word: words) {
            int newCount = addChildRec(root, word, 0);
            System.out.println("On adding word " + word + " I got count of " + newCount);
            count += newCount;
        }

        return count;
    }

    public static void main(String[] args) {
        // System.out.println(wordPrefixSearch(new String[]{"back", "door", "come", "gammon", "backdoor", "comeback", "backgammon"}));
        System.out.println(wordPrefixSearch(new String[]{"a", "ass", "a", "and", "andor", "asstrix", "pandora"}));
    }
}

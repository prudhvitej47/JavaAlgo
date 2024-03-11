package com.example.javaalgo.BackTracking;

import java.util.ArrayList;
import java.util.List;

// Given n, generate all combinations of balanced parentheses of n pairs
public class GenerateParentheses {

    public static void generateParenthesisUtil(StringBuilder temp, int totalOpen, int totalClosed, int n, List<String> result) {
        if (temp.length() == 2 * n && totalOpen == totalClosed) {
            result.add(temp.toString());
            return;
        } else if (totalOpen < totalClosed || totalOpen > n || totalClosed > n) {
            return;
        }

        temp.append('(');
        generateParenthesisUtil(temp, totalOpen + 1, totalClosed, n, result);
        temp.deleteCharAt(temp.length() - 1);

        temp.append(')');
        generateParenthesisUtil(temp, totalOpen, totalClosed + 1, n, result);
        temp.deleteCharAt(temp.length() - 1);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        generateParenthesisUtil(sb, 0, 0, n, result);

        return result;
    }

    public static void main(String[] args) {

        List<String> result = generateParenthesis(3);

        for (String res: result) {
            System.out.println(res);
        }
    }
}

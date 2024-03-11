package com.example.javaalgo.Arrays;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/text-justification/
public class TextJustification {

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<>();
        int i = 0;
        int currentWidth = 0;
        List<String> currentWords = new ArrayList<>();

        while (i < words.length) {

            boolean includeSpace = currentWidth != 0;
            int temp = currentWidth + (includeSpace ? 1 : 0) + words[i].length();

            if (temp > maxWidth) {
                // include the current word in next line

                // divide spaces among the words
                int remainingWidth = maxWidth - currentWidth;

                String currentLineString = addSpaces(remainingWidth, currentWords, false);

                lines.add(currentLineString);

                // clear string builder
                currentWords.clear();
                currentWidth = 0;
            } else {
                // include current word in current line
                currentWords.add((includeSpace ? " " : "") + words[i]);
                currentWidth = temp;
                i++;
            }
        }

        lines.add(addSpaces(maxWidth - currentWidth, currentWords, true));

        return lines;
    }

    public static String addSpaces(int remainingWidth, List<String> words, boolean isLast) {
        StringBuilder sb = new StringBuilder();
        int spacesToAdd;
        int remainingSpacesToAdd;

        // last line should be fully justified
        if (isLast || words.size() == 1) {
            spacesToAdd = 0;
            remainingSpacesToAdd = remainingWidth;
        } else {
            spacesToAdd = remainingWidth / (words.size() - 1);
            remainingSpacesToAdd = remainingWidth % (words.size() - 1);
        }

        for (int k = 0; k < words.size(); k++) {
            sb.append(words.get(k));

            if (spacesToAdd > 0 && k != words.size() - 1) {
                sb.append(" ".repeat(spacesToAdd));
            }

            if (!isLast && remainingSpacesToAdd > 0) {
                sb.append(" ");
                remainingSpacesToAdd--;
            }
        }

        sb.append(" ".repeat(remainingSpacesToAdd));

        return sb.toString();
    }

    public static void main(String[] args) {
        // System.out.println(addSpaces(18, List.of("This", " is", " a", " test"), true) + ";");

        // List<String> result = fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
        // List<String> result = fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16);
        List<String> result = fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20);

        for (String res: result) {
            System.out.println(res + ";");
        }
    }
}

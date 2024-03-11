package com.example.javaalgo.BackTracking;

public class WordSearch {

    // down, up, left, right
    static int[] xDir = new int[]{1, -1, 0, 0};
    static int[] yDir = new int[]{0, 0, -1, 1};

    public static boolean existUtil(char[][] board, int i, int j, int m, int n, int currentLength, String word,
                                    boolean[][] visited) {

        if (currentLength > word.length() || board[i][j] != word.charAt(currentLength - 1)) {
            return false;
        } else if (currentLength == word.length() && board[i][j] == word.charAt(currentLength - 1)) {
            return true;
        }

        visited[i][j] = true;
        boolean result = false;

        for (int k = 0; k < xDir.length; k++) {
            int newX = i + xDir[k];
            int newY = j + yDir[k];

            if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                result = existUtil(board, newX, newY, m, n, currentLength + 1, word, visited);
                if (result)
                    break;
            }
        }

        visited[i][j] = false;
        return result;
    }

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        // find the first occurrence of the word
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean result = existUtil(board, i, j, m, n, 1, word, visited);
                if (result)
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        String word = "ABCCED";
        System.out.println("Does word " + word + " exist: " + exist(board, word));
    }
}

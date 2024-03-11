package com.example.javaalgo.Arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

// assume r * c is odd
// so row is odd and column is also odd
public class MedianInSortedRowMatrix {

    static class Node {
        int val;
        int row;
        int col;

        Node(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }

    public static int medianSortedRowMatrix(int[][] matrix, int r, int c) {
        // PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (a.val < b.val) {
                return -1;
            } else if (a.val > b.val) {
                return 1;
            } else {
                int first = 0;
                int second = 0;

                if (a.col + 1 < c) {
                    first = matrix[a.row][a.col + 1];
                }

                if (b.col + 1 < c) {
                    second = matrix[b.row][b.col + 1];
                }

                return first - second;
            }
        });

        for (int i = 0; i < r; i++) {
            pq.add(new Node(matrix[i][0], i, 0));
        }

        Node nextVal = null;
        int medianPos = (r * c) / 2;

        while (medianPos-- >= 0) {
            nextVal = pq.poll();

            System.out.println("Printing " + nextVal.val + " at row " + nextVal.row);
            int currRow = nextVal.row;
            int nextCol = nextVal.col;

            if (nextCol + 1 < c) {
                pq.add(new Node(matrix[currRow][nextCol + 1], currRow, nextCol + 1));
            }
        }

        return nextVal.val;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,3,5},
                {0,2,9},
                {2,4,6}
        };

        System.out.println(medianSortedRowMatrix(matrix, 3, 3));
    }
}

package com.example.javaalgo.Arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SortMatrixDiagonally {

    public static void diagonalSortUtil(int[][] mat, int row, int col, int m, int n, PriorityQueue<Integer> pq) {
        if (row >= m || col >= n)
            return;

        pq.add(mat[row][col]);

        diagonalSortUtil(mat, row + 1, col + 1, m, n, pq);

        mat[row][col] = pq.poll();
    }

    public static int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int i = m - 1;
        while (i >= 0) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

            diagonalSortUtil(mat, i, 0, m, n, pq);

            i--;
        }

        int j = 1;
        while (j < n) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

            diagonalSortUtil(mat, 0, j, m, n, pq);

            j++;
        }

        return mat;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {3,3,1,1},
                {2,2,1,2},
                {1,1,1,2},
        };

        int[][] res = diagonalSort(mat);

        for (int[] arr: res) {
            for (int num: arr) {
                System.out.print(num + ", ");
            }
            System.out.println();
        }
    }
}

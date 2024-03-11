package com.example.javaalgo.Arrays;

import java.util.*;

// You are given an array of CPU tasks, each represented by letters A to Z, and a cooling time, n.
// Each cycle or interval allows the completion of one task.
// Tasks can be completed in any order, but there's a constraint: identical tasks must be separated by at least n intervals due to cooling time.
// Return the minimum number of intervals required to complete all tasks.
public class TaskScheduler {
    static class Pair {
        Integer freq;
        Integer nextInterval;

        Pair(Integer freq, Integer nextInterval) {
            this.freq = freq;
            this.nextInterval = nextInterval;
        }
    }

    static class PairComparator implements Comparator<Pair> {

        @Override
        public int compare(Pair p1, Pair p2) {
            if (p1.nextInterval > p2.nextInterval) {
                return 1;
            } else if (p1.nextInterval < p2.nextInterval) {
                return -1;
            } else {
                if (p1.freq < p2.freq) {
                    return 1;
                } else if (p1.freq > p2.freq) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }

    public static int leastInterval(char[] tasks, int n) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());
        int[] freq = new int[26];
        for (char c: tasks) {
            freq[c - 'A'] += 1;
        }

        for (int count: freq) {
            if (count != 0) {
                pq.add(new Pair(count, 1));
            }
        }

        int t = 1;
        int result = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            if (curr.nextInterval > t) {
                result += curr.nextInterval - t + 1;
                t = curr.nextInterval + 1;
            } else {
                result++;
                t++;
            }

            if (curr.freq > 1) {
                curr.freq -= 1;
                curr.nextInterval += n + 1;
                pq.add(curr);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        char[] input = new char[]{'A','A','A','B','B','B'};
        // char[] input = new char[]{'A','C','A','B','D','B'};
        // char[] input = new char[]{'A'};
        System.out.println("Time taken is " + leastInterval(input, 3));
    }
}

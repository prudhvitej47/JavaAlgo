package com.example.javaalgo.Arrays;

import java.util.*;

public class TopKFrequent {

    public static class Pair {
        int val;
        int freq;

        Pair(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num: nums) {
            freqMap.merge(num, 1, (oldVal, newVal) -> oldVal + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(k, Comparator.comparing(p -> p.freq));
        for (Map.Entry<Integer, Integer> e: freqMap.entrySet()) {
            if (pq.isEmpty() || pq.size() < k) {
                pq.add(new Pair(e.getKey(), e.getValue()));
            } else {
                Integer lowestFreq = pq.peek().freq;
                if (e.getValue() > lowestFreq) {
                    pq.poll();
                    pq.add(new Pair(e.getKey(), e.getValue()));
                }
            }
        }

        int index = 0;
        while (!pq.isEmpty()) {
            result[index++] = pq.poll().val;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};

        // System.out.println("Top frequent: " + Arrays.toString(topKFrequent(nums, 2)));
        int oldCapacity = 2;
        System.out.println(oldCapacity >> 2);
    }
}

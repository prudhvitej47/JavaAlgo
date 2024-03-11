package com.example.javaalgo.Arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;

public class SlidingWindowMaximum {

    static class Pair {
        int val;
        int index;

        Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    /*public static int[] maxSlidingWindow(int[] nums, int k) {

        int[] ans = new int[nums.length - k + 1];
        int index = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.val - a.val);

        for (int i = 0; i < k - 1; i++) {
            pq.add(new Pair(nums[i], i));
        }

        for (int j = k - 1; j < nums.length; j++) {

            while (!pq.isEmpty() && pq.peek().index <= j - k) {
                pq.poll();
            }

            pq.add(new Pair(nums[j], j));

            ans[index++] = pq.peek().val;
        }

        return ans;
    }*/

    public static int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Pair> dll = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];
        int index = 0;

        for (int i = 0; i < k - 1; i++) {
            if (dll.isEmpty()) {
                dll.add(new Pair(nums[i], i));
            } else {
                while (!dll.isEmpty() && dll.peekLast().val <= nums[i]) {
                    dll.pollLast();
                }

                dll.add(new Pair(nums[i], i));
            }
        }

        for (int j = k - 1; j < nums.length; j++) {

            while (!dll.isEmpty() && dll.peekFirst().index <= j - k) {
                dll.pollFirst();
            }

            while (!dll.isEmpty() && dll.peekLast().val <= nums[j]) {
                dll.pollLast();
            }

            dll.add(new Pair(nums[j], j));

            ans[index++] = dll.peekFirst().val;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, -1}, 1)));

        Random r = new Random();
        System.out.println(r.nextDouble());
    }
}

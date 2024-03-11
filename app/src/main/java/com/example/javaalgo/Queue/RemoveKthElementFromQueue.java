package com.example.javaalgo.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class RemoveKthElementFromQueue {

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(10);
        queue.add(12);
        queue.add(17);
        queue.add(29);
        queue.add(36);
        queue.add(55);
        queue.add(101);
        queue.add(121);

        // remove 5th element. Result - 1, 10, 12, 17, 36, 55

        // 1, 10, 12, 17, 36, 55
        // index = 6

        removeKthElementFromFrontOfQueue(queue, 3);

        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + ", ");
        }
        System.out.println();
    }

    static void removeKthElementFromFrontOfQueue(Queue<Integer> queue, int k) {
        int elementIndex = k - 1;
        int index = 0;
        int total = queue.size();

        while (index < total) {
            Integer firstEle = queue.remove();
            if (index != elementIndex) {
                queue.add(firstEle);
            }
            index++;
        }
    }
}

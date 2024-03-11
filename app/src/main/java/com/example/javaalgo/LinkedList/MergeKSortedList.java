package com.example.javaalgo.LinkedList;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(ln -> ln.val));
        ListNode[] heads = new ListNode[lists.length];

        for (int k = 0; k < lists.length; k++) {
            if (lists[k] != null) {
                heads[k] = lists[k];
            }
        }

        while (true) {
            boolean allFinished = true;
            for (int k = 0; k < heads.length; k++) {
                if (heads[k] != null) {
                    ListNode temp = heads[k];
                    pq.add(temp);
                    heads[k] = temp.next;
                    allFinished = false;
                }
            }
            if (allFinished)
                break;
        }

        ListNode head = null;
        ListNode prev = null;
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            if (head == null) {
                head = curr;
                prev = curr;
            } else {
                prev.next = curr;
                prev = curr;
                prev.next = null;
            }
        }
        return head;
    }

    static ListNode createListNode(List<Integer> inputList) {
        ListNode head = null;
        ListNode prev = null;

        for (Integer num: inputList) {
            ListNode curr = new  ListNode(num);
            if (head == null) {
                head = curr;
                prev = curr;
            } else {
                prev.next = curr;
                prev = curr;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        List<Integer> l1 = List.of(1, 4, 5, 6, 7);
        List<Integer> l2 = List.of(1, 3, 4, 8);
        List<Integer> l3 = List.of(2, 6);

        ListNode[] listNodes = new ListNode[]{
                createListNode(l1),
                createListNode(l2),
                createListNode(l3)
        };

        ListNode newHead = mergeKLists(listNodes);

        ListNode temp = newHead;
        while (temp != null) {
            System.out.print(temp.val + ",");
            temp = temp.next;
        }
        System.out.println();
    }
}

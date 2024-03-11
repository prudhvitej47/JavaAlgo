package com.example.javaalgo.LinkedList;

import java.util.List;

// Given the head of a linked list, remove the nth node from the end of the list and return its head.
// Do it in one pass
public class RemoveKthNodeFromEnd {

    static class ListNode {
       int val;
       ListNode next;
       ListNode(int val) { this.val = val; }
   }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prevFirst = head;
        ListNode first = head;
        ListNode last = head;
        int i = 1;

        while (last.next != null) {
            if (i < n) {
                last = last.next;
            } else {
                prevFirst = first;
                first = first.next;
                last = last.next;
            }
            i++;
        }

        if (i == n) {
            return head.next;
        } else {
            prevFirst.next = first.next;
            return head;
        }
    }

    public static void main(String[] args) {
        List<Integer> numList = List.of(1, 2, 3, 4, 5);
        ListNode head = null;
        ListNode prev = null;

        for (Integer num: numList) {
            ListNode curr = new ListNode(num);
            if (head == null) {
                head = curr;
                prev = curr;
            } else {
                prev.next = curr;
                prev = curr;
            }
        }

        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + ",");
            temp = temp.next;
        }
        System.out.println("\nAfter removing head:");

        ListNode newHead = removeNthFromEnd(head, 5);

        temp = newHead;
        while (temp != null) {
            System.out.print(temp.val + ",");
            temp = temp.next;
        }
    }

    
}

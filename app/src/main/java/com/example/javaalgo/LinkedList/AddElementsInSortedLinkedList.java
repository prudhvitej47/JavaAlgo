package com.example.javaalgo.LinkedList;

public class AddElementsInSortedLinkedList {

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(10);
        head = addNodeSortedList(head, 11);
        head = addNodeSortedList(head, 4);
        head = addNodeSortedList(head, 22);
        head = addNodeSortedList(head, 15);
        head = addNodeSortedList(head, 1);

        System.out.println(head.value);
        System.out.println(head.next.value);
        System.out.println(head.next.next.value);
        System.out.println(head.next.next.next.value);
        System.out.println(head.next.next.next.next.value);
        System.out.println(head.next.next.next.next.next.value);
    }

    static class LinkedListNode {
        int value;
        LinkedListNode next;

        LinkedListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    static LinkedListNode addNode(LinkedListNode head, int newEle) {
        LinkedListNode newNode = new LinkedListNode(newEle);

        if (head == null) {
            head = newNode;
            return head;
        }

        LinkedListNode current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        return head;
    }

    static LinkedListNode addNodeSortedList(LinkedListNode head, int newEle) {
        LinkedListNode newNode = new LinkedListNode(newEle);

        if (head == null || head.value > newEle) {
            newNode.next = head;
            return newNode;
        }

        LinkedListNode current = head;
        while (current.next != null && current.next.value < newEle) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
        return head;
    }
}

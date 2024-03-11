package com.example.javaalgo.LinkedList;

public class SortLinkedListWithZerosAndOnes {

    public static void main(String[] args) {
        AddElementsInSortedLinkedList.LinkedListNode head = addNode(null, 1);
        head = addNode(head, 1);
        head = addNode(head, 0);
        head = addNode(head, 0);
        head = addNode(head, 0);
        head = addNode(head, 1);

        sortLinkedList(head);

        AddElementsInSortedLinkedList.LinkedListNode current = head;
        while (current != null) {
            System.out.print(current.value + ", ");
            current = current.next;
        }
        System.out.println();

        // java pass by value
        System.out.println("Head value is " + head.value);
    }

    static AddElementsInSortedLinkedList.LinkedListNode addNode(AddElementsInSortedLinkedList.LinkedListNode head, int newEle) {
        AddElementsInSortedLinkedList.LinkedListNode newNode = new AddElementsInSortedLinkedList.LinkedListNode(newEle);

        if (head == null) {
            head = newNode;
            return head;
        }

        AddElementsInSortedLinkedList.LinkedListNode current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        return head;
    }

    static void sortLinkedList(AddElementsInSortedLinkedList.LinkedListNode head) {
        var p = findNextWithVal(head, 1);  // before p everything is 0
        if (p == null) {
            return;
        }

        var q = findNextWithVal(p.next, 0);

        while (p != null && q != null) {
            p.value = 0;
            q.value = 1;

            p = findNextWithVal(p, 1);
            q = findNextWithVal(q, 0);
        }

    }

    static AddElementsInSortedLinkedList.LinkedListNode findNextWithVal(AddElementsInSortedLinkedList.LinkedListNode node, int val) {
        while (node != null && node.value != val) {
            node = node.next;
        }

        return node;
    }
}

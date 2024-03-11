package com.example.javaalgo.LinkedList;

import java.util.HashMap;

public class DeepCopyWithRandomPointer {

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        if (head == null)
            return null;

        HashMap<Node, Node> mp = new HashMap<>();
        Node newHead = new Node(head.val);
        Node prev = newHead;
        Node temp = head.next;

        mp.put(head, newHead);

        while (temp != null) {
            Node newNode = new Node(temp.val);
            mp.put(temp, newNode);

            prev.next = newNode;
            prev = newNode;

            temp = temp.next;
        }

        Node oldNode = head;
        Node newNode = newHead;

        while (oldNode != null) {
            if (oldNode.random != null) {
                newNode.random = mp.get(oldNode.random);
            }
            oldNode = oldNode.next;
            newNode = newNode.next;
        }

        return newHead;
    }

    public static void main(String[] args) {
        Node head = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);

        head.next = node1;

        node1.next = node2;
        node1.random = head;

        node2.next = node3;
        node2.random = node4;

        node3.next = node4;
        node3.random = node2;

        node4.random = head;


        Node temp = copyRandomList(head);

        System.out.print("[");
        while (temp != null) {
            System.out.print("[" + temp.val + "," + (temp.random == null ? "null" : temp.random.val) + "],");

            temp = temp.next;
        }
        System.out.println("]");
    }
}

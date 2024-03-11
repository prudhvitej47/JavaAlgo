package com.example.javaalgo.LinkedList;

public class BSTToDLL {

    public static class Node
    {
        Node left, right;
        int data;

        Node(int d)
        {
            data = d;
            left = right = null;
        }

    }

    public static class Pair {
        Node head;
        Node tail;

        Pair(Node head, Node tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    public static Pair bToDLLUtil(Node root) {
        Node finalHead = root;
        Node finalTail = root;

        if (root.left != null) {
            Pair leftPair = bToDLLUtil(root.left);

            leftPair.tail.right = root;
            root.left = leftPair.tail;

            finalHead = leftPair.head;
        }

        if (root.right != null) {
            Pair rightPair = bToDLLUtil(root.right);

            root.right = rightPair.head;
            rightPair.head.left = root;

            finalTail = rightPair.tail;
        }

        return new Pair(finalHead, finalTail);
    }

    public static Node bToDLL(Node root) {
        Pair finalPair = bToDLLUtil(root);

        return finalPair.head;
    }

    public static void main(String[] args) {
        /*Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);*/

        Node root = new Node(4);
        root.left = new Node(4);
        root.right = new Node(10);
        root.left.left = new Node(5);
        root.left.right = new Node(10);
        root.right.left = new Node(7);
        root.right.right = new Node(2);
        root.left.left.right = new Node(3);
        root.left.right.left = new Node(8);

        Node result = bToDLL(root);

        Node temp = result;
        System.out.println("Printing nodes from left:");
        while (temp.right != null) {
            System.out.print(temp.data + "->");
            temp = temp.right;
        }
        System.out.println(temp.data);

        System.out.println("Printing nodes from right:");
        while (temp.left != null) {
            System.out.print(temp.data + "->");
            temp = temp.left;
        }
        System.out.println(temp.data);
    }
}

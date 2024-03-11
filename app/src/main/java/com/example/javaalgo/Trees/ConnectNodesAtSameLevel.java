package com.example.javaalgo.Trees;

import java.util.LinkedList;
import java.util.Queue;

// Given a Binary Tree, The task is to connect all the adjacent nodes at the same level starting from the left-most node of that level,
// and ending at the right-most node using nextRight pointer by setting these pointers to point the next right for each node.
public class ConnectNodesAtSameLevel {

    public static int level = 0;
    public static Node prev = null;

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static class Pair {
        Node node;
        int level;

        Pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public static Node connect(Node root) {
        if (root == null)
            return null;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 1));

        while (!q.isEmpty()) {
            Pair top = q.poll();
            Node currentNode = top.node;
            int currentLevel = top.level;

            if (currentLevel != level) {
                level = currentLevel;
                prev = currentNode;
            } else {
                prev.next = currentNode;
                prev = currentNode;
            }

            if (currentNode.left != null) {
                q.add(new Pair(currentNode.left, currentLevel + 1));
            }

            if (currentNode.right != null) {
                q.add(new Pair(currentNode.right, currentLevel + 1));
            }
        }

        return root;
    }

    public static Node connectRecur(Node root) {
        if (root == null)
            return null;

        if (root.left != null) {
            root.left.next = root.right;
        }

        if (root.right != null && root.next != null) {
            root.right.next = root.next.left != null ? root.next.left : root.next.right;
        }

        connectRecur(root.left);
        connectRecur(root.right);

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Node finalRoot = connect(root);
        Node finalRoot = connectRecur(root);

        System.out.println(finalRoot);

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
    }


}

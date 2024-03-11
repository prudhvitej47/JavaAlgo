package com.example.javaalgo.Graphs;

import java.util.*;

public class CloneUndirectedGraph {

    public static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static Node cloneGraph(Node node) {
        if (node == null)
            return null;

        Map<Integer, Node> mp = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        Node newRoot = new Node(node.val);
        mp.put(node.val, newRoot);

        while (!q.isEmpty()) {

            Node oldNode = q.poll();
            Node newNode = mp.get(oldNode.val);

            for (Node oldNeighbor: oldNode.neighbors) {
                Node newNeighbor;
                if (mp.containsKey(oldNeighbor.val)) {
                    newNeighbor = mp.get(oldNeighbor.val);
                } else {
                    newNeighbor = new Node(oldNeighbor.val);
                    mp.put(oldNeighbor.val, newNeighbor);
                    q.add(oldNeighbor);
                }
                newNode.neighbors.add(newNeighbor);
            }
        }

        return newRoot;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.addAll(List.of(node2, node4));
        node2.neighbors.addAll(List.of(node1, node3));
        node3.neighbors.addAll(List.of(node2, node4));
        node4.neighbors.addAll(List.of(node1, node3));

        Node newNode1 = cloneGraph(node1);

        boolean[] visited = new boolean[5];
        Queue<Node> q = new LinkedList<>();
        visited[newNode1.val] = true;
        q.add(newNode1);

        while (!q.isEmpty()) {
            Node top = q.poll();
            StringBuilder sb = new StringBuilder();

            for (Node neighbor: top.neighbors) {
                sb.append(neighbor.val).append(",");
                if (!visited[neighbor.val]) {
                    q.add(neighbor);
                    visited[neighbor.val] = true;
                }
            }

            System.out.println("Parent: " + top.val + " Neighbors: " + sb);
        }

    }
}

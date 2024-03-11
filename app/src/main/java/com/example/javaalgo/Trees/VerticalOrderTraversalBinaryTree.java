package com.example.javaalgo.Trees;

import java.util.*;

public class VerticalOrderTraversalBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static class Node {
        TreeNode treeNode;
        int vLevel;
        int hLevel;

        Node(TreeNode treeNode, int vLevel, int hLevel) {
            this.treeNode = treeNode;
            this.vLevel = vLevel;
            this.hLevel = hLevel;
        }
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Node>> res = new HashMap<>();
        int minLevel = 0;
        int maxLevel = 0;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root, 0, 0));

        while (!q.isEmpty()) {
            Node top = q.poll();
            int vLevel = top.vLevel;
            int hLevel = top.hLevel;

            minLevel = Math.min(minLevel, vLevel);
            maxLevel = Math.max(maxLevel, vLevel);
            if (!res.containsKey(vLevel))
                res.put(vLevel, new ArrayList<>());

            System.out.println("At node: " + top.treeNode.val + " with vLevel " + vLevel + " and hLevel " + hLevel);

            List<Node> verticalLevelList = res.get(vLevel);
            Node lastInsertedNode = !verticalLevelList.isEmpty() ? verticalLevelList.get(verticalLevelList.size() - 1) : null;
            if (lastInsertedNode != null && lastInsertedNode.vLevel == vLevel && lastInsertedNode.hLevel == hLevel && lastInsertedNode.treeNode.val > top.treeNode.val) {
                verticalLevelList.remove(verticalLevelList.size() - 1);
                verticalLevelList.add(top);
                verticalLevelList.add(lastInsertedNode);
            } else {
                verticalLevelList.add(top);
            }

            if (top.treeNode.left != null) {
                q.add(new Node(top.treeNode.left, top.vLevel - 1, top.hLevel + 1));
            }

            if (top.treeNode.right != null) {
                q.add(new Node(top.treeNode.right, top.vLevel + 1, top.hLevel + 1));
            }
        }

        List<List<Integer>> finalResultList = new ArrayList<>();
        for (int j = minLevel; j <= maxLevel; j++) {
            finalResultList.add(res.get(j).stream().map(node -> node.treeNode.val).toList());
        }

        return finalResultList;
    }

    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(11);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.left.left.right = new TreeNode(9);
        root.right.right.left = new TreeNode(6);
        root.left.left.right.right = new TreeNode(10);
        root.right.right.left.left = new TreeNode(1);*/

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(3);
        root.left.right.right.right = new TreeNode(4);
        root.left.right.right.right.right = new TreeNode(5);

        List<List<Integer>> result = verticalTraversal(root);
        for (int i = 1; i <= result.size(); i++) {
            System.out.println("For level " + i + " : " + result.get(i - 1));
        }
    }
}

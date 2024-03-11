package com.example.javaalgo.Trees;

public class DiameterBinaryTree {

    public static int maxVal = 1;

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

    public static int diameterOfBinaryTreeUtil(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftCount = diameterOfBinaryTreeUtil(root.left);
        int rightCount = diameterOfBinaryTreeUtil(root.right);

        maxVal = Math.max(maxVal, 1 + leftCount + rightCount);

        System.out.println("For node: " + root.val + " returning count: " + (1 + Math.max(leftCount, rightCount)));

        return 1 + Math.max(leftCount, rightCount);
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        diameterOfBinaryTreeUtil(root);
        return maxVal - 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(7);

        System.out.println("Diameter of tree is " + diameterOfBinaryTree(root));
    }
}

package com.example.javaalgo.Trees;

public class LCABinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public static class Pair {
        Integer count;
        TreeNode node;

        Pair(Integer count, TreeNode node) {
            this.count = count;
            this.node = node;
        }
    }

    public static Pair lowestCommonAncestorUtil(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return new Pair(0, null);
        
        int current = 0;
        if (root.val == p.val || root.val == q.val) {
            current = 1;
        }
        
        Pair leftPair = lowestCommonAncestorUtil(root.left, p, q);
        if (leftPair.node != null || leftPair.count == 2)
            return leftPair;
        
        Pair rightPair = lowestCommonAncestorUtil(root.right, p, q);
        if (rightPair.node != null || rightPair.count == 2)
            return rightPair;
        
        int finalCount = leftPair.count + current + rightPair.count;
        if (finalCount == 2) {
            return new Pair(finalCount, root);
        }
        return new Pair(finalCount, null);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Pair pair = lowestCommonAncestorUtil(root, p, q);
        return pair.node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        // 4, 8
        TreeNode x = lowestCommonAncestor(root, root.left.right, root.right);
        System.out.println(x != null ? x.val : null);

        // 0, 5
        TreeNode y = lowestCommonAncestor(root, root.left.left, root.left.right.right);
        System.out.println(y != null ? y.val : null);

        // 2, 5
        TreeNode z = lowestCommonAncestor(root, root.left, root.left.right.right);
        System.out.println(z != null ? z.val : null);
    }
}

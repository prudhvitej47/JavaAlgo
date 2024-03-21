package com.example.javaalgo.BST;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /*public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pChild = new ArrayList<>();
        List<TreeNode> qChild = new ArrayList<>();

        TreeNode current = root;
        while (current != null) {
            pChild.add(current);
            if (current.val == p.val) {
                break;
            } else if (current.val < p.val) {
                current = current.right;
            } else {
                current = current.left;
            }
        }

        if (current == null) {
            return null;
        }

        current = root;
        while (current != null) {
            qChild.add(current);
            if (current.val == q.val) {
                break;
            } else if (current.val < q.val) {
                current = current.right;
            } else {
                current = current.left;
            }
        }

        if (current == null) {
            return null;
        }

        int i = 0, j = 0;
        TreeNode temp = null;
        while (i < pChild.size() && j < qChild.size()) {
            if (pChild.get(i).val == qChild.get(j).val) {
                temp = pChild.get(i);
                i++;
                j++;
            } else if (pChild.get(i).val < qChild.get(j).val) {
                i++;
            } else {
                j++;
            }
        }

        return temp;
    }*/

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        return root;
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

        TreeNode x = lowestCommonAncestor(root, root.left, root.left.right.right);
        System.out.println(x != null ? x.val : null);
    }
}

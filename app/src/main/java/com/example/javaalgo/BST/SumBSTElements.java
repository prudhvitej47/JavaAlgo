package com.example.javaalgo.BST;

public class SumBSTElements {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        addElement(root, 5);
        addElement(root, 8);
        addElement(root, 12);
        addElement(root, 4);
        addElement(root, 15);
        addElement(root, 11);

        System.out.println(root.right.left.value);
        System.out.println(sumElements(root));
    }

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    static void addElement(TreeNode root, int newEle) {
        if (root.value > newEle) {
            if (root.left == null) {
                root.left = new TreeNode(newEle);
            } else {
                addElement(root.left, newEle);
            }
        } else if (root.value < newEle) {
            if (root.right == null) {
                root.right = new TreeNode(newEle);
            } else {
                addElement(root.right, newEle);
            }
        }
    }

    static int sumElements(TreeNode root) {
        if (root == null)
            return 0;

        return root.value + sumElements(root.left) + sumElements(root.right);
    }
}

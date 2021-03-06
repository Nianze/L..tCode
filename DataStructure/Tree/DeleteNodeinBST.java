// Created by Rym on 2016.12.8

public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                root.val = findMinV(root.right);
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }
    private int findMinV(TreeNode root) {
        while (root.left != null) root = root.left;
        return root.val;
    }
}

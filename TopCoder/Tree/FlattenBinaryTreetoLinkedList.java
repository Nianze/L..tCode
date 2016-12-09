// Created by Rym on 2016.12.7
public class Solution {
    public void flatten(TreeNode root) {
        helper(root, null);
    }
    // helper: attach tail to the right child of root's right-most node.
    private TreeNode helper(TreeNode root, TreeNode tail) {
        if (root == null) return tail;
        root.right = helper(root.left, helper(root.right, tail));
        root.left = null;
        return root;
    }
}

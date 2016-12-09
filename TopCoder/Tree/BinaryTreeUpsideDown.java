// Created by Rym on 2016.12.8

public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        return helper(root, null, null);
    }
    // top down
    private TreeNode helper(TreeNode root, TreeNode par, TreeNode parR) {
        if (root == null) return par;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = par;
        root.left = parR;
        return helper(left, root, right);
    }
}

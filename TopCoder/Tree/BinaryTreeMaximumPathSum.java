// Created by Rym on 2016.12.6
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeMaximumPathSum {
    static int maxValue;
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxFromRoot(root);
        return maxValue;
    }
    private int maxFromRoot(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, maxFromRoot(root.left));
        int right = Math.max(0, maxFromRoot(root.right));
        int rootPath = left + root.val + right;
        maxValue = Math.max(maxValue, rootPath);
        return Math.max(left, right) + root.val;
    }
}

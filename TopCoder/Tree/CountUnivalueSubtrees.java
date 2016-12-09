// Created by Rym on 2016.12.7
public class Solution {
    static int count;
    public int countUnivalSubtrees(TreeNode root) {
        count = 0;
        helper(root);
        return count;
    }
    private long helper(TreeNode root) {
        if (root == null) return Long.MAX_VALUE;
        long left = helper(root.left), right = helper(root.right);
        if (root.val == left && root.val == right ||
            left == Long.MAX_VALUE && root.val == right ||
            right == Long.MAX_VALUE && root.val == left ||
            left == Long.MAX_VALUE && right == Long.MAX_VALUE) {
            count++;
            return root.val;
        }
        return Long.MIN_VALUE;
    }
}

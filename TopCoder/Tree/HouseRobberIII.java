// Created by Rym on 2016.12.7

public class Solution {
    // first thought: layer lever traversal
    // but cannot deal with [2,1,3,null,4], which res = 7.
    public int rob(TreeNode root) {
        int[] dp = dfs(root);
        return Math.max(dp[0], dp[1]);
    }
    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0,0};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] dp = new int[2];
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = root.val + left[0] + right[0];
        return dp;
    }
}

// Created by Rym on 2016.12.8
public class Solution {
    static int max;
    // intuitive dfs
    // just keep track of target value and so far path length
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        max = 0;
        helper(root, 0, root.val);
        return max;
    }
    private void helper(TreeNode root, int sofar, int target) {
        if (root == null) return ;
        if (root.val == target) sofar++;
        else sofar = 1;
        max = Math.max(sofar, max);
        helper(root.left, sofar, root.val + 1);
        helper(root.right, sofar, root.val + 1);
    }
}

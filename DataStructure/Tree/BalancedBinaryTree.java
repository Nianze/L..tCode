// Creatd by Rym on 2016.12.6
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    // clever trick with "-1"
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }
    
    private int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        if (left == -1) return -1;
        int right = depth(root.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) >= 2) return -1;
        return Math.max(left,right) + 1;
    }
}

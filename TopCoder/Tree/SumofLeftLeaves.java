// Created by Rym on 2016.12.8
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        return helper(root.left) + sumOfLeftLeaves(root.right);
    }
    // essentially helper is the same as sumOfLeftLeaves, only ignore right leaves
    private int helper(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        return helper(root.left) + sumOfLeftLeaves(root.right);
    }
    // check each left node and right node to find left leaves
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> s = new ArrayDeque<>();
        s.push(root);
        int res = 0;
        while (!s.isEmpty()) {
            TreeNode t = s.pop();
            if (t.left != null) {
                if (t.left.left == null && t.left.right == null) res += t.left.val;
                else s.push(t.left);
            }
            if (t.right != null) {
                if (t.right.left != null || t.right.right != null) s.push(t.right);
            }
        }
        return res;
    }
}

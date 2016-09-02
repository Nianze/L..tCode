public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer, the depth of the tree.
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Divide
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        // Conquer
        return Math.max(left, right) + 1;
    }
}

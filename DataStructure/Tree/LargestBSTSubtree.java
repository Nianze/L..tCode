// Created by Rym on 2016.12.9
public class Solution {
    int max = 0;
    public int largestBSTSubtree(TreeNode root) {
        helper(root);
        return max;
    }
    // res:[num of bst nodes, left bound, right bound]
    private int[] helper(TreeNode root) {
        int[] res = new int[3];
        if (root == null) return res;
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        if (left[0] == -1 || right[0] == -1 || 
            left[0] > 0 && left[2] >= root.val || 
            right[0] > 0 && right[1] <= root.val) {
            res[0] = -1;
            return res;
        }
        res[0] = 1 + left[0] + right[0]; 
        res[1] = left[0] == 0 ? root.val : left[1]; 
        res[2] = right[0] == 0 ? root.val : right[2];
        max = Math.max(res[0], max);
        return res;
    }
}

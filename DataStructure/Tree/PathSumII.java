// Created by Rym on 2016.12.8

// First thought: rec bottom up solution.
// but need to return root to leaf path, rather than leaf to root path
// so create a helper func to do top down solution
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, sum, new ArrayList<Integer>(), res);
        return res;
    }
    private void helper(TreeNode root, int sum, List<Integer> builder, List<List<Integer>> res){
        if (root == null) { return; }
        builder.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) { 
            res.add(new ArrayList<Integer>(builder));
        } else {
            helper(root.left, sum - root.val, builder, res);
            helper(root.right, sum - root.val, builder, res);
        }
        builder.remove(builder.size()-1);
    }
}

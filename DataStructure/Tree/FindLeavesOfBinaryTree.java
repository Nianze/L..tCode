// Created by Rym on 2016.12.9
// essentially a follow up to the bt height
public class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        height(root, res);
        return res;
    }
    private int height(TreeNode root, List<List<Integer>> res) {
        if (root == null) return -1;
        int h = 1 + Math.max(height(root.left, res), height(root.right, res));
        if (res.size() < h + 1) res.add(new ArrayList<Integer>());
        res.get(h).add(root.val);
        return h;
    }
}

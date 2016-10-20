// Created by Rym on 10/20/2016
public class FindLeaves {
    // each level is stored in each list<Integer>
    // index of list<Integer> is the height of the tree
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }
    private int helper(TreeNode node, List<List<Integer>> ans) {
        if (node == null) {return -1;}
        int height = 1 + Math.max(helper(node.left, ans), helper(node.right, ans));
        if (ans.size() < height + 1) {
            ans.add(new ArrayList<Integer>());
        }
        ans.get(height).add(node.val);
        return heigth;
    }
}

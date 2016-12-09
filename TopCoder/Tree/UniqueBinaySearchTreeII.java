// Created by Rym on 2016.12.7
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<TreeNode>();
        return generateSubtree(1, n);
    }
    private List<TreeNode> generateSubtree(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null); // empty child
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generateSubtree(start, i-1);
            List<TreeNode> right = generateSubtree(i+1, end);
            for (TreeNode l : left) 
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
        }
        return res;
    }
}

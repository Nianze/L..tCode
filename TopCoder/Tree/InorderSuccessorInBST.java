// Created by Rym on 2016.12.8

public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode suc = null, cur = root;
        while (cur != null) {
            if (p.val >= cur.val) cur = cur.right;
            else if (p.val < cur.val){
                suc = cur;
                cur = cur.left;
            }
        }
        return suc;
    }
}

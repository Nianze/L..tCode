// Created by Rym on 2016.12.7

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length-1, preorder, inorder);
    }
    private TreeNode helper(int root, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (root >= preorder.length || inStart > inEnd) return null;
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[root]) {
                inIndex = i;
                break;
            }
        }
        TreeNode r = new TreeNode(preorder[root]);
        r.left = helper(root+1, inStart, inIndex-1, preorder, inorder);
        r.right = helper(root + inIndex-inStart + 1, inIndex+1, inEnd, preorder, inorder);
        return r;
    }
}

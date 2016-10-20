// Created by Rym on 10/18/2016
public class ValidateBST {
    // iterative inorder DFS
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        long iterator = (long) Integer.MIN_VALUE - 1;
        while (!s.isEmpty() || cur != null) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            TreeNode temp = s.pop();
            if (temp.val <= iterator) {
                return false;
            } else {
                iterator = (long) temp.val;
            }
            cur = temp.right;
        }
        return true;
    }
    // recursive
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    private boolean helper(TreeNode root, long max, long min) {
        if (root == null) {return true;}
        return helper(root.left, root.val, min) && 
            helper(root.right, max, root.val) &&
            root.val < max &&
            root.val > min;
    }    
}

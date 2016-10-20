// Creted by Rym on 10/19/2016

public class FlattenBinaryTree {
    // iterative
    public void flatten(TreeNode root) {
        if (root == null) {return;}
        TreeNode curr = root;
        while (curr != null) {
            TreeNode left = curr.left;
            TreeNode right = curr.right;
            curr.left = null;
            if (left != null) {
                curr.right = left;
                while (left.right != null) {
                    left = left.right;
                }
                left.right =right;
            }
            curr = curr.right;
        }
    }
    // recursice: reverse pre-order 
    public void flatten(TreeNode root) {
        helper(root, null);
    }
    private TreeNode helper(TreeNode root, TreeNode pre) {
        if (root == null) {return pre;}
        pre = helper(root.right, pre);
        pre = helper(root.left, pre);
        root.right = pre;
        root.left = null;
        return root;
    }
    // naive rec
    public void flatten(TreeNode root) {
        if (root == null) {return null;}
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        flatten(left);
        flatten(right);
        root.right = left;
        TreeNode curr = root;
        while (cur.right != null) {curr = curr.right;}
        cur.right = right;
    }
}

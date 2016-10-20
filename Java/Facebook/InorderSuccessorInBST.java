// Created by Rym on 10/18/2016
public class InorderSuccessorInBST {
    // iterative
    // O(h), h is the hight of successor. In balanced BST, h = log(n), worst case h = n
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode suc = null;
        while (root != null) {
            if (p.val < root.val) {
                suc = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return suc;
    }
    // recursive
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (p.val < root.val) {
            TreeNode left = inorderSuccessor(root.left, p);
            return left != null ? left : root;
        } else {
            return inorderSuccessor(root.right, p);
        }
    }
}

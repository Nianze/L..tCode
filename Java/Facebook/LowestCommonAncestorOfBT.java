// Created by Rym on 10/20/2016
public class LCAofBT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    // for case that the parent pointer is given on every node
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        Deque<TreeNode> s1 = new ArrayDeque<>();
        Deque<TreeNode> s2 = new ArrayDeque<>();
        while (p != null) {
            s1.push(p);
            p = p.parent;
        }
        while (q != null) {
            s2.push(q);
            q = q.parent;
        }
        TreeNode ans;
        while (s1.peek() == s2.peek()) {
            ans = s1.pop();
            s2.pop();
        }
        return ans;
    }
}

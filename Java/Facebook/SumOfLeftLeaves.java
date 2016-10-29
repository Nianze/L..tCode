// Created by Rym on 10/26/2016

public class SumOfLeftLeaves {
    // DFS iterative
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> s = new Stack<>();
        int ans = 0;
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode cur = s.pop();
            if (cur.left != null){
                if (cur.left.left == null &&
                    cur.left.right == null) {
                    ans += cur.left.val; // add if left child is leaf
                } else {
                    s.push(cur.left); // push stack if l-child not leaf
                }
            }
            if (cur.right != null){
                if (cur.right.left != null ||
                    cur.right.right != null) { // ignore right child if is leaf
                    s.push(cur.right);
                }
            }
        }
        return ans;
    }
    // DFS rec
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) { // l-child is leaf
                ans += root.left.val;
            } else {
                ans += sumOfLeftLeaves(root.left);
            }
        }
        if (root.right != null) {
            ans += sumOfLeftLeaves(root.right);
        }
        return ans;
    }
    // BFS
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur.left != null) {
                if (cur.left.left == null && cur.left.right == null) {
                    ans += cur.left.val;
                } else {
                    q.offer(cur.left);
                }
            }
            if (cur.right != null) {
                q.offer(cur.right);
            }
        }
        return ans;
    }
}

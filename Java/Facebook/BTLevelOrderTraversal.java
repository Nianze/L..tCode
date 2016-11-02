// Created by Rym on 11/1/2016

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BTLevelOrderTraversal {
    // use BFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while (size-- > 0) {
                TreeNode curr = queue.poll();
                level.add(curr.val);
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            ans.add(level);
        }
        return ans;
    }

    // Use DFS, recursive
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, root, 0);
        return ans;
    }
    private void dfs(List<List<Integer>> ans, TreeNode root, int height) {
        if (root == null) return;
        if (height >= ans.size()) {
            ans.add(new ArrayList<Integer>());
        }
        ans.get(height).add(root.val);
        dfs (ans, root.left, height + 1);
        dfs (ans, root.right, height + 1);
    }
}

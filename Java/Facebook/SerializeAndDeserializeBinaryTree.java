// Created by Rym on 11/06/2016

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        build(sb, root);
        return sb.toString();
    }
    // inorder recursive dfs
    private void build(StringBuilder sb, TreeNode root) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val).append(",");
        build(sb, root.left);
        build(sb, root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return recover(nodes);
    }
    
    private TreeNode recover(Deque<String> nodes) {
        String node = nodes.removeFirst();
        if (node.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(node));
        root.left = recover(nodes);
        root.right = recover(nodes);
        return root;
    }

    // May also use BFS or iterative DFS to solve the problem
}

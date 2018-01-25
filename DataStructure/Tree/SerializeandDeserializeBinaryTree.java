// Created by Rym on 2016.12.6
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
        preorder(root, sb);
        return sb.toString();
    }
    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val).append(',');
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        Deque<String> q = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return decode(q);
    }
    // use queue to restore!!
    private TreeNode decode(Deque<String> q) {
        String node = q.removeFirst();
        if (node.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(node));
        root.left = decode(q);
        root.right = decode(q);
        return root;
    }
}

//Created by Rym on 2016.12.7

public class Solution {
    // reverse the pre-order traversal
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Deque<TreeNode> s = new ArrayDeque<>();
        while (!s.isEmpty() || root != null) {
            while (root != null) {
                res.addFirst(root.val); // reverse the preorder, add to first
                s.push(root);
                root = root.right; // reverse the preorder, go to right
            }
            root = s.pop();
            root = root.left != null ? root.left : null; // reverse the preorder, go to left
        }
        return res;
    }
}

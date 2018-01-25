// Created by Rym on 2016.12.8
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        int level = 0;
        while (!dq.isEmpty()) {
            Deque<TreeNode> buf = new ArrayDeque<>();
            List<Integer> temp = new ArrayList<>();
            while (!dq.isEmpty()) {
                TreeNode t = level%2 == 0 ? dq.removeFirst() : dq.removeLast();
                temp.add(t.val);
                if (level % 2 == 0) {
                    if (t.left != null) buf.addLast(t.left);
                    if (t.right != null) buf.addLast(t.right);
                } else {
                    if (t.right != null) buf.addFirst(t.right); 
                    if (t.left != null) buf.addFirst(t.left);
                }
            }
            res.add(temp);
            dq = buf;
            level++;
        }
        return res;
    }
}

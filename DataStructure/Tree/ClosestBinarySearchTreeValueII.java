// Created by Rym on 2016.12.9
public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<Integer> pre = new ArrayDeque<>();
        Deque<Integer> suc = new ArrayDeque<>();
        
        traversal(root, target, false, pre);
        traversal(root, target, true, suc);
        
        while (k-- > 0) {
            if (pre.isEmpty()) {
                res.add(suc.pop());
            } else if (suc.isEmpty()) {
                res.add(pre.pop());
            } else if (target - pre.peek() < suc.peek() - target) {
                res.add(pre.pop());
            } else {
                res.add(suc.pop());
            }
        }
        return res;
    }
    private void traversal(TreeNode root, double target, boolean reverse, Deque<Integer> s) {
        if (root == null) return;
        traversal(reverse ? root.right : root.left, target, reverse, s);
        // early termination. note the "equal" condition
        if (reverse && root.val <= target || !reverse && root.val > target) return;
        s.push(root.val);
        traversal(reverse ? root.left : root.right, target, reverse, s);
    }
}

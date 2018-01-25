// Created by Rym on 2016.12.8
// similar to inorder traversal
// use a stack to store left subtree
// maintain a lowBound value to ensure the node is in ascending sequence
public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Deque<Long> s = new ArrayDeque<>();
        long lowBound = Long.MIN_VALUE;
        s.push(lowBound);
        for (int node : preorder) {
            if (node < lowBound) return false;
            while (!s.isEmpty() && node > s.peek()) {lowBound = s.pop();}
            s.push((long)node);
        }
        return true;
    }
}

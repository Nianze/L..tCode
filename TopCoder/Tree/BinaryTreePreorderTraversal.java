// Created by Rym on 2016.12.7
public class Solution {
    // rec
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }
    private void preorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
    
    // iterative
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> s = new ArrayDeque<>();            
        while (!s.isEmpty() || root != null) {
            while (root != null) {
                res.add(cur.val);
                s.push(cur);
                cur = cur.left;
            } 
            root = s.pop();
            root = root.right != null ? root.right : null;// prevend popped node added to res again in next while loop
            }
        }
        return res;
    }
}

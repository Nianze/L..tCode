// Created by Rym on 10/18/2016
public class BinaryTreePaths {
    // recursive + iterative
    // Follow up: 如果node 里面value 类型不确定,怎么打印
    // Recursive
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) return list;
        if (root.left == null && root.right == null) {
            list.add(root.val + "");
            return list;
        }
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        for (int i = 0; i < left.size(); i++) {
            list.add(root.val + "->"+ left.get(i));
        }
        for (int j = 0; j < right.size(); j++) {
            list.add(root.val + "->"+ right.get(j));
        }
        return list;        
    }
    // DFS - stack
    public List<String> binaryTreePaths(TreeNode root) {
        
    }
    // BFS - queue
    public List<String> binaryTreePaths(TreeNode root) {
        
    }    
}

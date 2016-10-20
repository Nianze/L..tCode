// Created by Rym on 10/18/2016
public class BinaryTreePaths {
    // recursive + iterative
    // Follow up: 如果node 里面value 类型不确定,怎么打印
    // Recursive
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) return list;
        if (root.left == null && root.right == null) {
            list.add("" + root.val);
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
    // helper class
    class Wrapper {
        TreeNode node;
        String path;
        Wrapper(TreeNode node, String path) {
            this.node = node;
            this.path = path;
        }
    }
    // DFS - stack
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<String>();
        if (root == null) {return ans;}
        Stack<Wrapper> s = new Stack<Wrapper>();
        TreeNode cur = root;
        Wrapper parent = new Wrapper(new TreeNode(0), "");
        while (!s.isEmpty() || cur != null) {
            if (cur != null) {
                if (cur.left == null && cur.right == null) {
                    ans.add((parent.path + "->" + cur.val).substring(2));
                } else {
                    parent = new Wrapper(cur, parent.path + "->" + cur.val);
                    s.push(parent);
                }
                cur = cur.left;
            } else {
                parent = s.pop();
                cur = parent.node.right;
            }
        }
        return ans;
    }
    // BFS - queue
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        if (root == null) {return ret;}
        Queue<TreeNodeWrapper> que = new LinkedList<>();
        que.add(new TreeNodeWrapper(root, String.valueOf(root.val)));
        while (!que.isEmpty()) {
            TreeNodeWrapper nodeWrapper = que.poll();
            String path = nodeWrapper.path;
            TreeNode node = nodeWrapper.node;
            if (node.left != null) {
                TreeNodeWrapper leftWrapper = new TreeNodeWrapper(node.left, path + "->" + node.left.val);
                que.add(leftWrapper);
            }
            if (node.right != null) {
                TreeNodeWrapper leftWrapper = new TreeNodeWrapper(node.right, path + "->" + node.right.val);
                que.add(leftWrapper);
            }
            if (node.right == null && node.left == null) {
                ret.add(path);
            }
        }
        return ret;
    }    
}

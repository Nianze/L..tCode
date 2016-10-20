// Created by Rym on 10/18/2016
public class BinaryTreeVerticalOrderTraversal {
    // * BFS, put node,col into queue at the same time
    // * left child corresponds to col - 1, right child : col + 1
    // * map : key = col buckets, valude = list of nodes in same col
    // * get col boundary min and max on the fly
    // * retrieve result from map with col : [min, max]
    public list<list<Integer>> verticalOrder(TreeNode root) {
	List<List<Integer>> res = new ArrayList<>();
	if(root == null) return res;
	
	Map<Integer, ArrayList<Integer>> map = new HashMap<>();
	Queue<TreeNode> q = new LinkedList<>();
	Queue<Integer> cols = new LinkedList<>();

	q.add(root); 
	cols.add(0);

	int min = 0, max = 0;
	while(!q.isEmpty()) {
            TreeNode node = q.poll();
            int col = cols.poll();
            if(!map.containsKey(col)) map.put(col, new ArrayList<Integer>());
            map.get(col).add(node.val);

            if(node.left != null) {
                q.add(node.left); 
                cols.add(col - 1);
                if(col <= min) min = col - 1;
            }
            if(node.right != null) {
                q.add(node.right);
                cols.add(col + 1);
                if(col >= max) max = col + 1;
            }
	}
	for(int i = min; i <= max; i++) {
            res.add(map.get(i));
	}
	return res;        
    }
}

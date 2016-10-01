package oa2;
/**
 * 每个节点表示一个员工，节点包含的成员是他工作了几个月(int)，以及一个下属数组(ArrayList<Node>)。
 * 找到一棵子树，满足：这棵子树所有节点的工作月数的平均数是所有子树中最大的。
 * 最后返回这棵子树的根节点。
 */
public class MaxAVGSubTree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x;}
	}
	
	TreeNode ans;
	float bestAVG = 0.0f;
	
	public TreeNode binaryTreePath(TreeNode root) {
		helper(root);		
		return ans;
	}
	
	private int[] helper(TreeNode root) {
		if (root == null) return new int[] {0,0};
		int[] left = helper(root.left);
		int[] right = helper(root.right);
		int[] temp = new int[2];
		temp[0] = left[0] + right[0] + root.val;
		temp[1] = left[1] + right[1] + 1;
		if (temp[1] == 1) return temp;
		float avg = (float) temp[0] / temp[1];
		if (avg > bestAVG) {
			bestAVG = avg;
			ans = root;
		}
		return temp;
	}
}

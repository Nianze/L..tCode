package oa2;

import java.util.*;

/**
 * 每个节点表示一个员工，节点包含的成员是他工作了几个月(int)，以及一个下属数组(ArrayList<Node>)。
 * 找到一棵子树，满足：这棵子树所有节点的工作月数的平均数是所有子树中最大的。
 * 最后返回这棵子树的根节点。
 */

class Node { //这个是题目给好的
	int val;
	List<Node> children;
	public Node(int val){
		this.val = val;
		children = new ArrayList<Node>();
	}
}
public class CompanyTree {
    private static double bestAvg = Double.MIN_VALUE;
    private static Node res;

    public static Node getHighAve(Node root) {
        if (root == null) return null;
        helper(root);
        return res;
    }

    private static int[] helper (Node root) {
        if (root.children == null || root.children.size() == 0)
            return new int[] {0, 0};
        int curSum = root.val;
        int curCnt = 1;
        for (Node child : root.children) {
            int[] SumCnt = helper(child);
            curSum += SumCnt[0];
            curCnt += SumCnt[1];
        }
        double curAvg = (double) curSum / curCnt;
        if (curAvg > bestAvg) {
            bestAvg = curAvg;
            res = root;
        }
        return new int[]{curSum, curCnt};
    }
}

// Created by Rym on 2016.12.8
public class Solution {
    // Complexity: O(N^2) for the worst case and O(NlogN) for balanced binary Tree.
    //  go over all nodes with pathSum - (N), 
    //  each pathSum call the helper which go over all subnodes - (heigth of tree)
    //  so O(h*n) 
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSum(root.left, sum) + 
            pathSum(root.right, sum) +
            helper(root, sum);
    }
    private int helper(TreeNode root, int sum) {
        if (root == null) return 0;
        return helper(root.left, sum - root.val) + 
            helper(root.right, sum - root.val) +
            (root.val == sum ? 1 : 0);
    }

    // O(N) with hashmap
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return findPathSum(root, 0, sum, map);  
    }
    private int findPathSum(TreeNode curr, int sum, int target, Map<Integer, Integer> map) {
        if (curr == null) {
            return 0;
        }
        // update the prefix sum by adding the current val
        sum += curr.val;
        // get the number of valid path, ended by the current node
        int numPathToCurr = map.getOrDefault(sum-target, 0); 
        // update the map with the current sum, so the map is good to be passed to the next recursion
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        // add the 3 parts discussed in 8. together
        int res = numPathToCurr + findPathSum(curr.left, sum, target, map)
                                               + findPathSum(curr.right, sum, target, map);
       // restore the map, as the recursion goes from the bottom to the top
        map.put(sum, map.get(sum) - 1);
        return res;
    }
}

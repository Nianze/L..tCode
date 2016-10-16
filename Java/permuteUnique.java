public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (nums == null) {
            return ans;
        }
        boolean[] isVisited = new boolean[nums.length];
        List<Integer> builder = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, builder, isVisited, ans);
        return ans;
    }

    private void dfs(int[] nums,
                List<Integer> builder,
                boolean[] isVisited,
                List<List<Integer>> ans) {
        if (builder.size() == nums.length) {
            ans.add(new ArrayList<Integer>(builder));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] == true;
                builder.add(nums[i]);
                dfs(nums, builder, isVisited, ans);
                builder.remove(builder.size() - 1);
                isVisited[i] == false;
                while (i < nums.length - 1 && nums[i] == nums[i+1]) {
                    i++;
                }
            }
        }
    }
}

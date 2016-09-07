public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ans.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                cnt++;
                i++;
            }
            int level = ans.size();
            for (int j = 0; j < level; j++){
                List<Integer> temp = ArrayList<Integer>(ans.get(j));
                for (int k = 0; k < cnt; k ++){
                    temp.add(nums[i]);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }
}

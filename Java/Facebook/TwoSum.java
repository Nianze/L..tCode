// Created by Rym on 10/18/2016
// find subarray with given sum
public TwoSum {
    // hashmap based
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(target - nums[i], i);
            } else {
                ans[0] = map.get(nums[i]);
                ans[1] = i;
                return ans;
            }
        }
        return ans;
    }
}

// Created by Rym on 10/18/2016
public TwoSum {
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

    // find subarray with given sum
    public int[] findSubarray(int nums[], int target) {
        int sum = nums[0], start = 0;
        int[] ans = {-1, -1};
        for (int i = 1; i < nums.length; i++) {
            while (sum > target && start < i) {
                sum -= nums[start];
                start++;
            }
            if (sum == target) {
                ans[0] = start;
                ans[1] = i;
                return ans;
            }
            sum += nums[i];            
        }
        return ans;
    }
}

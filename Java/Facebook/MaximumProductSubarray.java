// Created by Rym on 2016.11.28
public class MaximumProductSubarray {
    // one pass, O(n) time, O(1) space
    // Key: keep track of both max and min to current item, record max so far to "ans"
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = 1, min = 1, ans = nums[0];
        for (int num : nums) {
            int buf = max;
            max = Math.max(Math.max(max*num, min*num), num);
            min = Math.min(Math.min(buf*num, min*num), num);
            ans = Math.max(ans, max);
        }
        return ans;        
    }
}

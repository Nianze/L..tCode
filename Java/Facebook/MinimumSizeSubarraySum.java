// Created by Rym on 11/03/2016

public class MinimumSizeSubarraySum {
    // two pointer
    // O(n), O(1)   
    public int minSubArrayLen(int s, int[] nums) {
        int ans = Integer.MAX_VALUE, sumSoFar = 0;
        for (int index = 0, i = 0; i < nums.length; i++) {
            sumSoFar += nums[i];
            while (sumSoFar >= s) {
                ans = Math.min(ans, i - index + 1);
                sumSoFar -= nums[index++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

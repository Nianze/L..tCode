// Created by Rym on 2017.3.6

public int maxSubArray(int[] nums) {
    int[] dp = new int[2];//[nums.length];
    dp[0] = nums[0];
    int max = nums[0];
    for (int i = 1; i < nums.length; i++) {
        dp[i%2] = nums[i%2] + (dp[(i-1)%2] > 0 ? dp[(i-1)%2] : 0);
        max = Math.max(dp[i%2], max);
    }
    return max;
}

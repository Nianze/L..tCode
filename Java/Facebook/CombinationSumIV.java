// Created by Rym on 10/18/2016
public class CombinationSumIV {
    // Recursive
    public int combinationSum4(int [] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                ans += combinationSum4(nums, target - nums[i]);
            }
        }
        return ans;        
    }
    // DP
    public int combinationSum4(int[] nums, int target) {
        int[] comb = new int[target + 1];
        comb[0] = 1;
        for (int i = 1; i < comb.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    comb[i] += comb[i - nums[j]];
                }
            }
        }
        return comb[target];
    }

    // follow up: for what if negative numbers are allowed?
    // ans: it will cause infinite loop and infinite answers.
    // e.g.: given {-1,1}, target = 1, then {1}, {1,1,-1},{1,1,1,-1,-1},... 
    // add requirement: each number should only be used once, or either positive 
    // or negative number should be used only one time, or the length of the combination sum be restricted
    // refer: 
}

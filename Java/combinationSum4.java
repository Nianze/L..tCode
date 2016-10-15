public class Solution {    
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] ans = new int[target + 1];
        for (int i = 0; i < ans.length; i++) {
            for (int num : nums) {
                if (num > i) {
                    break;
                } else if (num == i) {
                    ans[i] += 1;
                } else {
                    ans[i] += ans[i - num];
                }                
            }
        }
        return ans[target];
    }
}

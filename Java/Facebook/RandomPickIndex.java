// Created by Rym on 10/26/2016
public class RandomPickIndex {
    int[] nums;
    Random rnd;
    
    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.rnd = new Random();
    }
    // Reservoir sampling
    public int pick(int target) {
        int ans = -1;
        int count = 0;
        for (int i = 0; i < nums.length(); i++) {
            if (nums[i] == target && rnd.nextInt(++count) == 0) {
                ans = i;
            }
        }
        return ans;
    }
}

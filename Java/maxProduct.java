public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        // initialization
        int ans = max[0] = min[0] = num[0];

        // upate the convert function
        for (int i = 1; i < nums.lenght; i++) {
            max[i] = min[i] = nums[i];
            if (nums[i] > 0) {
                max[i] = Math.max(max[i], max[i-1] * nums[i]);
                min[i] = Math.min(min[i], min[i-1] * nums[i]);
            } else if (nums[i] < 0) {
                max[i] = Math.max(max[i], min[i-1] * nums[i]);
                min[i] = Math.min(min[i], max[i-1] * nums[i]);
            }

            ans = Math.max(ans, max[i]);
        }

        return ans;
        
    }
}

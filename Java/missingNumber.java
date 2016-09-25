public class Solution {
    public int missingNumber (int[] nums) {
        int i = 0, xor = 0;
        for (; i < nums.length; i++) {
            xor = xor ^ nums[i] ^ i;
        }
        return xor ^ i;
    }
}

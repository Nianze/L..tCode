public class Solution {
    // shift non-zero elements to front
    // fill remaining space with zeroes
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int point = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[point++] = nums[i];
            }
        }

        while (point < nums.length) {
            nums[point++] = 0;
        }
    }
}

// Created by Rym on 10/16/2016
class MoveZeroes {
    // O(n) O(1)
    // Two pointer: scan from left to right
    // Move non-zeroes to front, fill remaining with zeroes
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) { return; }
        int point = 0;
        for (int num : nums) {
            if (num != 0) { nums[point++] = num;}
        }
        while (point < nums.length) {
            nums[point++] = 0;
        }
    }

    // new method added by Rym on 2016.11.29
    // one pass, swap based
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int point = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int buf = nums[point];
                nums[point++] = nums[i];
                nums[i] = buf;
            }
        }
    }
}

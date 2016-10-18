class MoveZeroes {
    // O(n) O(1)
    // Two pointer: scan from left to right
    // Move non-zeroes to front, fill remaining with zeroes
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

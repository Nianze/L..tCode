/** BS search - search for first or last position
 * Key points
 * 1. start + 1 < end -> avoid never-end loop
 * 2. start + (end - start) / 2 -> avoid stack overflow
 * 3. A[mid] ==, <, >
 * 4. A[start] A[end] ? target -> only consider resulted two nearest elements' pos with target
 */

public class Solution {
    /**
     * @return first occurrence position of the target
     */
    int findPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;
                //return mid; for case of "return any position"
            } else if (nums[mid] < target) {
                start = mid;
            } else if (nums[mid] > target) {
                end = mid;
            }
        }

        // exchange the position of two if in case of "return last postion"
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}

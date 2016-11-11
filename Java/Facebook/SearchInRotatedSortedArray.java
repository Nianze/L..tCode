// Created by Rym on 11/08/2016
public class SearchInRotatedSortedArray {
    // Binary search
    // note the judgement: not compare [mid] with target, but compare [mid] with [start] or [end]
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) return mid;
            if (nums[start] < nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) end = mid;
                else start = mid;
            }
            if (nums[mid] < nums[end]) {
                if (nums[mid] < target && target <= nums[end]) start = mid;
                else end = mid;
            }
        }
        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
    }
}

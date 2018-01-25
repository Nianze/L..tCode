// Created by Rym on 2016.12.27

public class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        while (start + 1 < end) {n
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) end = mid; // nums[start] <= target, note the = !
                else start = mid;
            } else {
                if (nums[mid] < target && target <= nums[end]) start = mid; // note the = in target <= nums[end]
                else end = mid;
            }
        }
        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
    }
}

// Created by Rym on 2016.12.26
public class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length-1;
        while (start + 1 < end) {
            if (nums[start] < nums[end]) return nums[start];
            int mid = start + (end - start) / 2;
            if (nums[start] > nums[mid]) end = mid;
            else start = mid;
        }
        if (nums[start] < nums[end]) return nums[start];
        return nums[end];
    }
}

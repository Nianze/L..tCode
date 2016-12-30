// Created by Rym on 2016.12.29
public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int radius = 0;
        for (int house : houses) {
            int idx = binarySearch(heaters, house);
            int rightHeater = idx == -1 ? Integer.MAX_VALUE : heaters[idx];
            int leftHeater = idx == -1 ? heaters[heaters.length-1] : 
                             idx == 0 ? Integer.MIN_VALUE : heaters[idx-1];
            int dist = (int) Math.min((long)house - leftHeater, (long)rightHeater - house);
            radius = Math.max(radius, dist);
        }
        return radius;
    }
    
    private int binarySearch(int[] nums, int target) { 
        // predicate: nums[x] >= target && x is low-bound (first yes)
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo)/2;
            if (nums[mid] >= target) hi = mid;
            else lo = mid + 1;
        }
        if (nums[lo] < target) return -1;
        return lo;
    }
}

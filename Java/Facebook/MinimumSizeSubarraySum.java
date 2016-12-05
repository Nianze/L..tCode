// Created by Rym on 11/03/2016

/*
*
Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
*/

public class MinimumSizeSubarraySum {
    // two pointer
    // O(n), O(1)   
    public int minSubArrayLen(int s, int[] nums) {
        int ans = Integer.MAX_VALUE, sumSoFar = 0;
        for (int index = 0, i = 0; i < nums.length; i++) {
            sumSoFar += nums[i];
            while (sumSoFar >= s) {
                ans = Math.min(ans, i - index + 1);
                sumSoFar -= nums[index++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    // O(nlogn):
    // create a sum array, sum[i] = sum[i-1] + nums[i]
    // for each window of nums[i]~nums[len-1], binary search on the window
    // with target set to nums[i] + s
    private int solveNLogN(int s, int[] nums) {
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) sums[i] = sums[i - 1] + nums[i - 1];
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < sums.length; i++) {
            int end = binarySearch(i + 1, sums.length - 1, sums[i] + s, sums);
            if (end == sums.length) break;
            if (end - i < minLen) minLen = end - i;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    
    private int binarySearch(int lo, int hi, int key, int[] sums) {
        while (lo <= hi) {
           int mid = (lo + hi) / 2;
           if (sums[mid] >= key){
               hi = mid - 1;
           } else {
               lo = mid + 1;
           }
        }
        return lo;
    }
}

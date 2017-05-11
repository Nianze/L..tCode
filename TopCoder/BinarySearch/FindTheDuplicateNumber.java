// Created by Rym on 2016.12.30
public class Solution {
    // binary search method. time: n*O(logn)
    // predicate: if dup num is within [lo, mid] (true if count > mid) -> [no no .. no yes yes .. yes]
    // dup num is the low_bound of all the yes field
    public int findDuplicate(int[] nums) {
        int lo = 1, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            int count = 0;
            for (int n : nums) if (n <= mid) count++;
            if (count > mid) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
    
    // linked list cycle II method. time O(n)    
    /** to understand why the second while loop guarantees that the
     * slow and fast will meet at the entry point (which is also the dup num),
     * refer to how the linked-list-cycle-ii works:
     * https://leetcode.com/problems/linked-list-cycle-ii/
     */
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}

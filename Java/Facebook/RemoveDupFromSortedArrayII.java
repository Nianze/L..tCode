// Created by Rym on 10/27/2016
public class RemoveDupFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        return removeDup(nums, nums.length, 2);
    }
    // a general two-pointer method for both I and II:
    // for dup that are allowed at most k times, n is the array length
    // this use O(n) times and O(1) space
    int removeDup(int[] nums, int n, int k) {
        if (n <= k) return n;
        int cnt = 1, ans = 1;
        for (int j = 1; j < n; j++) {
            if (nums[j] != nums[j-1]) {
                cnt = 1;
                nums[ans++] = nums[j];
            } else if (cnt < k) {
                nums[ans++] = nums[j];
                cnt++;
            }
        }
        return ans;
    }    
}

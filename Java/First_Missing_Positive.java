/**
 * Given an unsorted integer array, find the first missing positive integer
 * e.g.:[1,2,0,-1] returns 3; [3,4] returns 1
 **/

public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        // partition the array to make all the positive integers in the front
        // using the similar algorithm as the quick sort
        int k = partition(nums);

        // mark the existance of first k positive integers to negative integers
        for (int i = 0; i <= k; i++) {
            int pointer = Math.abs(nums[i]);
            if ( pointer <= k ) {
                nums[pointer] = - Math.abs(nums[pointer]);
            }
        }

        int result = k + 1; // assume there's no missing positive int. point to the end + 1
        // Check the positive integers in the front of array, the index is the missing number
        for (int i = 0; i <= k; i++) {
            if (nums[i] > 0) {
                result = i;
                break;
            }
        }

        return result + 1;
    }

    // move all the positive element in the front of array
    // @return k: the index of last positive integer
    private int partition(int[] nums) {
        int k = -1;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] > 0) {
                k++;
                swap(nums, k, i);
            }
        }
        return k;
    }
    
    private void swap(int[] nums, int i, int j) {
        /*
        if (i != j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j]
        }
        */
        
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        
    }
}

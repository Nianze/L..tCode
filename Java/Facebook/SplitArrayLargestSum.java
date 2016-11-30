// Created by Rym on 2016.11.28
public class SplitArrayLargestSum {
    /**
     * 1. Given a result, it is easy to test whether it is valid or not.
     * 2. The max of the result is the sum of the input nums.
     * 3. The min of the result is the max num of the input nums.
     * Given the 3 conditions above we can do a binary search. (need to deal with overflow -> use long)
     */
    public int splitArray(int[] nums, int m) {
        long sum = 0;
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }
        return (int) binarySearch(nums, m, max, sum);
    }
    
    private long binarySearch(int[] nums, int m, long start, long end) {
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (valid(nums, m, mid)) end = mid;
            else start = mid;
        }
        if (valid(nums, m, start)) return start;
        return end;
    }

    private boolean valid(int[] nums, int m, long test) {
        int groupSum = 0, count = 1;
        for (int num : nums) {
            groupSum += num;
            if (groupSum > test) {
                groupSum = num;
                count++;
                if (count > m) return false;
            }
        }
        return true;
    }
}

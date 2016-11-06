// Created by Rym on 11/03/2016

public class LongestIncreasingSubsequence {
    // tails[]: stores the smallest tail of all increasing subsequences
    // with length of i+1 in tails[i]. e.g.: for [4,5,6,3]
    // tails = [3,5,6,0]
    // because:
    // len = 1: [4], [5], [6], [3] => tails[0] = 3
    // len = 2: [4, 5], [5, 6] => tails[1] = 5
    // len = 3: [4,5,6] => tails[2] = 6
    // len = 4: none
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] buffer = new int[nums.length];
        int size = 0;
        for (int n : nums) {
            int start = 0, end = size;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (buffer[mid] == n) {
                    start = mid;
                    break;
                } else if (buffer[mid] < n) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            if (buffer[start] >= n) {
                buffer[start] = n;
                if (start == size) { size++; }
            } else {
                buffer[end] = n;
                if (end == size) { size++; }
            }
        }
        return size;
    }
}

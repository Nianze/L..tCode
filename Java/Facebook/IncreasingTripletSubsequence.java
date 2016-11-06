// Created by Rym on 11/03/2016
// Three pointer, with slower two pointer pointing at smallest two increasing subsequense
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        int min = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= min) { min = n; }  // n <= min < mid
            else if (n <= mid) { mid = n; } // min < n <= mid
            else return true; // min < mid < n
        }
        return false;
    }
}

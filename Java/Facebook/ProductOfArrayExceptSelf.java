// Created by Rym on 11/05/2016

public class ProductOfArrayExceptSelf {
    // solve without division and in O(n) time, O(1) space
    // e.g.: [1,2,3,4] return [24,12,8,6]
    // [24,12,8,6] => [()*(4*3*2),(1)*(4*3),(1*2)*(4),(1*2*3)*()]
    // two pass
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i-1] * nums[i-1];
        }
        int buf = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] *= buf;
            buf *= nums[i];
        }
        return ans;
    }
}

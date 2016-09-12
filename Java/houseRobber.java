public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    // method one
    public long houseRobber(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        long[] ans = new long[A.length + 1];

        // base case
        ans[0] = 0;
        ans[1] = A[0];

        for (int i = 2; i <= A.length; i++) {
            ans[i] = Math.max(ans[i -1], ans[i - 2] + A[i - 1]);
        }
        return ans[A.length];
    }

    // improve the space consumption

    public long houseRobber(int[] A) {

        if (A == null || A.length == 0) {
            return 0;
        }

        int n = A.length;
        long[] ans = new long[2];

        // base case
        ans[0] = 0;
        ans[1] = A[0];

        for (int i = 2; i <= n; i++) {
            ans[i%2] = Math.max(ans[(i-1) % 2], ans[(i-2) % 2] + A[i-1]);
        }

        return ans[n % 2];
    }
}

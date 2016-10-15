public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        int[] ans = new int[amount + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i == coin) {
                    ans[i] = 1;
                } else if (i > coin && ans[i - coin] != -1) {
                    ans[i] = Math.min(ans[i - coin] + 1, ans[i]);
                }
            }
            if (ans[i] == Integer.MAX_VALUE) {
                ans[i] = -1;
            }
        }
        return ans[amount];
    }
}

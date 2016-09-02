/**
 * same problem in leetcode: best time to buy and sell stock
 */

public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices == null || prices.length == 0) {
            return maxProfit;
        }

        int smallestSoFar = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < smallestSoFar) {
                smallestSoFar = prices[i];
            }
            maxProfit = Math.max(maxProfit, prices[i] - smallestSoFar);
        }

        return maxProfit;
    }
}

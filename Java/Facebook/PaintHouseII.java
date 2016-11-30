// Created by Rym on 2016/11/26
public class PaintHouseII {
    // 2d DP in place
    // time O(nk), space O(1), for n houses and k colors
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length, k = costs[0].length;
        int min1 = -1, min2 = -1;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                for (int j = 0; j < k; j++) {
                    if (j != min1) costs[i][j] += costs[i-1][min1];
                    else costs[i][j] += costs[i-1][min2];
                }
            }
            min1 = min2 = -1;
            for (int j = 1; j < k; j++) {
                if (min1 < 0 || costs[i][j] < costs[i][min1]) {
                    min2 = min1;
                    min1 = j;
                } else if (min2 < 0 || costs[i][j] < costs[i][min2]) {
                    min2 = j;
                }
            }
        }
        return costs[n-1][min1];
    }
}

// Created by Rym on 2017.3.6

public class Solution {
    // dp[i][j] represents edit dist for word1[0,i) and word2[0,j)
    // if a(word1[i-1]) != b(word2[j-1])
    //    dp[i][j] = dp[i-1][j-1] + 1, to replace a to b
    //    dp[i][j] = dp[i-1][j] + 1, to del a
    //    dp[i][j] = dp[i][j-1] + 1, to add b after a
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1],
                                   Math.min(dp[i-1][j],
                                            dp[i][j-1]));
                }
            }
        }
        return dp[len1][len2];
    }
}

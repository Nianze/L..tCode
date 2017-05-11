// Created by rym on 2017.3.6

public class Solution {
    // dp[i][j] represents s[0,i-1) matches p[0, j-1)
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int j = 2; j <= p.length(); j++) {
            if (p.charAt(j-1) == '*' && dp[0][j-2]) dp[0][j] = true;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                }
                if (p.charAt(j-1) == '*') {
                    if (p.charAt(j-2) != s.charAt(i-1) && p.charAt(j-2) != '.') {
                        dp[i][j] = dp[i][j-2];  // count for 0
                    } else {
                        dp[i][j] = dp[i][j-1] ||  // count for 1
                                   dp[i-1][j] ||  // count for >= 2, same as del s[i-1]
                                   dp[i][j-2];    // count for 0
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}

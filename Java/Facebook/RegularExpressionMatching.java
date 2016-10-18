// Created by Rym on 10/16/2016
public class RegularExpressionMatching {
    // brute force.
    // recursively
    // O(n!)
    public boolean isMatch(Stirng s, String p) {
        // base case for p
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        // p.length == 1 or p's 2 front chars w/o '*'
        if (p.length() == 1 || p.charAt(1) != '*') {
            if (s.isEmpty() || p.charAt(0) != '.' && p.charAt(0) != s.charAt(0)) {
                return false;
            } else {
                // first char is the same
                return isMatch(s.substring(1), p.substring(1));
            }
        }
        // length >= 2, charAt(0) is the same and charAt(2) == '*'
        // match for the case where there are multiple same chars in the s
        while (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
            if (isMatch(s, p.substring(2))) {
                return true;
            }
            s = s.substring(1);
        }
        // charAt(0) is not the same and charAt(2) == '*'
        // match for the case where 'a*' count as ''
        return isMatch(s, p.substring(2));
    }
    
    // O(m*n), O(m*n)
    // Explanation:
    /**
     *1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
     *2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
     *3, If p.charAt(j) == '*': 
     *   here are two sub conditions:
     *         1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
     *         2   if p.charAt(j-1) == s.charAt(i) or p.charAt(i-1) == '.':
     *                        dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a 
     *                     or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
     *                     or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        // dp[i+1][j+1] indicates the state of s[0..i], p[0..j]
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        // s = "", p = ""
        dp[0][0] = true;
        // s = "", p = .*.*, assume p.char(0) != '*'
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '*' && dp[0][j-1]) {
                dp[0][j+1] = true;
            } 
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1]; // check p[j-2] and s[i]
                    } else {
                        dp[i+1][j+1] = dp[i][j+1] || dp[i+1][j] || dp[i+1][j-1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}

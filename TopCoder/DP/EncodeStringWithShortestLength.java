// Creatd by Rym on 2017/1/6
public class Solution {
    public String encode(String s) {
        String[][] dp = new String[s.length()][s.length()];
        for (int l = 0; l < s.length(); l++) {
            for (int i = 0; i < s.length()-l; i++) {
                int j = i + l;
                String check = s.substring(i, j+1);
                dp[i][j] = check;
                if (j - i < 4) continue;
                for (int k = i; k < j; k++) {
                    if (dp[i][k].length() + dp[k+1][j].length() < dp[i][j].length()) {
                        dp[i][j] = dp[i][k] + dp[k+1][j];
                    }
                }
                for (int k = 0; k < check.length()/2; k++) {
                    String sub = check.substring(0, k+1);
                    if (check.length()%sub.length() == 0 && check.replaceAll(sub, "").equals("")) {
                        String temp = check.length()/sub.length() + "[" + dp[i][i+k] + "]";
                        if (temp.length() < dp[i][j].length()) dp[i][j] = temp;
                    }
                }
            }
        }
        return dp[0][s.length()-1];
    }
}

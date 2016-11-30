public class Solution {
    /**
     * @param s input string
     * @return the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        int max = 0, idx = 0;
        for (int i = 0; i < s.length(); i++)  {
            int len1 = explore(s, i, i), len2 = explore(s, i, i + 1);
            int temp = Math.max(len1, len2);
            if ( max < temp ) {
                idx = (len1 > len2) ? (i - len1 / 2) : (i - len2 / 2 + 1);
                max = temp;
            }
        }
        return s.substring(idx, idx + max);
    }

    private int explore(String s, int i, int j) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        return j - i + 1 - 2;
    }
}

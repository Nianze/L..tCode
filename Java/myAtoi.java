public class Solution {
    /**
     * @param str: A string
     * @return An integer
     */
    public int atoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }

        int sign = 1;
        int idx = 0;

        if (str.charAt(idx) == '+') {
            idx++;
        } else if (str.charAt(idx) == '-') {
            sign = -1;
            idx++;
        }
        
        long ans = 0;
        while( idx < str.length()) {
            char c = str.charAt(idx);
            if ( c < '0' || c > '9') {
                break;
            }
            ans = ans * 10 + (c - '0');
            if (ans > Integer.MAX_VALUE) {
                break;
            }
            idx++;
        }
        if (ans * sign >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (ans * sign <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) ans * sign;
    }
}

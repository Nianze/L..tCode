public class Solution {
    /**
     * @param n the integer to be reversed
     * @return the reversed integer
     */
    public int reverseInteger(int n) {
        int ans = 0;
        while( n != 0 ) {
            int temp = ans * 10 + n % 10;
            if ( temp / 10 != ans) {
                ans = 0;
                break;
            }
            ans = temp;
            n /= 10;
        }
        return ans;
    }
}

public class Solution {
    /**
     * @param n The integer
     * @return Roman representation
     */
    public String intToRoman(int n) {
        if (n <= 0) {
            return "";
        }
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4,1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int digit = 0;
        StringBuilder ans = new StringBuilder();
        while (n > 0) {
            int times = n / nums[digit];
            n -= nums[digit] * times;
            for (; times > 0; times--) {
                ans.append(symbols[digit]);
            }
            digit++;
        }
        return ans.toString();
    }
}

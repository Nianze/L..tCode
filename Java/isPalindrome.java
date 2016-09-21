public class Solution {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        char[] cs = s.toLowerCase().toCharArray();
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(cs[left])) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(cs[right])) {
                right--;
            }
            if (cs[left++] != cs[right--]) {
                return false;
            }
        }
        return true;
    }

}

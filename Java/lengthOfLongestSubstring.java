public class Solution {
    /**
     * @param s: a string
     * @return: an integer 
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }

        HashSet<Character> set = new HashSet<Character>();

        int leftBound = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                while (leftBound < i && s.charAt(leftBound) != s.charAt(i)) {
                    set.remove(s.charAt(leftBound));
                    leftBound++;
                }
                leftBound++;
            } else {
                set.add(s.charAt(i));
                max = Math.max(max, i - leftBound + 1); // do not forget + 1
            }
        }
        return max;
    }

    public int lengthOfLongestSubString(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int[] map = new int[256]; // map from ASCII to the char's occurrence
        int leftBound = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            while (map[ch] == 1 && leftBound < i){
                int temp = s.charAt(leftBound);
                map[temp] = 0;
                leftBound++;
            }
            map[ch] = 1;
            ans = Math.max(ans, i - leftBound + 1);
        }
        return ans;
    }
}

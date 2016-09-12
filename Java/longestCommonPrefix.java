public class Solution {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String pref = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            while(j < pref.length() && j < strs[i].length() && pref.charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            if (j == 0) {
                return "";
            }
            pref = pref.substring(0, j);
        }

        return pref;
    }
}

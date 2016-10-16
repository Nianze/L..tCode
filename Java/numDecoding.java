public class Solution {
    public int numDecoding(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] ways = new int[len + 1];
        ways[len] = 1;
        ways[len - 1] = s.charAt(len - 1) == '0' ? 0 : 1;
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') continue; // ways[i] = 0;
            ways[i] = Integer.parseInt(s.substring(i, i+2)) < 27 ?
                ways[i+1] + ways[i+2] :
                ways[i+1];            
        }
        return ways[0];
    }
}

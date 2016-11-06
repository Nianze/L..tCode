// Created by Rym on 10/18/2016
public class DecodeWays {
    // 1D dp, scan from end to front
    public int numDecodings(String s) {
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
    // follow up: update to O(1) space
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] ways = new int[2];
        ways[len%2] = 1;
        ways[(len-1)%2] = s.charAt(len - 1) == '0' ? 0 : 1;
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                ways[i%2] = 0;
            } else {
                ways[i%2] = Integer.parseInt(s.substring(i, i+2)) < 27 ?
                    ways[(i+1)%2] + ways[(i+2)%2] :
                    ways[(i+1)%2];
            }
        }
        return ways[0];        
    }    
}

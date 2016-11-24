package LongestChain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lnz on 11/20/16.
 */

public class LongestChain {
    public static int countChain(String[] dic) {
        int maxLen = Integer.MIN_VALUE;
        for (String s : dic) { maxLen = Math.max(maxLen, s.length()); }
        List<List<String>> lenList = new ArrayList<>();
        for (int i = 0; i < maxLen; i++) {lenList.add(new ArrayList<>());}
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : dic) {
            lenList.get(s.length() - 1).add(s);
            map.put(s, 1);
        }
        int ans = 0;
        for (int i = 0; i < maxLen; i++) {
            List<String> sameLenWords = lenList.get(i);
            for (String s : sameLenWords) {
                for (int j = 0; j < s.length(); j++) {
                    String temp = s.substring(0,j) + s.substring(j+1, s.length());
                    if (map.containsKey(temp)) {
                        int newChain = map.get(temp) + 1;
                        ans = Math.max(ans, newChain);
                        map.put(s, Math.max(map.get(s), newChain));
                    }
                }
            }
        }
        return ans;
    }
}

// Created by Rym on 12.2.2016
public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubtringKDistinct (String s, int k) {
        if (s == null || s.length() == 0) { return 0; }
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > k) {
                char lc = s.charAt(left++);
                map.put(lc, map.get(lc) - 1);
                if (map.get(lc) == 0) map.remove(lc);
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}

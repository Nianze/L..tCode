// Created by Rym on 11/08/2016
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] map = new int[256];
        for (char c : t.toCharArray()) { map[c]++; }
        int start = 0, end = 0, len = Integer.MAX_VALUE, head = 0, count = t.length();
        while (end < s.length()) {
            if (map[s.charAt(end++)]-- > 0) count--;
            while (count == 0) {
                if (end - start < len) len = end - (head = start);
                if (map[s.charAt(start++)]++ == 0) count++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(head, head + len);
    } 
}

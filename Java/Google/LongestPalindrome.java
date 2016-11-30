// Created by Rym on 2016.11.29
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
            } else {
                set.remove(c);
                count++;
            }
        }
        if (!set.isEmpty()) return count * 2 + 1;
        return count * 2;
    }
}

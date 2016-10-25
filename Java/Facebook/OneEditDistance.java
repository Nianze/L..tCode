// Created by Rym on 10/24/2016
public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length()-t.length()) > 1) return false;
        if (s.length() == t.length()) return isOneModify(s, t);
        if (s.length() > t.length()) return isOneAdd(s, t);
        return isOneAdd(t, s);
    }
    private boolean isOneModify(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return s.substring(i+1).equals(t.substring(i+1));
            }
        }
        return false;
    }
    private boolean isOneAdd(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return s.substring(i+1).equals(t.substring(i));
            }
        }
        return true;
    }
}

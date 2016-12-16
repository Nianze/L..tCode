// created by Rym on 2016.12.11
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) return res;
        helper(s, 0, 0, new char[]{'(',')'}, res);
        return res;
    }
    private void helper(String s, int from, int to, char[] paren, List<String> res) {
        int count = 0;
        for (int i = to; i < s.length(); i++) {
            if (s.charAt(i) == paren[0]) count++;
            if (s.charAt(i) == paren[1]) count--;
            if (count < 0) {
                for (int j = from; j <= i; j++) {
                    if (s.charAt(j) == paren[1]) {
                        if (j > from && s.charAt(j-1) == paren[1]) continue; // consecutive '('
                        helper(s.substring(0,j) + s.substring(j+1,s.length()), j, i, paren, res);
                    }
                }
                return;
            }
        }
        StringBuilder sb = new StringBuilder(s);
        if (paren[0] == '(') helper(sb.reverse().toString(), 0, 0, new char[] {')', '('}, res);
        else res.add(sb.reverse().toString());
    }
}

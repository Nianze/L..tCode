// Created by Rym on 11/07/2016
public class ExpressionAddOperators {
    //standard DFS (back trace) method
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        if (num == null || num.length() == 0) { return ans; }
        backTrace(num, "", ans, 0, 0);
        return ans;
    }
    private void backTrace(List<String> ans, String num, String builder, int target, int start, long eval, long mul) {
        if (start = num.length()) {
            if (eval == target) { ans.add(builder); }
            return;
        }
        for (int i = start; i < num.length(); i++) {
            if (i != start && num.charAt(start) == '0') break; // continuous '0' at start
            long cur = Long.parseLong(num.substring(start, i+1));
            if (start == 0) {
                backTrace(ans, num, builder + cur, target, i + 1, cur, cur);
            } else {
                backTrace(ans, num, builder + "+" + cur, target, i + 1, eval + cur, cur);
                backTrace(ans, num, builder + "-" + cur, target, i + 1, eval - cur, - cur);
                backTrace(ans, num, builder + "*" + cur, target, i + 1, (eval - mul) + mul * cur, mul * cur); 
            }
        }
    }
}

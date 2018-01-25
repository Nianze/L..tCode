// Created by Rym on 2016.12.14
public class Solution {
    public String parseTernary(String expression) {
        int i = expression.length();
        while (--i >= 0) { if (expression.charAt(i) == '?') break; }
        if (i == -1) return expression;
        char ans = expression.charAt(i-1) == 'T' ? expression.charAt(i+1) : expression.charAt(i+3);
        return parseTernary(expression.substring(0,i-1) + ans + expression.substring(i+4, expression.length()));
    }

    // use stack
    public String parseTernary(String expression) {
        if (expression == null || expression.length() == 0) return expression;
        Deque<Character> s = new ArrayDeque<>();
        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (!s.isEmpty() && s.peek() == '?') {
                s.pop(); // '?'
                char fst = s.pop(); 
                s.pop(); // ':'
                char sec = s.pop();
                s.push(c == 'T' ? fst : sec);
            } else {
                s.push(c);
            }
        }
        return String.valueOf(s.pop());
    }
}

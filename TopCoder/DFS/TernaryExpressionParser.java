// Created by Rym on 2016.12.14
public class Solution {
    public String parseTernary(String expression) {
        int i = expression.length();
        while (--i >= 0) { if (expression.charAt(i) == '?') break; }
        if (i == -1) return expression;
        char ans = expression.charAt(i-1) == 'T' ? expression.charAt(i+1) : expression.charAt(i+3);
        return parseTernary(expression.substring(0,i-1) + ans + expression.substring(i+4, expression.length()));
    }
}

// Created by Rym on 11/2/2016

public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if ("({[".contains("" + s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (stack.isEmpty() || !match(stack.pop(), s.charAt(i))) {
                return false;
            }
        }
        return stack.isEmpty();
    }
    private boolean match(char l, char r) {
        return (l == '(') && (r == ')') ||
                (l == '{') && (r == '}') ||
                (l == '[') && (r == ']');
    }
}

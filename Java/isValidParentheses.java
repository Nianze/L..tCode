public class Solution {
    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (Character c : s.toCharArray()) {
            if ("([{".contains(String.valueOf(c))) {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && isValid(stack.peek(), c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty()
    }

    private boolean isValid(char c1, char c2) {
        return (c1 == '(' && c2 == ')') ||
            (c1 == '[' && c2 == ']') ||
            (c1 == '{' && c2 == '}');
    }
}

public class Solution {
    /**
     * @param tokens The Reverse Polish Notation
     * @return the value
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        String opt = "+-*/";
        for (String token : tokens) {
            if (!opt.contains(token)) {
                stack.push(Integer.valueOf(token));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                switch (token) {
                case "+": // if (token.equals("+"))
                    stack.push(a+b);
                    break;
                case "-": // if (token.equals("-"))
                    stack.push(a-b);
                    break;
                case "*": // if (token.equals("*"))
                    stack.push(a*b);
                    break;
                case "/": // if (token.equals("/"))
                    stack.push(a/b);
                    break;
                }
            }
        }
        return s.pop();
    }
}

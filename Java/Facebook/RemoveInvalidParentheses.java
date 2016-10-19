public class RemoveInvalidParentheses {
    // one output:
    public String removeInvalidParantheses(String s) {
        String firstPass = "";
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {. visit 1point3acres.com for more.
                char c = s.charAt(i);
            if (c == '(') {
                left++;
                firstPass+='(';
            } else if (c == ')' && right<left) {
                right++;
                firstPass+=')';
            } else if (c != ')' && c != '(') {
                firstPass+=c;
            }
        }
        left = 0;
        right = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = firstPass.length()-1;i>=0;i--)
            {
                char c = firstPass.charAt(i);
                if (c == ')') {
                    right++;
                    sb.append(')');
                } else if (c == '(' && left < right) {
                    left++;
                    sb.append('(');.1point3acres缃�
                                        } else if (c != ')' && c != '(') {
                    sb.append(c);
                }
            }

        return sb.reverse().toString();
    }    

    // follow up: leetcode 301
    
}

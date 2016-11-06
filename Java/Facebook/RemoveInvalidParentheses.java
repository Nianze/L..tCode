public class RemoveInvalidParentheses {
    // return one possible result
    // two pass using counter
    public String removeInvalidParantheses(String s) {
        StringBuilder firstPass = new StringBuilder();
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                counter++;
                firstPass.append('(');
            } else if (c == ')' && counter > 0) {
                counter--;
                firstPass.append(')');
            } else if (c != ')' && c != '(') {
                firstPass.append(c);
            }
        }
        if (counter == 0) return firstPass.toString();
        counter = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = firstPass.length() - 1; i >= 0; i--) { 
            char c = firstPass.charAt(i);
            if (c == ')') {
                counter--;
                sb.append(')');
            } else if (c == '(' && counter < 0) {
                counter++;
                sb.append('(');
            } else if (c != ')' && c != '(') {
                sb.append(c);
            }
        }
        return sb.reverse().toString();
    }    

    // follow up: leetcode 301
    // return all possible results

    // DFS:
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }
    // for continuous ')', say "())", always remove the first ')' firstly, so "())" -> "()"
    // store previous i to prev_i, so that first half of string before i is valid, no need to check again
    // store previous j to prev_j in order to prevent duplicate. e.g.:
    //   if no prev_j stored, it's hard to prevent the same result from two different branch:
    //       "()a)a)" -> "(a)a)" -> "(aa)" and "()a)a)" -> "()aa)" -> "(aa)"

    // time: every path generates one valid answer, if there's k valid answer, the search tree will have k leaves
    //       since each recursive call requires O(n) time from string concatenatino
    //       O(n*m) may be fair enough to describe the time complexity,
    //       where n is the length of string and m is the total nodes (numver of all the rec calls) in the search tree
    // space: O(n*k) for stringbuilder, k is the number of valid answer, n is the length of string
    private void remove(String s, List<String> ans, int prev_i, int prev_j, char[] par) {
        for (int count = 0, i = prev_i; i < s.length(); i++) {
            if (s.charAt(i) == par[0]) count++;
            if (s.charAt(i) == par[1]) count--;
            if (count >= 0) continue;
            for (int j = prev_j; j <= i; j++) { // count < 0, there's extra par[1] 
                if (s.charAt(j) == par[1] && (j == prev_j || s.charAt(j-1) != par[1])) {
                    remove(s.substring(0,j) + s.substring(j+1), ans, i, j, par);
                }
            }
            return;
        }
        StringBuilder reversed = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) { reversed.append(s.charAt(i)); }
        if (par[0] == '(') { remove(reversed.toString(), ans, 0, 0, new char[]{')', '('}); }
        else { ans.add(reversed.toString()); }
    }

    // BFS
    // Time: for a string with n length, each char have 2 states "keep/remove", which is 2^n states
    // each state requires checkValid, which runs in O(n). Together the BFS require O(n*2^n).
    // Ideally, should be O(C(n,k) + n), where k is the number of chars needs removal
    
}

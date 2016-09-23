public class Solution {
    /**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     */
    public ArrayList<String> generateParenthesis(int n) {
    	ArrayList<String> ans = new ArrayList<String>();
    	if (n <= 0) {
    		return ans;
    	}
    	helper(ans, "", n, n);
    	return ans;
    }

    private void helper(ArrayList<String> ans, String paren, int leftStart, int leftEnd) {
    	// leftStart: remaining left parenthesis to be added
    	// leftEnd: remaining right parenthesis to be added
    	if (leftStart == 0 && leftEnd == 0) {
    		ans.add(paren);
    		return;
       	}
       	if (leftStart > 0) {
       		helper (ans, paren + "(", leftStart - 1, leftEnd);
       	}
       	if (leftEnd > leftStart) {
       		helper (ans, paren + ")", leftStart, leftEnd - 1);
       	}
    }
}
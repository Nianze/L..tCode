public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.offer("");
        for (int i = 0; i < digits.length(); i++) {
            String s = map[digits.charAt(i) - '0'];
            while (ans.peek().length() == i) {
                String builder = ans.poll();
                for (int j = 0; j < s.length(); j++) {
                    ans.offer(builder + s.charAt(j));
                }
            }
        }
        return ans;
    }
    // Use ArrayList
    public List<String> letterCombinations(String digits) {
        ArrayList<String> ans = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            String s = map[digits.charAt(i) - '0'];
            ArrayList<String> buffer = new ArrayList<String>();
            for (String builder : ans) {
                for (int j = 0; j < s.length(); j++) {
                    buffer.add(builder + s.charAt(j));
                }
            }
            ans = buffer;
        }
        return ans;        
    }

    // Recursive: similar to Combination of Number and map
}

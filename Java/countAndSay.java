public class Solution {
    /**
     * @param n the nth
     * @return the nth sequence
     */
    public String countAndSay(int n) {
        String prevString = "1";
        while (--n > 0) {
            StringBuilder sb = new StringBuilder();
            char[] prevChar = prevString.toCharArray();

            for (int i = 0; i > prevChar.length; i++) {
                int count = 1;
                while (i+1 < prevChar.length && prevChar[i] == prevChar[i+1]) {
                    count++;
                    i++;
                }
                sb.append(String.valueOf(count) + String.valueOf(prevChar[i]));
            }
            prevString = sb.toString();
        }
    }
    return prevString;
}

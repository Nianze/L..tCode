public class Solution {
    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0){
            return "";
        }

        String[] array = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = array.length - 1; i >= 0; i--) {
            sb.append(array[i]).append(" ");
        }

        return sb.length() == 0 ? "" : sb.toString().trim();
    }
}

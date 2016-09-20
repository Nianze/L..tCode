public class Solution {
    /**
     * @param a a number
     * @param b a number
     * @return the result
     */
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }

        int pa = a.length() - 1;
        int pb = b.length() - 1;
        int carries = 0;
        String ans = "";

        while (pb >= 0) {
            int sum = (a.charAt(pa) - '0') + (b.charAt(pb) - '0') + carries;
            ans = String.valueOf(sum % 2) + ans;
            carries = sum / 2;
            pa --;
            pb --;
        }

        while (pa >= 0) {
            int sum = (int)(a.charAt(pa) - '0') + carries;
            ans = String.valueOf(sum % 2) + ans;
            carries = sum / 2;
            pa --;
        }

        if (carries == 1) {
            ans = "1" + ans;
        }

        return ans;
    }
}

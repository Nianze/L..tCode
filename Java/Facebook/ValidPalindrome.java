public class ValidPalindrome {
    public static void main(String[] args) {
        String test = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(test));
    }     
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int start = 0, end = s.length() - 1;
        while (start < end) {
            while (!Character.isLetterOrDigit(s.charAt(start)) && start < end) { 
                start++;
            }
            while (!Character.isLetterOrDigit(s.charAt(end)) && start < end) {
                end--;
            }
            if (start == end) {
                return true;
            }
            // toLowerCase !!!
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }        
}

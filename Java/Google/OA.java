import java.util.*;

public class Solution {
    // Find the largest number obtained by replacing two adjacent digits with the rounded-up average of the two.
    public static int oa1(int x) {
        String origin = Integer.toString(x);
        int length = origin.length();
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < length - 1; i++) {
            Double replace = Math.ceil(((origin.charAt(i) - '0') + 
                                        (origin.charAt(i + 1) - '0') ) / 2.0); 
            String temp = origin.substring(0, i) +
                replace.intValue() +
                origin.substring(i + 2);
            ans = Math.max(ans, Integer.parseInt(temp));
        }
        return ans;
    }
    
    // Return the maximum length of an absolute path to directory containing an image file
    // Note: path form "/dir1/dir2" not "dir1/dir2"
    public static int oa2(String input) {
        if ( input == null || input.length() == 0 ) {
            return 0;
        }
        int maxImgPath = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1); // add root "/"
        for (String s : input.split("\n") ) {
            int level = s.lastIndexOf("\t") + 1; // level == number of "\t"
            while ( stack.size() > level + 1 ) { 
                stack.pop();
            }
            if (!s.contains(".")) { // s is a sub directory
                stack.push(stack.peek() + s.length() - level + 1); // add 1 because add a "/" at the end								
            } else if (s.endsWith(".jpeg") || 
                       s.endsWith(".png") ||
                       s.endsWith(".git")) {				
                maxImgPath = Math.max(maxImgPath, stack.peek() - 1); // remove the "/" at the end
            }
        }
        return maxImgPath;
    }

    public static void main(String[] args) {
    	String path = "dir1\n\tdir11\n\tdir12\n\t\tpicture.jpeg\n\t\tdir121\n\t\tfile1.txt\ndir2\n\tfile2.gif\n\tfile2.png";
        System.out.println(oa1(623315));
        System.out.println(oa2(path));
    }
}

public class Solution {
     /**
     * @param n an integer
     * @return true if this is a happy number or false
     */
    private static int nextHappyNum(int n) {
        int next = 0;
        while( n != 0 ) {
            next += (n % 10) * (n % 10);
            n /= 10;
        }
        return next;
    }
    
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        while(n != 1) {
            if (set.contains(n)) {
                return false;
            } else {
                set.add(n);
                n = nextHappyNum(n);
            }
        }
        return true;
    }
}

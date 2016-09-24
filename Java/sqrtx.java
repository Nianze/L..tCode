class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        long left = 0, right = x;
        while (left + 1 < right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == x) {
                return (int) mid;
            }
            if (mid * mid < x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (right * right >= x) {
            return (int) right;
        }
        return (int) left;
    }
}

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        int count = 0, candidate;
        for (int n : nums) {
            if (count == 0) {
                candidate = n;
                count++;
            } else if (n == candidate) {
                count ++;
            } else {
                count --;
            }
        }
        return candidate;
    }
}

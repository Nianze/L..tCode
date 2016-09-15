public class Solution {
    /**
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
 	int left = 0, right = heights.length - 1, ans = 0;
        while(left < right) {
            ans = Math.max(ans, (right - left) * Math.min(heights[left], heights[right]));
            if (heights[left] < heights[right]){
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}

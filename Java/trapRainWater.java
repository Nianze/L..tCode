public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int left = 0, right = heights.length - 1;
        int lheight = heights[0], rheight = heights[right];
        int area = 0;
        while (left < right) {
            if (lheight < rheight) {
                left ++;
                if (lheight > heights[left]) {
                    area += lheight - heights[left];
                } else {
                    lheight = heights[left];
                }
            } else {
                right --;
                if (rheight > heights[right]) {
                    area += rheight - heights[right];
                } else {
                    rheight = heights[right];
                }
            }
        }
        return area;
    }
}

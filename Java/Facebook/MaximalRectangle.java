// Created by Rym on 11/12/2016
public class MaximalRectangle {
    // Pure dp
    // time: O(n^2), space: O(n)
    // max rectangle area at m[i][j] = (right[i][j] - left[i][j]) * height[i][j]
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 ||
            matrix[0] == null || matrix[0].length == 0) return 0;
        int row = matrix.length, col = matrix[0].length, ans = 0;
        int[] left = new int[col];
        int[] right = new int[col];
        int[] height = new int[col];
        // init right array's value
        for (int i = 0; i < col; i++) { right[i] = col; }
        for (int i = 0; i < row; i++) {
            int bound = 0;
            // refresh this row's height and left array
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                    left[j] = Math.max(bound, left[j]);
                } else {
                    height[j] = 0;
                    left[j] = 0;
                    bound = j + 1;                    
                }                
            }
            bound = col;
            // refresh this row's right array and calculate max area
            for (int j = col-1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(bound, right[j]);
                } else {
                    right[j] = col;
                    bound = j;
                }
                ans = Math.max(ans, (right[j] - left[j]) * height[j]);
            }
        }
        return ans;
    }
    /**
    e.g.:
    0 0 0 1 0 0 0 
    0 0 1 1 1 0 0 
    0 1 1 1 1 1 0

    row 0:
    l: 0 0 2 3 2 0 0
    r: 7 7 5 4 5 7 7 
    row 2:
    l: 0 1 2 3 2 1 0
    r: 7 6 5 4 5 6 7
    */

    // dp + stack <-- from lc84 largest rectangle in histogram
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 ||
            matrix[0] == null || matrix[0].length == 0) return 0;
        int row = matrix.length, col = matrix[0].length, ans = 0;
        int[] height = new int[col + 1];
        for (int i = 0; i < row; i++) {
            Stack<Integer> s = new Stack<>();
            for (int j = 0; j < col + 1; j++) {
                if (j < col && matrix[i][j] == '1') { height[j]++; }
                else { height[j] = 0; }
                while (!s.isEmpty() && height[s.peek()] > height[j]) {
                    int index = s.pop();
                    ans = Math.max(ans, (s.isEmpty() ? j : j-s.peek()-1) * height[index]);
                }
                s.push(j);
            }
        }
        return ans;
    }
}

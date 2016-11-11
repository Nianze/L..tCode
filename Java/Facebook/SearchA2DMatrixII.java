// Created by Rym on 11/10/2016
public class SearchA2DMatrixII {
    /**
     *Integers in each row are sorted in ascending from left to right.
     *Integers in each column are sorted in ascending from top to bottom.
     */
    //initialize the current position to top right corner
    //if target > cur, then the target can not be in currrent row
    //if target < cur, then the target can not be in current  column because
    //rule out one row or one column each time, so time complexity is O(m+n).
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 ||
            matrix[0] == null || matrix[0].length == 0) return false;
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (target == matrix[row][col]) { return true; }
            else if (target > matrix[row][col]) { row++; }
            else if (target < matrix[row][col]) { col--; }
        }
        return false;
    }
}

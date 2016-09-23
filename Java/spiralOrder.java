public class Solution {
    /**
     * @param matrix a matrix of m x n elements
     * @return an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
            return ans;
        }
        int upRow = 0, downRow = matrix.length - 1;
        int leftCol = 0, rightCol = matrix[0].length - 1;

        while (upRow <= downRow && leftCol <= rightCol) {
            for (int i = leftCol; i <= rightCol; i++) {
                ans.add(matrix[upRow][i]);
            }
            upRow++;

            for (int i = upRow; i <= downRow; i++) {
                ans.add(matrix[i][rightCol]);
            }
            rightCol--;

            if (upRow <= downRow) {  // in case of duplication
                for (int i = rightCol; i >= leftCol; i--) {
                    ans.add(matrix[downRow][i]);
                }
                downRow--;
            }
            if (leftCol <= rightCol) {
                for (int i = downRow; i >= upRow; i--) {
                    ans.add(matrix[i][leftCol]);
                }
                leftCol++;
            }
        }
        return ans;
    }
}

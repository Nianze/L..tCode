// Created by Rym on 11/10/2016

// clockwise: swap up to down, then swap the symmetry
// anticlockwise: swap left to right, then swap the symmetry

public class RotateMatrix {
    public void rotate(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[m - 1 - i];
            matrix[m - 1 - i] = temp;
        }
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}

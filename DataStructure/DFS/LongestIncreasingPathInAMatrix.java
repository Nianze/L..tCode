// Created by rym on 2016.12.15
public class Solution {
    private static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        int max = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int cur = dfs(i, j, matrix, cache);
                max = Math.max(max, cur);
            }
        }
        return max;
    }
    private int dfs(int i, int j, int[][] matrix, int[][] cache) {
        if (cache[i][j] != 0) return cache[i][j];
        int max = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length || matrix[x][y] <= matrix[i][j]) continue;
            int cur = 1 + dfs(x, y, matrix, cache);
            max = Math.max(max, cur);
        }
        cache[i][j] = max;
        return max;
    }
}

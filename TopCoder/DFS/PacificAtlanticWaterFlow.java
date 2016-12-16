// Created by Rym on 2016.12.15
public class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        int n = matrix.length, m = matrix[0].length;
        boolean[][] pac = new boolean[n][m];
        boolean[][] atl = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            dfs(i, 0, matrix, pac, Integer.MIN_VALUE);
            dfs(i, m-1, matrix, atl, Integer.MIN_VALUE);
        }
        for (int i = 0; i < m; i++) {
            dfs(0, i, matrix, pac, Integer.MIN_VALUE);
            dfs(n-1, i, matrix, atl, Integer.MIN_VALUE);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pac[i][j] && atl[i][j]) res.add(new int[]{i,j});
            }
        }
        return res;
    }
    private void dfs(int i, int j, int[][] matrix, boolean[][] ocean, int pre) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || ocean[i][j] || matrix[i][j] < pre) return;
        ocean[i][j] = true;
        dfs(i-1, j, matrix, ocean, matrix[i][j]);
        dfs(i+1, j, matrix, ocean, matrix[i][j]);
        dfs(i, j-1, matrix, ocean, matrix[i][j]);
        dfs(i, j+1, matrix, ocean, matrix[i][j]);
    }
}

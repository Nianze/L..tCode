// Created by rym on 2016.12.19
public class Solution {
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length; 
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') bfs(board, i, 0);
            if (n > 1 && board[i][n-1] == 'O') bfs(board, i, n-1);
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') bfs(board, 0, j);
            if (m > 1 && board[m-1][j] == 'O') bfs(board, m-1, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'B') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }
    private void bfs(char[][] b, int i, int j) {
        Deque<int[]> q = new ArrayDeque<>();
        b[i][j] = 'B';
        q.offer(new int[]{i,j});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0], y = cur[1] + dir[1];
                if (x >= 0 && x < b.length && y >= 0 && y < b[0].length && b[x][y] == 'O') {
                    b[x][y] = 'B';
                    q.offer(new int[]{x, y});
                }
            }
        }
    }
}

// Created by Rym on 11/20/2016
public class GameOfLive {
    // [next][cur]
    //  '10' means current state dead, next state live
    //  '01' means current live, next state dead
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = 0;
                for (int x = Math.max(0,i-1); x <= Math.min(i+1,m-1); x++) {
                    for (int y = Math.max(0,j-1); y <= Math.min(j+1,n-1); y++) {
                        if (x == i && y == j) continue;
                        if ((board[x][y]&1) == 1) lives++;
                    }
                }
                if (board[i][j] == 1 && (lives == 2 || lives == 3)) board[i][j] = 3;
                if (board[i][j] == 0 && lives == 3) board[i][j] = 2;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    // follow up: for infinite board
    // only save a set of live cell coordinates, each time scan only the
    // live cells and their neighbors.
}

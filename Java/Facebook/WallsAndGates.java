// Created by Rym on 11/03/2016

public class WallsAndGates {
    // DFS - bad performance in worst case, may degenerate in O(n^4)
    private static final int[] d = {0, 1, 0, -1, 0};
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) dfs(rooms, i, j);
            }
        }
    }
    private void dfs(int[][] rooms, int i, int j, int dist) {
        for (int k = 0; k < 4; k++) {
            int p = i + d[k], q = j + d[k+1];
            if (0 <= p && p < rooms.length &&
                1 <= q && q < rooms[0].length &&
                rooms[p][q] > rooms[i][j] + 1) {
                dfs(rooms, p, q);
            }
        }
    }
    
    // Multi-end BFS (put all the start point into queue firstly)
    // push all gates into queue first, then update neighbor and push neighbor
    // to the queue until nothing left in the queue
    private static final int[] d = {0, 1, 0, -1, 0};
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0) return;
        int m = rooms.length, n = rooms[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) queue.offer(i * n + j);
            }
        }
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur / n, j = x % n;
            for (int k = 0; k < 4; k++) {
                int p = i + d[k], q = j + d[k+1];
                if (0 <= p && p < m && 0 <= q && q < n && rooms[p][q] == Integer.MAX_VALUE) {
                    rooms[p][q] = rooms[i][j] + 1;
                    queue.offer(p * n + q);
                }
            }
        }
    }
}

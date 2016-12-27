// Created by Rym on 2016.12.23
public class Solution {
    // O((m*n)^2)
    // dist[i][j] store the total distance between the grid[i][j] and all '1's
    // count store the number of reachable '1' for each '0'
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int m = grid.length, n = grid[0].length, numBuilding = 0, res = -1;
        int[][] dist = new int[m][n];
        int[][] count = new int[m][n];
        int[] dirs = new int[]{0, 1, 0, -1, 0};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    numBuilding++;
                    res = -1;
                    int curDist = 0;
                    Deque<int[]> q = new ArrayDeque<>();
                    q.offer(new int[]{i,j});
                    // BFS
                    while (!q.isEmpty()) {
                        int size = q.size();
                        curDist++;
                        while (size-- > 0) {
                            int[] prev = q.poll();
                            for (int k = 0; k < 4; k++) {
                                int x = prev[0] + dirs[k], y = prev[1] + dirs[k+1];
                                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0 && count[x][y] == numBuilding-1) {
                                    count[x][y]++;
                                    dist[x][y] += curDist;
                                    q.offer(new int[]{x,y});
                                    if (res < 0 || res > dist[x][y]) res = dist[x][y];
                                }      
                            }      
                        }
                    }
                }
            }
        }
        return res;
    }
}

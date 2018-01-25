// Created by rym on 2016.12.23
public class Solution {
    private class Cell {
        int x;
        int y;
        int height;
        public Cell(int i, int j, int h) {
            x = i;
            y = j;
            height = h;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) return 0;
        int m = heightMap.length, n = heightMap[0].length;
        Queue<Cell> pq = new PriorityQueue<>(m+n, new Comparator<Cell>(){
            public int compare(Cell c1, Cell c2) {
                return c1.height - c2.height;
            }
        });
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            visited[i][0] = true;
            pq.offer(new Cell(i, n-1, heightMap[i][n-1]));
            visited[i][n-1] = true;
        }
        for (int j = 1; j < n-1; j++) {
            pq.offer(new Cell(0, j, heightMap[0][j]));
            visited[0][j] = true;
            pq.offer(new Cell(m-1, j, heightMap[m-1][j]));
            visited[m-1][j] = true;
        }
        int[] delta = new int[]{0, 1, 0, -1, 0};
        int res = 0;
        while (!pq.isEmpty()) {
            Cell cur = pq.poll();
            for (int d = 0; d < 4; d++) {
                int x = cur.x + delta[d], y = cur.y + delta[d+1];
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                    visited[x][y] = true;
                    res += Math.max(0, cur.height - heightMap[x][y]);
                    pq.offer(new Cell(x, y, Math.max(cur.height, heightMap[x][y])));
                }
            }
        }
        return res;
    }
}

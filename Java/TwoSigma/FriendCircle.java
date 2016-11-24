package FriendCircles;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by lnz on 11/20/16.
 */

public class FriendCircle {
// thought: count the disconnected graph component using dfs
    public static int circleDFS(String[] friends) {
        int circleNum = 0;
        boolean[] visited = new boolean[friends.length];
        for (int i = 0; i < friends.length; i++) {
            if (!visited[i]) {
                dfs(i, friends, visited);
                circleNum++;
            }
        }
        return circleNum;
    }

    static void dfs(int i, String[] friends, boolean[] visited) {
        if (visited[i]) return;
        visited[i] = true;
        for (int suc = 0; suc < friends[i].length(); suc++) {
            if (friends[i].charAt(suc) == 'y' && suc != i && !visited[suc]) {
                dfs(suc, friends, visited);
            }
        }
    }

    //bfs:
    public static int circleBFS(String[] friends) {
        boolean[] visited = new boolean[friends.length];
        Deque<Integer> q = new ArrayDeque<>();
        visited[0] = true;
        q.offer(0);
        int circles = 0;
        while (!q.isEmpty()) {
            int idx = q.poll();
            String cur = friends[idx];
            for (int i = 0; i < cur.length(); i++) {
                if (cur.charAt(i) == 'y' && i != idx && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
            if (q.isEmpty()) {
                circles++;
                for (int i = 1; i < friends.length; i++) {
                    if (!visited[i]) {
                        q.offer(i);
                        visited[i] = true;
                        break;
                    }
                }
            }
        }
        return circles;
    }

    //union find:
    public int circleUF(String[] friends) {
        UnionFind uf = new UnionFind(friends.length);
        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                if (i != j && friends[i].charAt(j) == 'y') uf.union(i,j);
            }
        }
        return uf.count;
    }

    class UnionFind {
        int[] parent;
        int[] rank;
        int count;
        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        int find(int x) {
            if (x != parent[x]) x = find(parent[x]);
            return parent[x];
        }
        boolean union(int x, int y) {
            int px = find(x), py = find(y);
            if (px == py) return false;
            if (rank[py] < rank[px]) parent[py] = px;
            else if (rank[px] < rank[py]) parent[px] = py;
            else {
                parent[py] = px;
                rank[px]++;
            }
            count--;
            return true;
        }
    }
}

// Created by Rym on 2016.12.9
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        int[] visited = new int[numCourses];
        for (int[] pre : prerequisites) {
            adj.get(pre[0]).add(pre[1]);
        }
        List<Integer> buf = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, adj, visited, buf)) return new int[]{};
        }
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) res[i] = buf.get(i);
        return res;
    }
    private boolean dfs(int cur, List<List<Integer>> adj, int[] visited, List<Integer> buf) {
        if (visited[cur] == 1) return false;
        if (visited[cur] == 2) return true;
        visited[cur] = 1;
        for (int pre : adj.get(cur)) {
            if (!dfs(pre, adj, visited, buf)) return false;
        }
        visited[cur] = 2;
        buf.add(cur);
        return true;
    }
}

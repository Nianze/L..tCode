// Created by Rym on 2016.12.9
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<Integer>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int[] visited = new int[n];
        if (!dfs(-1, 0, adj, visited)) return false;
        for (int i : visited) if (i == 0) return false;
        return true;
    }
    private boolean dfs(int from, int cur, List<List<Integer>> adj, int[] visited) {
        if (visited[cur] == 1) return false;
        if (visited[cur] == 2) return true;
        visited[cur] = 1;
        for (int node : adj.get(cur)) {
            if (node == from) continue;
            if (!dfs(cur, node, adj, visited)) return false;
        }
        visited[cur] = 2;
        return true;
    }
}

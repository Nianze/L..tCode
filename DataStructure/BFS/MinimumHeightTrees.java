// Created by Rym on 2016.12.20
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges == null || edges.length == 0) return Arrays.asList(0);
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) { adj.add(new HashSet<>()); }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < adj.size(); i++) {
            if (adj.get(i).size() == 1) q.offer(i);
        }
        while (n > 2) {
            int size = q.size();
            n -= size;
            while (size-- > 0) {
                int leaf = q.poll();
                int par = adj.get(leaf).iterator().next();
                adj.get(par).remove(leaf);
                if (adj.get(par).size() == 1) q.offer(par);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) res.add(q.poll());
        return res;
    }
}

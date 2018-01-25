// Created by Rym on 2016.12.19
public class Solution {
        // Consider a graph which consists of number 0, 1,...,n as
        // its nodes. Node j is connected to node i via an edge if  
        // and only if either j = i + (a perfect square number) or 
        // i = j + (a perfect square number). Starting from node 0, 
        // do the breadth-first search. If we reach node n at step 
        // m, then the least number of perfect square numbers which 
        // sum to n is m. Here since we have already obtained the 
        // perfect square numbers, we have actually finished the 
        // search at step 1.
    public int numSquares(int n) {
        Deque<Integer> q = new ArrayDeque<>();
        List<Integer> square = new ArrayList<>();
        int[] count = new int[n+1];
        for (int i = 1; i*i <= n; i++) {
            q.offer(i*i);
            square.add(i*i);
            count[i*i] = 1; 
        }
        if (count[n] > 0) return 1;
        while (!q.isEmpty()) {
            List<Integer> buf = new ArrayList<>();
            while (!q.isEmpty()) buf.add(q.poll());
            for (int i = 0; i < buf.size(); i++) {
                for (int j = 0; j < square.size(); j++) {
                    int next = buf.get(i) + square.get(j);
                    if (next > n) break;
                    if (count[next] == 0) {
                        count[next] = count[buf.get(i)] + 1;
                        if (count[n] > 0) return count[n];               
                        q.offer(next);
                    }
                }
            }
        }
        return count[n];
    }
}

public class Solution {
    // Topological sort vis BFS
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList();
        int[] degree = new int[numCourses];
        int[] ans = new int[numCourses];
        int index = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        // Init graph
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        // Set up graph and degree
        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
        }
        // Set up queue
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
                ans[index++] = i;
            }
        }
        // BFS
        while (!queue.isEmpty()) {
            int from = queue.poll();
            for (int to : graph.get(from)) {
                degree[to]--;
                if (degree[to] == 0) {
                    queue.offer(to);
                    ans[index++] = to;
                }
            }
        }
        if (index != numCourses) {
            return new int[0];
        } else {
            return ans;
        }
    }
    
    // Topological sort via DFS
    
}

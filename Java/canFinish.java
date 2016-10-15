public class Solution {
    // BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList();
        int[] degree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<Integer>();
        int count = 0;
        // init graph
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        // set up graph
        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
        }
        for (int d : degree) {
            if (d == 0) {
                queue.offer(d);
                count++;
            }
        }
        while(!queue.isEmpty()) {
            int from = queue.poll();
            for (int to : graph.get(from)) {
                degree[to]--;
                if (degree[to] == 0) {
                    queue.offer(to);
                    count++;
                }
            }
        }
        if (count == numCourses) {
            return true;
        }
        return false;
    }
}

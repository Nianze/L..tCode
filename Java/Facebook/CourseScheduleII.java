// Created by Rym on 11/03/2016

public class CourseScheduleII {
    // BFS
    // note: adjList[i] points to list of all the succesive courses of course i
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] count = new int[numCourses];
        for (int i = 0; i < numCourses; i++) { adjList.add(new ArrayList<>()); }
        for (int[] edge : prerequisites) {
            adjList.get(edge[1]).add(edge[0]);
            count[edge[0]]++;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (count[i] == 0) queue.offer(i);
        }
        int[] ans = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            ans[index++] = pre;
            for (int succ : adjList.get(pre)) {
                count[succ]--;
                if (count[succ] == 0) { queue.offer(succ); }
            }
        }
        return index < numCourses ? new int[0] : ans; // if has loop, empty ans.
    }

    // DFS
    // note: adjList[i] points to list of all prerequisite courses of course i
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) { adjList.add(new ArrayList<Integer>()); }
        for (int[] edge : prerequisites) { adjList.get(edge[0]).add(edge[1]); } 
        Deque<Integer> queue = new ArrayDeque<>();
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, adjList, visited, queue)) { return new int[0]; }
        }
        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) ans[i] = queue.poll();
        return ans;
    }
    private boolean dfs(int cur, List<List<Integer>> adjList, int[] visited, Deque<Integer> queue) {
        if (visited[cur] == 1) return false; // has cycle
        if (visited[cur] == 2) return true;
        visited[cur] = 1; // mark as being visited
        for (int pre : adjList.get(cur)) {
            if (!dfs(pre, adjList, visited, queue)) return false;
        }
        visited[cur] = 2; // mark as completed
        queue.offer(cur);
        return true;
    }    
}

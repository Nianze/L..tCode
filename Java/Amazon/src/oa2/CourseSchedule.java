package oa2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseSchedule {
	// DFS
	boolean hasCycle = false;
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		Stack<Integer> stack = new Stack<>();
		List<List<Integer>> graph = new ArrayList<>();
		int[] path = new int[numCourses];
		// build the base
		for (int i = 0; i < numCourses; i++) {
			graph.add(new ArrayList<>());
		}
		// build the graph 
		for (int i = 0; i < prerequisites.length; i++) {
			graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}
		for (int i = 0; i < numCourses; i++) {
			dfs(stack, graph, path, i);
			if (hasCycle) {
				return new int[0];
			}
		}
		int[] ans = new int[numCourses];
		for (int i = numCourses - 1; i >= 0; i--) {
			ans[i] = stack.pop();
		}
		return ans;
	}
	
	private void dfs(Stack<Integer> stack, List<List<Integer>> graph, int[] path, int course) {
		if (path[course] == 1) {
			hasCycle = true;
			return;
		}
		if (path[course] == 2 || hasCycle) {
			return;
		}
		path[course] = 1; // 1 means being exploring
		for (int nextCourse : graph.get(course)) {
			dfs(stack, graph, path, nextCourse);
			if (hasCycle) {
				return;
			}
		}
		stack.push(course);
		path[course] = 2; // 2 means exploration complete 
	}
}

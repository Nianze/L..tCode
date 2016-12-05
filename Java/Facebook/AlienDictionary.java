// Created by Rym on 11/13/2016
// Completed by Rym on 11/25/2016
public class AlienDictionary {
    // DFS
    // build the graph(post-adjacency list and visited list) -> dfs and check loop
    // note 1 visited[]: -1(not exist), 0(no pre-node), 1(visiting), 2(visited)
    // note 2 the order: reversely add node - add post nodes to sb firstly to avoid missing pre-nodes for current nodes
    private static int N = 26;
    public String alienOrder(String[] words) {
        boolean[][] adj = new boolean[N][N];
        int[] visited = new int[N];
        if (!buildGraph(words, adj, visited)) return ""; // "abcd" -> "ab"

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {
                if (!dfs(adj, visited, sb, i)) return "";
            }
        }
        return sb.reverse().toString();
    }
    private boolean dfs(boolean[][] adj, int[] visited, StringBuilder sb, int i) {
        visited[i] = 1;  // visiting
        for (int j = 0; j < N; j++) {
            if (adj[i][j]) { // connected post nodes
                if (visited[j] == 1) return false;  // loop case
                if (visited[j] == 0) {
                    if (!dfs(adj, visited, sb, j)) return false;
                }
            }
        }
        visited[i] = 2; // visited
        sb.append((char)('a' + i));
        return true;
    }        
    private boolean buildGraph(String[] words, boolean[][] adj, int[] visited) {
        Arrays.fill(visited, -1); // init to not existed
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) visited[c - 'a'] = 0;
            if (i > 0) {
                String w1 = words[i-1], w2 = words[i];
                int len = Math.min(w1.length(), w2.length());
                for (int j = 0; j < len; j++) {
                    char c1 = w1.charAt(j), c2 = w2.charAt(j);
                    if (c1 != c2) {
                        adj[c1 - 'a'][c2 - 'a'] = true;
                        break;
                    }
                    if (j == len-1 && w1.length() > w2.length()) return false; // "abcd" -> "ab"   
                }
            }
        }
        return true;
    }

    // BFS
    // build the graph(post-adjacency list and degree list)
    //    -> bfs using Karn's algorithm to do topological sort (essentially BFS)
    // note degree[]: -1(not exist), 0(no pre-node), 1,2,3...(pre-nodes number)
    public String alienOrder(String[] words) {
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) adj.add(new HashSet<Integer>());
        int[] degree = new int[N];
        Arrays.fill(degree, -1);
        // init the adj and degree list
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                if (degree[c-'a'] < 0) degree[c-'a'] = 0;
            }
            if (i > 0) {
                String w1 = words[i-1], w2 = words[i];
                int len = Math.min(w1.length(), w2.length());
                for (int j = 0; j < len; j++) {
                    int c1 = w1.charAt(j) - 'a', c2 = w2.charAt(j) - 'a';
                    if (c1 != c2) {
                        if (!adj.get(c1).contains(c2)) {
                            adj.get(c1).add(c2);
                            degree[c2]++;
                        }
                        break;
                    }
                    if (j == len-1 && w1.length() > w2.length()) return ""; // "abcd" -> "ab"   
                }
            }
        }
        // topological sort
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) q.offer(i);
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int i = q.poll();
            sb.append((char) ('a' + i));
            for (int j : adj.get(i)) {
                degree[j]--;
                if (degree[j] == 0) q.offer(j);
            }
        }
        for (int d : degree) if (d > 0) return ""; // has loop
        return sb.toString();
    }
}

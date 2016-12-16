// Created by Rym on 2016.12.11
// essentially the Eulerian path problem, use Hierholzer's algorithm
public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, Queue<String>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            map.putIfAbsent(ticket[0], new PriorityQueue<>());
            map.get(ticket[0]).offer(ticket[1]);
        }
        LinkedList<String> res = new LinkedList<>();
        dfs("JFK", map, res);
        return res;
    }
    // greedy + dfs
    private void dfs(String departure, Map<String, Queue<String>> map, LinkedList<String> res) {
        Queue<String> arrivals = map.get(departure);
        while (arrivals != null && !arrivals.isEmpty()) dfs(arrivals.poll(), map, res);
        res.addFirst(departure);
    }
}

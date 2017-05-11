package oa2;

import java.util.*;

public class OrderDependSolution {
    public static List<Order> orderDependency(List<OrderDependency> orderDependencies) {
        List<Order> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Map<String, Order> unwrap = new HashMap<>();
        Map<String, Integer>  inDeg = new HashMap<>();
        Map<String, List<String>> adjList = new HashMap<>();
        // Init inDegree and adjList
        for (OrderDependency edge : orderDependencies) {
            String pre = edge.pre.orderName;
            String cur = edge.cur.orderName;
            set.add(pre);
            set.add(cur);
            if (!unwrap.containsKey(pre)) unwrap.put(pre, edge.pre);
            if (!unwrap.containsKey(cur)) unwrap.put(cur, edge.cur);
            // init inDegree
            if (!inDeg.containsKey(pre)) inDeg.put(pre, 0);
            inDeg.put(cur, inDeg.getOrDefault(cur, 0) + 1);
            // init adjacency list
            if (!adjList.containsKey(pre)) {
                adjList.put(pre, new ArrayList<>());
            }
            List<String> list = adjList.get(pre);
            list.add(cur);
            adjList.put(pre, list);
            if (!adjList.containsKey(cur)) adjList.put(cur, new ArrayList<>());
        }
        Deque<String> q = new ArrayDeque<>();
        for (String s : inDeg.keySet()) {
            if (inDeg.get(s) == 0) q.offer(s);
        }
        while (!q.isEmpty()) {
            String cur = q.poll();
            res.add(unwrap.get(cur));
            List<String> adj = adjList.get(cur);
            for (String next : adj) {
                inDeg.put(next, inDeg.get(next) - 1);
                if (inDeg.get(next) == 0) q.offer(next);
            }
        }
        if (set.size() != res.size()) return null; // has cycle in graph
        return res;
    }

}

class Order{
    String orderName;
    public Order(String string){
        this.orderName = string;
    }
}
class OrderDependency{
    Order cur;
    Order pre;
    public OrderDependency(Order pre, Order cur){
        this.pre = pre;
        this.cur = cur;
    }
}
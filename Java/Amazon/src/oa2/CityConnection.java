package oa2;

import java.util.*;

class Connection {
    String city1;
    String city2;
    int cost;
    Connection (String city1, String city2, int cost) {
        this.city1 = city1;
        this.city2 = city2;
        this.cost = cost;
    }
    public void printConnection () {
        System.out.println("{ " + this.city1 + " , " + this.city2 + "} " + this.cost);
    }
}

public class CityConnection {
    // union find + Kruskal will work, but need to use a map to project string to int
    public static List<Connection> getLowCost(List<Connection> connections) {
        List<Connection> res = new ArrayList<>();
        Set<String> citySet = new HashSet<>();
        Map<String, String> parent = new HashMap<>();
        Collections.sort(connections, new Comparator<Connection>() {
            @Override
            public int compare(Connection o1, Connection o2) {
                return o1.cost - o2.cost;
            }
        });
        for (Connection c : connections) {
            String c1 = c.city1;
            String c2 = c.city2;
            citySet.add(c1);
            citySet.add(c2);
            parent.put(c1, c1);
            parent.put(c2, c2);
        }
        for (Connection c : connections) {
            if (union(c.city1, c.city2, parent)) res.add(c);
        }
        if (citySet.size() != res.size() + 1) return null;
        Collections.sort(res, new Comparator<Connection>() {
            @Override
            public int compare(Connection a, Connection b) {
                if (a.city1.equals(b.city1)) return a.city2.compareTo(b.city2);
                else return a.city1.compareTo(b.city1);
            }
        });
        return res;
    }

    private static boolean union (String a, String b, Map<String, String> parent) {
        String setA = find(a, parent);
        String setB = find(b, parent);
        if (setA.equals(setB)) return false;
        parent.put(setB, setA);
        return true;
    }

    private static String find(String s, Map<String, String> parent) {
        if (!s.equals(parent.get(s))) {
            parent.put(s, find(parent.get(s), parent)); // path compression
        }
        return parent.get(s);
    }

    // naive way
    public static List<Connection> findPath(List<Connection> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList<Connection> ans = new ArrayList<Connection>();
        HashSet<String> visited = new HashSet<>();	
        while(!list.isEmpty()) {
            Connection temp = findMinConnected(list, visited);
            if ( temp == null) {
                return null;
            }
            list.remove(temp);
            visited.add(temp.city1);
            visited.add(temp.city2);
            ans.add(temp);
        }
        Collections.sort(ans, new Comparator<Connection>() {
                @Override
                public int compare(Connection a, Connection b) {
                    if (a.city1.equals(b.city1)) return a.city2.compareTo(b.city2);
                    else return a.city1.compareTo(b.city1);
                }
            });
        return ans;
    }
	
    private static Connection findMinConnected(List<Connection> list, Set<String> visited) {
        Connection result = null;
        int minCost = Integer.MAX_VALUE;
        for(Connection c : list) {
            if (c.cost < minCost) {
                if (visited.isEmpty()) {
                    minCost = c.cost;
                    result = c;
                    continue;
                }
                if ((visited.contains(c.city1) && !visited.contains(c.city2)) ||
                    (visited.contains(c.city2) && !visited.contains(c.city1))) {
                    minCost = c.cost;
                    result = c;
                }
            }
        }
        return result;
    }
}

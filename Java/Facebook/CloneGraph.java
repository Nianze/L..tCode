// Created by Rym on 10/24/2016

public class CloneGraph {
    // DFS rec
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        return dfsClone(node, map);
    }
    private UndirectedGraphNode dfsClone(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
        if (node == null) return null;
        if (map.containsKey(node.label)) return map.get(node.label);
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(newNode.label, newNode);
        for (UndirectedGraphNode oldNode : node.neighbors) {
            newNode.neighbors.add(dfsClone(oldNode, map));
        }
        return newNode;
    }

    // BFS iterative
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        map.put(newNode.label, newNode);
        while (!queue.isEmpty()) {
            UndirectedGraphNode originNode = queue.poll();
            for (UndirectedGraphNode oldNeighbor : originNode.neighbors) {
                if (!map.containsKey(oldNeighbor.label)) {
                    map.put(oldNeighbor.label, new UndirectedGraphNode(oldNeighbor.label));
                    queue.offer(oldNeighbor);
                }
                map.get(originNode.label).neighbors.add(map.get(oldNeighbor.label));
            }
        }
        return newNode;
    }
}

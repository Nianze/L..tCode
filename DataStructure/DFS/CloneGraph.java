// Created by Rym on 2016.12.9
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        return dfs(node, map);
    }
    private UndirectedGraphNode dfs(UndirectedGraphNode node, Map<UndirectedGraphNode,UndirectedGraphNode> map) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node, newNode);
        for (UndirectedGraphNode old : node.neighbors) {
            newNode.neighbors.add(dfs(old, map));
        }
        return newNode;
    }
}

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return node;
        Map<Integer, UndirectedGraphNode> visited = new HashMap<Integer, UndirectedGraphNode>();
        UndirectedGraphNode result = dfs(node, visited);
        return result;
    }

    private UndirectedGraphNode dfs(UndirectedGraphNode original, Map<Integer, UndirectedGraphNode> visited){
        if (visited.containsKey(original.label)){
            return visited.get(original.label);
        }

        UndirectedGraphNode newNode = new UndirectedGraphNode(original.label); // 創建新的node
        visited.put(newNode.label, newNode);

        List<UndirectedGraphNode> neighbors = original.neighbors;
        for (UndirectedGraphNode neighbor: neighbors){ // 尋遍每個node
            UndirectedGraphNode newVisited = dfs(neighbor, visited);     // 繼續走訪新的neighbor
            newNode.neighbors.add(newVisited); // 把遇到的neighbor加到現有的neighbor
        }
        return newNode;
    }
}

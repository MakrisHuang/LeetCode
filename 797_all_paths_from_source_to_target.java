class Solution {
    // apply dfs visiting
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        findPath(0, res, path, graph);
        return res;
    }
    
    private void findPath(int curr, List<List<Integer>> res, List<Integer> temp, int[][] graph) {
        if (curr == graph.length - 1) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int neighbor: graph[curr]) {
            temp.add(neighbor);
            findPath(neighbor, res, temp, graph);
            temp.remove(temp.size() - 1);
        }
    }
}
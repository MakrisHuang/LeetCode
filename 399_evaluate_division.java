class Solution {
    public double[] calcEquation(String[][] equations, double[] values,
                                 String[][] queries) {
        Set<String> set = new HashSet<>();
        for (String[] pair: equations) {
            Collections.addAll(set, pair);
        }
        List<String> list = new ArrayList<>(set);
        double[][] graph = new double[set.size()][set.size()];
        for (int i = 0, len = equations.length; i < len; i++) {
            int aIdx = list.indexOf(equations[i][0]);
            int bIdx = list.indexOf(equations[i][1]);
            graph[aIdx][bIdx] = values[i];
            graph[bIdx][aIdx] = 1 / values[i];
        }

        // calculate results
        double[] result = new double[queries.length];
        for (int i = 0, len = queries.length; i < len; i++) {
            int aIdx = list.indexOf(queries[i][0]);
            int bIdx = list.indexOf(queries[i][1]);
            if (aIdx == -1 || bIdx == -1) {
                result[i] = -1;
                continue;
            }
            if (!almostEqual(graph[aIdx][bIdx], 0)){
                result[i] = graph[aIdx][bIdx];
                continue;
            }
            if (!almostEqual(graph[bIdx][aIdx], 0)){
                result[i] = graph[bIdx][aIdx];
                continue;
            }
            result[i] = dfs(graph, aIdx, bIdx);
        }
        return result;
    }

    private double dfs(double[][] graph, int startIdx, int endIdx) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startIdx);
        Stack<Double> valStack = new Stack<>();
        valStack.push(1.0);
        ArrayList<Integer> visited = new ArrayList<>();

        int len = graph.length;
        while (!stack.empty()) {
            int curIdx = stack.pop();
            double curVal = valStack.pop();
            if (visited.contains(curIdx))
                continue;
            visited.add(curIdx);

            if (curIdx == endIdx)
                return curVal;

            for (int i = 0; i < len; i++) {
                if (!almostEqual(graph[curIdx][i], 0)) {
                    stack.push(i);
                    valStack.push(curVal * graph[curIdx][i]);
                }
            }
        }
        return -1;
    }

    private boolean almostEqual(double a, double b) {
        return Math.abs(a - b) < 1e-7;
    }
}

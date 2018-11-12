class Solution {
    public double[] calcEquation(String[][] equations, double[] values,
                                 String[][] queries) {
        Set<String> set = new HashSet<>();
        for (String[] pair: equations) {
            Collections.addAll(set, pair);
        }
        List<String> list = new ArrayList<>(set);
        double[][] graph = new double[set.size()][set.size()];
        /*
            graph:
                |   a   | b     |   c   |
             a  |   1   | 3     |       |
             b  | 1/3   | 1     |   2   |
             c  |       | 1/2   |   1   |
        */
        for (int i = 0, len = equations.length; i < len; i++) {
            int aIdx = list.indexOf(equations[i][0]);
            int bIdx = list.indexOf(equations[i][1]);
            graph[aIdx][bIdx] = values[i];
            graph[bIdx][aIdx] = 1 / values[i];
        }

        // calculate results
        double[] result = new double[queries.length];
        for (int i = 0, len = queries.length; i < len; i++) {
            // try to find query alphabet
            int aIdx = list.indexOf(queries[i][0]);
            int bIdx = list.indexOf(queries[i][1]);
            
            // if one of them is not found, then assign as -1
            if (aIdx == -1 || bIdx == -1) {
                result[i] = -1;
                continue;
            }
            if (graph[aIdx][bIdx] != 0) {
                result[i] = graph[aIdx][bIdx];
                continue;
            }
            if (graph[bIdx][aIdx] != 0) {
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
        // add dummpy candidate
        valStack.push(1.0);
        boolean[] visited = new boolean[graph.length];

        while (!stack.empty()) {
            int curIdx = stack.pop();
            double curVal = valStack.pop();
            
            if (visited[curIdx])
                continue;
            visited[curIdx] = true;

            if (curIdx == endIdx)
                return curVal;

            for (int i = 0; i < graph.length; i++) {
                if (graph[curIdx][i] != 0) {
                    stack.push(i);
                    valStack.push(curVal * graph[curIdx][i]);
                }
            }
        }
        return -1;
    }
}
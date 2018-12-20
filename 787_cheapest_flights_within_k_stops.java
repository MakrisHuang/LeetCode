class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // int[][] graph = buildGraph(n, flights);
        // int res = shortestPath(graph, src, dst, K + 1);
        // return (res == Integer.MAX_VALUE) ? -1 : res;
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        int stops = 0;
        while(queue.size() != 0){
            for(int i = 0; i < queue.size(); ; i++){
                int city = queue.poll();
                for(int[] f : flights){
                    int u = f[0];
                    int v = f[1];
                    if(stops == K && v != dst) continue; // if we are total stops and not destination yet we can skip this!
                    if(city == u && cost[v] > cost[u] + f[2]){  // if weight of visiting u is smaller than directly visiting v
                        cost[v] = cost[u] + f[2];               // then update weight to node v
                        queue.add(v);                           // keep searching on node v since there may be smaller weight
                    }
                }
            }
            stops++;
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }

//     public int[][] buildGraph(int N, int[][] flights) {
//         int[][] graph = new int[N][N];

//         // initialize graph with -1
//         for (int[] row: graph) {
//             Arrays.fill(row, -1);
//         }

//         // fill values from source
//         for (int[] edge: flights) {
//             int src = edge[0];
//             int dst = edge[1];
//             int weight = edge[2];
//             graph[src][dst] = weight;
//         }
//         return graph;
//     }

//     public int shortestPath(int[][] graph, int curr, int dest, int edges) {
//         if (edges == 0 && curr == dest) return 0;
//         if (edges == 1 && graph[curr][dest] != -1) {
//             return graph[curr][dest];
//         }
//         if (edges <= 0) {
//             return -1;
//         }

//         // initialize result
//         int res = Integer.MAX_VALUE;

//         // search all adjacents of i recursively
//         for (int next = 0; next < graph.length; next++) {
//             if (graph[curr][next] != -1 &&
//                 curr != next &&    // not visiting current one
//                 dest != next) {    // not visiting the destination for getting lower weight
//                 System.out.println("curr: " + curr + ", next: " + next);
//                 int remain = shortestPath(graph, next, dest, edges - 1);
//                 if (remain != -1) {
//                     res = Math.min(res, graph[curr][next] + remain);
//                 }
//             }
//         }
//         return res;
//     }
}

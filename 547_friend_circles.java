class Solution {
    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        Queue<Integer> queue = new LinkedList<>();
        int circleCount = 0;

        // iterate each element
        for (int candIdx = 0; candIdx < M.length; candIdx++) {
            if (visited[candIdx] == false) {
                queue.add(candIdx);

                while (! queue.isEmpty()) {
                    int eleIdx = queue.remove();
                    visited[eleIdx] = true;

                    for (int neighborIdx = 0; neighborIdx < M.length; neighborIdx++) {
                        if (visited[neighborIdx] != true && M[eleIdx][neighborIdx] == 1) {
                            queue.add(neighborIdx);
                        }
                    }
                }
                circleCount++;
            }
        }

        return circleCount;
    }
}

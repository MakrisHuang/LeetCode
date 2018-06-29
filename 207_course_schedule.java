class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] adj = new int[numCourses][numCourses];
        int[] ref = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (adj[pre][ready] == 0) {
                ref[ready]++; // duplicate cases
            }
            adj[pre][ready] = 1;
        }

        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
            if (ref[i] == 0) queue.offer(i);
        }

        int count = 0;
        while (! queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (adj[course][i] != 0) {
                    if (--ref[i] == 0) {    // when no indegrees, add i to queue as new candidate
                        queue.offer(i);
                    }
                }
            }
        }

        return count == numCourses;
    }
}

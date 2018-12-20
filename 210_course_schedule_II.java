class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] adj = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (adj[pre][ready] == 0) {
                indegree[ready]++;
            }
            adj[pre][ready] = 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        List<Integer> res = new ArrayList<>();
        int count = 0;
        while(queue.size() != 0) {
            int course = queue.poll();
            res.add(course);
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (adj[course][i] != 0) {
                    if (--indegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        int[] ans = new int[] {};
        if (count == numCourses) {
            ans = res.stream().mapToInt(i->i).toArray();
        }
        return ans;
    }
}

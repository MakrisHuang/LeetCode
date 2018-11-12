class Solution {
    // Time Complexity: O(n), Space Complexity: 26 -> O(1)
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        PriorityQueue < Integer > queue = new PriorityQueue<>(26, Collections.reverseOrder());
        for (int f: map) {
            if (f > 0)
                queue.add(f);
        }
        int time = 0;   // answer
        while (!queue.isEmpty()) {
            int taskCounter = 0;          // empty slots
            List< Integer > temp = new ArrayList< >();
            while (taskCounter <= n) {        // restriction to the number of intervals
                if (!queue.isEmpty()) {
                    if (queue.peek() > 1)
                        temp.add(queue.poll() - 1); // when a task is used, decrease the amount
                    else
                        queue.poll();   // because it's only 1, just pop it out
                                        // not necessary to store to temporary list
                }
                time++;                 // the total tasks (including idle) we have
                if (queue.isEmpty() && temp.size() == 0)    // meet the end in this segment, quit
                    break;
                taskCounter++;
            }
            queue.addAll(temp);   // used tasks are re-push to the queue
        }
        return time;
    }
}
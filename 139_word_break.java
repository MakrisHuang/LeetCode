class Solution {
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        queue.offer(0);

        while (! queue.isEmpty()) {
            int start = queue.poll();
            if (!visited[start]) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordSet.contains(s.substring(start, end))) {
                        queue.offer(end);
                        if (end == s.length()) return true;
                    }
                }
                visited[start] = true;
            }
        }
        return false;
    }
}

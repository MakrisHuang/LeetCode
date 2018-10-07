class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         Set<String> wordSet = new HashSet<>(wordDict);
//         Queue<Integer> queue = new LinkedList<>();
//         boolean[] visited = new boolean[s.length()];
//         queue.offer(0);

//         while (! queue.isEmpty()) {
//             int start = queue.poll();
//             if (!visited[start]) {
//                 for (int end = start + 1; end <= s.length(); end++) {
//                     if (wordSet.contains(s.substring(start, end))) {
//                         queue.offer(end);
//                         if (end == s.length()) return true;
//                     }
//                 }
//                 visited[start] = true;
//             }
//         }
//         return false;
//     }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] isValid = new boolean[s.length() + 1];
        isValid[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                isValid[i] = isValid[j] && wordDict.contains(s.substring(j, i));
                if (isValid[i]) break;
            }
        }
        return isValid[s.length()];
    }
}

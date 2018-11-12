class Solution {
    // apply DFS instead of topological sort
    // by using 4 status
    /*
    visited[i] = -1. Not even exist.
    visited[i] = 0. Exist. Non-visited.
    visited[i] = 1. Visiting.
    visited[i] = 2. Visited.
    */
    private final int N = 26;
    
    public String alienOrder(String[] words) {
        // initialize variables here
        boolean[][] adj = new boolean[N][N];
        int[] visited = new int[N];
        buildGraph(words, adj, visited);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {
                if (!dfsVisit(adj, visited, sb, i)) return "";
            }
        }
        return sb.reverse().toString();
    }
    
    public boolean dfsVisit(boolean[][] adj, int[] visited, StringBuilder sb, int alphabetIdx) {
        visited[alphabetIdx] = 1;
        for (int j = 0; j < N; j++) {
            if (adj[alphabetIdx][j]) {              // connected
                if (visited[j] == 1) return false;  // 1 -> 1 => cycle => false
                if (visited[j] == 0) {              // 0 => unvisited
                    if (!dfsVisit(adj, visited, sb, j)) return false;
                }    
            }
        }
        visited[alphabetIdx] = 2;
        sb.append((char) (alphabetIdx + 'a'));
        return true;
    }
    
    public void buildGraph(String[] words, boolean[][] adj, int[] visited) {
        Arrays.fill(visited, -1);
        for (int i = 0; i < words.length; i++) {
            for (char c: words[i].toCharArray()) {
                visited[c - 'a'] = 0;
            }
            if (i > 0) {
                String w1 = words[i - 1], w2 = words[i];
                int len = Math.min(w1.length(), w2.length());
                for (int j = 0; j < len; j++) {
                    // compare each character
                    char c1 = w1.charAt(j), c2 = w2.charAt(j);
                    if (c1 != c2) {
                        adj[c1 - 'a'][c2 - 'a'] = true;
                        break;  // the remaining comparison is useless, break here
                    }
                }
            }
        }
    }
}
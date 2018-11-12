class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        List<Integer> cur = new ArrayList<>(m + 1);
        for (int i = 1; i <= m; i++)
            cur.set(i,i);
        for (int j = 1; j <= n; j++) {
            int pre = cur.get(0);
            cur.set(0,)
            for (int i = 1; i <= m; i++) {
                int temp = cur[i];
                if (word1[i - 1] == word2[j - 1])
                    cur[i] = pre;
                else cur[i] = min(pre + 1, min(cur[i] + 1, cur[i - 1] + 1));
                pre = temp;
            }
        }
        return cur[m]; 
    }
}
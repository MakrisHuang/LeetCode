class Solution {
    // Time Complexity: O(log (len(S) * len(T)))
    // Space Complexity: O(len(S) * len(T))
    public int numDistinct(String s, String t) {
        Integer[][] dp = new Integer[s.length()][t.length()];
        return countDist(s, t, 0, 0, dp);
    }

    public int countDist(String s, String t, int sStart, int tIdx, Integer[][] dp) {
        if (tIdx == t.length()) {
            return 1;
        }
        int sum = 0;
        for (int i = sStart; i < s.length(); i++) {
            // need to lock count in current index
            // ex. T: 0.1 2 3 4 5
            //    S1: 0 1 2 3 5 6
            //    S2: 0 1 2 4 5 6
            // in S1, [3 5 6] should be one case, and also for [4 5 6] in S2
            // that's why we use sum variable here
            int count = 0;
            if (s.charAt(i) == t.charAt(tIdx)) {
                if (dp[i][tIdx] != null) {
                    count += dp[i][tIdx];
                } else {
                    count += countDist(s, t, i + 1, tIdx + 1, dp);
                    // System.out.println("set dp[" + i + "][" + tIdx + "] = " + count);
                    dp[i][tIdx] = count;
                }
                sum += count;
            }
        }
        return sum;
    }
}

class Solution {
    // Use bottom-up dynamic programming by examine previous substring in a 2D array
    // Time Complexity: O(len(s) * len(p))
    // Space Complexity: O(len(s) * len(p))
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        // initialize column
        for (int i = 0; i < s.length(); i++) {
            dp[i][0] = false;
        }

        // initialize first row
        // empty string matches with * in pattern
        for (int i = 0; i < p.length() && p.charAt(i) == '*'; i++) {
            dp[0][i + 1] = true;
        }

        dp[0][0] = true;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (s.charAt(i) == p.charAt(j)
|| p.charAt(j) == '?') dp[i + 1][j + 1] = dp[i][j];
                if (p.charAt(j) == '*') dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1];
            }
        }
        return dp[s.length()][p.length()];
    }
}

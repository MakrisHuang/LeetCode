class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return backtrace(0, 0, m, n, dp);
    }

    private int backtrace(int r, int c, int m, int n, int[][] dp) {
        if (r == m - 1 || c == n - 1) return 1;
        if (r >= m || c >= n) return 0;

        if (dp[r + 1][c] == -1)
            dp[r + 1][c] = backtrace(r + 1, c, m, n, dp);
        if (dp[r][c + 1] == -1)
            dp[r][c + 1] = backtrace(r, c + 1, m, n, dp);
        return dp[r + 1][c] + dp[r][c + 1];
    }
}

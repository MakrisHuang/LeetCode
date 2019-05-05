class Solution {
    // Bottom-Up approach
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        dp[m][n - 1] = 1; // either dp[m - 1][n] is fine
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[0][0];
    }
}

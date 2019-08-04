class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        dp = [[0] * n for i in range(m)]
        for i in range(0, n):
            dp[0][i] = 1
            if obstacleGrid[0][i] == 1:
                dp[0][i] = 0
                break;

        for i in range(0, m):
            dp[i][0] = 1
            if obstacleGrid[i][0] == 1:
                dp[i][0] = 0
                break

        for i in range(1, m):
            for j in range(1, n):
                if obstacleGrid[i][j] == 1:
                    dp[i][j] = 0
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        return dp[m - 1][n - 1]

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix or not matrix[0]: return 0

        largest = 0
        dp = [[0] * len(matrix[0]) for _ in range(len(matrix))]

        for i in range(len(matrix)):
            dp[i][0] = int(matrix[i][0])
            largest = max(largest, dp[i][0])

        for j in range(len(matrix[0])):
            dp[0][j] = int(matrix[0][j])
            largest = max(largest, dp[0][j])

        for i in range(1, len(matrix)):
            for j in range(1, len(matrix[0])):
                if matrix[i][j] == "1":
                    # since the minimum could be 0, and current matrix[i][j] == 1
                    # we need to plus one to have least 1 item
                    dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1
                else:
                    dp[i][j] = 0
                largest = max(largest, dp[i][j])

        return largest * largest



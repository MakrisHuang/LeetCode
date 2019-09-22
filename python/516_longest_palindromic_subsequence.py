class Solution:
    # Time Complexity: O(n ^ 2)
    # Space Complexity: O(n ^ 2)
    def longestPalindromeSubseq(self, s: str) -> int:
        # palindromic -> symmetric
        n = len(s)
        dp = [[0 for _ in range(n)] for _ in range(n)]

        for i in range(n - 1, -1, -1):
            dp[i][i] = 1
            for j in range(i + 1, n):
                if s[i] == s[j]:
                    # plus 2: 向外擴展兩個字元，故加 2
                    dp[i][j] = dp[i + 1][j - 1] + 2
                else:
                    dp[i][j] = max(dp[i + 1][j], dp[i][j - 1])
        return dp[0][n - 1]

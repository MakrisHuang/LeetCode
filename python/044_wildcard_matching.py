class Solution:
    # Time Complexity: O(len(s) * len(p))
    # Space Complexity: O(len(s) * len(p))
    def isMatch(self, s: str, p: str) -> bool:
        # apply greedy?? no because * can match any characters
        # apply dynamic programming
        dp = [[False for _ in range(len(p) + 1)] for _ in range(len(s) + 1)]

        # initialize first row
        # empty string also matches with * in pattern
        for i in range(len(p)):
            if p[i] == '*':
                dp[0][i + 1] = True
            else:
                break

        dp[0][0] = True

        for i in range(len(s)):
            for j in range(len(p)):
                if s[i] == p[j] or p[j] == '?':
                    dp[i + 1][j + 1] = dp[i][j]
                if p[j] == '*':
                    dp[i + 1][j + 1] = (dp[i + 1][j] or dp[i][j + 1])

        return dp[len(s)][len(p)]

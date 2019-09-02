class Solution:
    def numDecodings(self, s: str) -> int:
        if not s: return 0
        dp = [0] * (len(s) + 1)
        dp[0] = 1
        dp[1] = 1 if s[0] != '0' else 0

        for i in range(2, len(s) + 1):
            first = int(s[i - 1:i])
            second = int(s[i - 2:i])
            if 1 <= first and first <= 9:
                dp[i] += dp[i - 1]
            if 10 <= second and second <= 26:
                dp[i] += dp[i - 2]

        return dp[len(s)]

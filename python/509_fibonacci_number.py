class Solution:
    def fib(self, N: int) -> int:
        dp = [1] * (N + 1)
        dp[0] = 0
        for i in range(2, N + 1):
            dp[i] = dp[i - 1] + dp[i - 2]
        return dp[N]

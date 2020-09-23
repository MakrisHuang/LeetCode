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

    def numDecodings_recursive(self, s: str) -> int:
        def recursive(curr: int, s: str, memo: dict):
            if curr == len(s):
                return 1
            if s[curr] == '0': return 0
            if curr == len(s) - 1:
                return 1

            if s[curr:] in memo:
                return memo[s[curr:]]

            ans = recursive(curr + 1, s, memo)
            if int(s[curr: curr + 2]) <= 26:
                ans += recursive(curr + 2, s, memo)
            memo[s[curr:]] = ans
            return ans

        memo = dict()
        return recursive(0, s, memo)

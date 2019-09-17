class Solution:
    # Time Complexity: O(len(strs) * m * n)
    # Space Complexity: O(m * n)
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        dp = [[0 for _ in range(n + 1)] for _ in range(m + 1)]
        for s in strs:
            zero, one = self.countzeroesones(s)
            for i in range(m, zero - 1, -1):
                for j in range(n, one - 1, -1):
                    dp[i][j] = max(1 + dp[i - zero][j - one], dp[i][j])
        return dp[m][n]

    def countzeroesones(self, s: str):
        zero = one = 0
        for c in s:
            if c == '0':
                zero += 1
            elif c == '1':
                one += 1
        return zero, one

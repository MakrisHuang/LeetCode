class Solution:
    def rob(self, nums: List[int]) -> int:
        l = len(nums)
        dp = [[0] * 2 for i in range(0, l + 1)]
        for i in range(1, l + 1):
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])
            dp[i][1] = nums[i - 1] + dp[i - 1][0]
        return max(dp[l][0], dp[l][1])

class Solution:
    def rob(self, nums: List[int]) -> int:
        l = len(nums)
        # reduce space usage by only using two columns
        dp = [[0] * 2 for i in range(2)]
        for i in range(1, l + 1):
            dp[i % 2][0] = max(dp[(i - 1 + 2) % 2][0], dp[(i - 1 + 2) % 2][1])
            dp[i % 2][1] = nums[i - 1] + dp[(i - 1 + 2) % 2][0]
        return max(dp[l % 2][0], dp[l % 2][1])

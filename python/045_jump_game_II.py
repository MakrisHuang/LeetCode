class Solution:
    def jump(self, nums: List[int]) -> int:
        length = len(nums)
        dp = [math.inf] * length
        dp[length - 1] = 0

        for i in range(length - 2, -1, -1):
            for jumpLen in range(1, nums[i] + 1):
                # min(n-1, i + jumpLen) for bounds handling
                # by making length - 1 steps, it is guaranteed to reach the final index
                # but it is possible that jumpLen + i is greater than length - 1
                # so we need to take the min steps there
                dp[i] = min(dp[i], 1 + dp[min(length - 1, i + jumpLen)]);

        return dp[0]

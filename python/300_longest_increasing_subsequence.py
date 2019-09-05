class Solution:
    # Time Complexity: O(n * 2)
    # Space Complexity: O(n)
    def lengthOfLIS(self, nums: List[int]) -> int:
        # apply dynamic programming
        # f(i) = max(curr_idx, dp[j]), j < i
        if not nums: return 0

        dp = [0] * len(nums)
        dp[0] = 1
        res = 1
        for i in range(1, len(nums)):
            curr_max = 0
            # record how many numbers that are smaller than me
            for j in range(i):
                if nums[i] > nums[j]:
                    curr_max = max(curr_max, dp[j])
            dp[i] = curr_max + 1
            res = max(res, dp[i])
        return res


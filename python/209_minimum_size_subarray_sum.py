class Solution:
    def minSubArrayLen(self, s: int, nums: List[int]) -> int:
        sum = 0
        left = 0
        ans = float('inf')

        for i, value in enumerate(nums):
            sum += value
            while sum >= s:
                ans = min(ans, i - left + 1)
                sum -= nums[left]
                left += 1
        return ans if ans != float('inf') else 0

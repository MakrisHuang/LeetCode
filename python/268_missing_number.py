class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        total = (1 + len(nums)) * (len(nums)) / 2

        return int(total - sum(nums))

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        unique_idx = dup_idx = 0
        while dup_idx < len(nums):
            while dup_idx + 1 < len(nums) and nums[dup_idx] == nums[dup_idx + 1]:
                dup_idx += 1
            nums[unique_idx] = nums[dup_idx]
            unique_idx += 1
            dup_idx += 1
        return unique_idx

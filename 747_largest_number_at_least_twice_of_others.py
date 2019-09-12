class Solution:
    def dominantIndex(self, nums: List[int]) -> int:
        max_idx = 0
        max_num = max(nums)
        for i, num in enumerate(nums):
            if num == max_num:
                max_idx = i

        for i, num in enumerate(nums):
            if num == max_num:
                continue
            if max_num < 2 * num:
                return -1
        return max_idx

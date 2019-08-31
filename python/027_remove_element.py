class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        curr_idx = orig_idx = 0
        while curr_idx < len(nums):
            if nums[curr_idx] != val:
                nums[orig_idx] = nums[curr_idx]
                orig_idx += 1
            curr_idx += 1
        return orig_idx


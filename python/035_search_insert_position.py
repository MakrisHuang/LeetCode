class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        # use binary search to find target
        lo, hi = 0, len(nums) - 1
        while (lo < hi):
            mid = int((lo + hi) / 2)
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                lo = mid + 1
            else:
                hi = mid;
        if nums[lo] < target:
            return lo + 1
        return lo

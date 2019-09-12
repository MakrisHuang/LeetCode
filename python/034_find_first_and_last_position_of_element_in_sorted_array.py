class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def findTarget(nums: List[int], target: int, isLeft: bool) -> bool:
            lo = 0
            hi = len(nums)
            while lo < hi:
                mid = (lo + hi) >> 1
                if nums[mid] > target or (isLeft and target == nums[mid]):
                    hi = mid
                else:
                    lo = mid + 1
            return lo

        left_idx = findTarget(nums, target, True)
        if left_idx == len(nums) or nums[left_idx] != target:
            return [-1, -1]
        return [left_idx, findTarget(nums, target, False) - 1]

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # apply binary search
        left = 0
        right = len(nums) - 1
        while left < right:
            mid_idx = left + (right - left) // 2
            if nums[left] + nums[right] < target:
                if nums[mid_idx] + nums[right] < target:
                    left = mid_idx + 1
                else:
                    left += 1
            elif nums[left] + nums[right] > target:
                if nums[mid_idx] + nums[left] > target:
                    right = mid_idx
                else:
                    right -= 1
            else:
                return [left + 1, right + 1]
        return []

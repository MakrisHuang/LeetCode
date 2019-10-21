class Solution:
    def search(self, nums: List[int], target: int) -> int:
        offset = 0
        for i in range(1, len(nums)):
            if nums[i] < nums[offset]:
                offset = i
                break

        nums.sort()
        lo, hi = 0, len(nums) - 1
        while lo <= hi:
            mid = (lo + hi) // 2
            if nums[mid] > target:
                hi = mid - 1
            elif nums[mid] < target:
                lo = mid + 1
            else:
                index = mid - (len(nums) - offset)
                if index < 0:
                    index = len(nums) + index
                return index
        return -1



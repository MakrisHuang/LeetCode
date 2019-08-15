class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        return self.binarySearch(nums, 0, len(nums) - 1)

    def binarySearch(self, nums, left, right) -> int:
        if left == right:
            return left
        mid = int((left + right) / 2)
        print(mid)
        if nums[mid] > nums[mid + 1]:
            return self.binarySearch(nums, left, mid)
        else:
            return self.binarySearch(nums, mid + 1, right)

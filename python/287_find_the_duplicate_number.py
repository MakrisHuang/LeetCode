class Solution:
    """
    Use binary search and pigeonhole theory
    ex. nums = [2,3,4,5,6,7,1,1,1,1], low = 1, high = 9, mid = 5
    counting num <= 5 is 8, which means there are duplications below 5
    so search with (low, mid), otherwise search (mid + 1, hi)
    """
    def findDuplicate(self, nums: List[int]) -> int:
        lo, hi = 0, len(nums) - 1
        while lo < hi:
            mid = (lo + hi) / 2
            count = 0
            for index, val in enumerate(nums):
                if val <= mid:
                    count += 1

            if count <= mid:
                lo = int(mid + 1)
            else:
                hi = mid

        return lo


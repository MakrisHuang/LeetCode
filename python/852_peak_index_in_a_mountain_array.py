class Solution:
    def peakIndexInMountainArray(self, A: List[int]) -> int:
        # apply binary search
        # if it's a ramp, means A[i] < A[i + 1], and we can move to right
        # otherwise, it's a downhill, and we need to move left
        left, right = 0, len(A) - 1
        while left < right:
            mid = left + (right - left) // 2
            if A[mid] < A[mid + 1]:
                left = mid + 1
            else:
                right = mid
        return left

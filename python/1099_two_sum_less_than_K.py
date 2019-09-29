class Solution:
    # Time Complexity: O(N)
    # Space Complexity: O(1)
    def twoSumLessThanK(self, A: List[int], K: int) -> int:
        A.sort()
        left, right = 0, len(A) - 1
        res = -1
        while left < right:
            s = A[left] + A[right]
            if s < K:
                res = max(res, s)
                left += 1
            else:
                right -= 1
        return res

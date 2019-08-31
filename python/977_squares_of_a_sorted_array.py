class Solution:
    def sortedSquares(self, A: List[int]) -> List[int]:
        res = [0] * len(A)
        left = 0
        curr_idx = right = len(A) - 1

        while left <= right:
            left_square = A[left] ** 2
            right_square = A[right] ** 2
            if left_square > right_square:
                res[curr_idx] = left_square
                left += 1
            else:
                res[curr_idx] = right_square
                right -= 1
            curr_idx -= 1
        return res

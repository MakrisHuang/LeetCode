class Solution:
    # Time Complexity: O(N)
    # Space Complexity: O(N)
    def sortedSquares(self, A: List[int]) -> List[int]:
        left, right = 0, len(A) - 1
        res = []
        while left <= right:
            leftSquare, rightSquare = A[left] ** 2, A[right] ** 2
            if leftSquare > rightSquare:
                res.append(leftSquare)
                left += 1
            else:
                res.append(rightSquare)
                right -= 1
        res.reverse()
        return res

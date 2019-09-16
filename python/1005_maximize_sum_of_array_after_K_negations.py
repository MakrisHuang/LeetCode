class Solution:
    def largestSumAfterKNegations(self, A: List[int], K: int) -> int:
        def findMin(A: List[int]):
            min_idx, min_val = 0, A[0]
            for i, value in enumerate(A):
                if value < min_val:
                    min_idx = i
                    min_val = value
            return min_idx

        while K > 0:
            isAnyNeg = False
            for num in A:
                if num < 0:
                    isAnyNeg = True
                    break
            if isAnyNeg:
                min_idx = findMin(A)
                A[min_idx] = -A[min_idx]
            else:
                if K % 2 == 0:
                    break
                else:
                    min_idx = findMin(A)
                    A[min_idx] = -A[min_idx]
            K -= 1
        return sum(A)

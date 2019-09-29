class Solution:
    def isMonotonic(self, A: List[int]) -> bool:
        isIncreasing = True
        if A[-1] < A[0]:
            isIncreasing = False

        for i in range(len(A) - 1):
            if isIncreasing and A[i] > A[i + 1]:
                return False
            if not isIncreasing and A[i] < A[i + 1]:
                return False
        return True

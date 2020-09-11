class Solution:
    def isToeplitzMatrix(self, matrix: List[List[int]]) -> bool:
        if not matrix or not matrix[0]: return True
        M, N = len(matrix), len(matrix[0])
        # first row
        for j in range(N):
            x, y = 0, j
            curr = matrix[x][y]
            while x + 1 < M and y + 1 < N:
                if curr != matrix[x + 1][y + 1]:
                    return False
                x, y = x + 1, y + 1
        # first col
        for i in range(1, M):
            x, y = i, 0
            curr = matrix[x][y]
            while x + 1 < M and y + 1 < N:
                if curr != matrix[x + 1][y + 1]:
                    return False
                x, y = x + 1, y + 1
        return True


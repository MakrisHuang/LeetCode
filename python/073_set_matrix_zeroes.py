class Solution(object):
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        col0 = False
        M, N = len(matrix), len(matrix[0])
        for i in range(M):
            if matrix[i][0] == 0: col0 = True
            for j in range(1, N):
                if matrix[i][j] == 0:
                    matrix[i][0] = 0
                    matrix[0][j] = 0
        print('init', matrix)
        for i in range(M - 1, -1, -1):
            for j in range(N - 1, 0, -1):
                if matrix[i][0] == 0 or matrix[0][j] == 0:
                    matrix[i][j] = 0
            if col0:
                matrix[i][0] = 0


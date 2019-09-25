class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        # count consecutive 1's in a row
        if not matrix or not matrix[0]: return 0
        M, N = len(matrix), len(matrix[0])
        for i in range(M):
            for j in range(1, N):
                if matrix[i][j] == '1':
                    matrix[i][j] = str(int(matrix[i][j - 1]) + 1)
                else:
                    matrix[i][j] = '0'

        max_area = 0
        for i in range(M):
            for j in range(N):
                # also the width of this row
                # since height = 1, area = 1 * width = length of this row
                single_row_area = int(matrix[i][j])
                if single_row_area > 0:
                    max_area = max(max_area, single_row_area)
                    row = i - 1
                    while row >= 0 and matrix[row][j] != '0':
                        single_row_area = min(single_row_area, int(matrix[row][j]))
                        max_area = max(max_area, single_row_area * (i - row + 1))
                        row -= 1
        return max_area

class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        eles = []
        if not matrix: return eles
        m, n = len(matrix), len(matrix[0])
        row, col = 0, -1

        while True:
            # move right
            for i in range(0, n):
                col += 1
                eles.append(matrix[row][col])
            m -= 1
            if m == 0: break

            # move down
            for i in range(0, m):
                row += 1
                eles.append(matrix[row][col])
            n -= 1
            if n == 0: break

            # move left
            for i in range(0, n):
                col -= 1
                eles.append(matrix[row][col])
            m -= 1
            if m == 0: break

            # move up
            for i in range(0, m):
                row -= 1
                eles.append(matrix[row][col])
            n -= 1
            if n == 0: break
        return eles


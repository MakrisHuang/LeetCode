# https://leetcode.com/problems/count-square-submatrices-with-all-ones/discuss/643429/Python-DP-Solution-%2B-Thinking-Process-Diagrams-(O(mn)-runtime-O(1)-space)
class Solution:
    def countSquares(self, matrix: List[List[int]]) -> int:
        """
        1 1 1 1
        1 1 1 1
        1 1 1 0
        1 1 1 0

        Use dynamic programming to calculate the adjacent elements to
        see if the current element can form a larger square
        """

        rows = len(matrix)
        cols = len(matrix[0])

        count_grid = [[0 for _ in range(cols)] for _ in range(rows)]
        for i in range(rows):
            for j in range(cols):
                count_grid[i][j] = matrix[i][j]
        print(count_grid)

        # iterate each element and check if the 1 is a combo element
        for i in range(1, rows):
            for j in range(1, cols):
                if matrix[i][j] == 1:
                    count_grid[i][j] += min(count_grid[i - 1][j - 1], count_grid[i- 1][j], count_grid[i][j - 1])

        ans = 0
        for i in range(rows):
            for j in range(cols):
                if count_grid[i][j] > 0:
                    ans += count_grid[i][j]
        return ans

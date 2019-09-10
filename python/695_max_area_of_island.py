class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        rows, cols = len(grid), len(grid[0])

        def dfs(grid: List[List[int]], i: int, j: int) -> int:
            area = 1
            grid[i][j] = 0
            for direction in ((-1, 0), (0, 1), (1, 0), (0, -1)):
                next_i, next_j = i + direction[0], j + direction[1]
                if next_i < 0 or next_i >= rows or next_j < 0 or next_j >= cols or grid[next_i][next_j] == 0:
                    continue
                area += dfs(grid, next_i, next_j)
            return area

        max_area = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    max_area = max(max_area, dfs(grid, i, j))
        return max_area

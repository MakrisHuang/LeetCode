class Solution:
    def closedIsland(self, grid: List[List[int]]) -> int:
        def fill(grid, x, y):
            if x < 0 or x >= len(grid) or y < 0 or y >= len(grid[0]) or grid[x][y] == 1:
                return
            grid[x][y] = 1
            for dx, dy in [[-1, 0], [0, 1], [1, 0], [0, -1]]:
                new_x, new_y = x + dx, y + dy
                fill(grid, new_x, new_y)

        ans = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if i == 0 or j == 0 or i == len(grid) -1 or j == len(grid[0]) - 1:
                    fill(grid, i, j)

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 0:
                    ans += 1
                    fill(grid, i, j)
        return ans

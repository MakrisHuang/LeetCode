class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        res = 0
        for i in range(0, len(grid)):
            for j in range(0, len(grid[0])):
                if grid[i][j] == "1":
                    res += 1
                    self.dfs(grid, i, j)
        return res

    def dfs(self, grid, i, j):
        if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]):
            return
        if grid[i][j] == "0":
            return
        else:
            grid[i][j] = "0"
            self.dfs(grid, i - 1, j)
            self.dfs(grid, i, j + 1)
            self.dfs(grid, i + 1, j)
            self.dfs(grid, i, j - 1)

class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        perimeter = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    perimeter += self.getUnitPerimeter(grid, i, j)
        return perimeter

    def getUnitPerimeter(self, grid: List[List[int]], i, j):
        count = 4
        if i - 1 >= 0 and grid[i - 1][j] == 1:
            count -= 1
        if j + 1 < len(grid[0]) and grid[i][j + 1] == 1:
            count -= 1
        if i + 1 < len(grid) and grid[i + 1][j] == 1:
            count -= 1
        if j - 1 >= 0 and grid[i][j - 1] == 1:
            count -= 1
        return count

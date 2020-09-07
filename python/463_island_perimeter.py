class Solution:
    def islandPerimeter_substract(self, grid: List[List[int]]) -> int:
        # calculate number of 1 to get perimeter
        perimeter = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    perimeter += 4
                    # check adjacent block and remove overlapping edge
                    for dx, dy in [[0, -1], [1, 0], [0, 1], [-1, 0]]:
                        x, y = i + dx, j + dy
                        if x >= 0 and x < len(grid) and y >= 0 and y < len(grid[0]) and grid[x][y] == 1:
                            perimeter -= 1
        return perimeter

    def islandPerimeter(self, grid: List[List[int]]) -> int:
        # calculate number of adjacent 0 to get perimeter
        perimeter = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    for dx, dy in [[0, -1], [1, 0], [0, 1], [-1, 0]]:
                        x, y = i + dx, j + dy
                        if x < 0 or x >= len(grid) or y < 0 or y >= len(grid[0]) or grid[x][y] == 0:
                            perimeter += 1
        return perimeter

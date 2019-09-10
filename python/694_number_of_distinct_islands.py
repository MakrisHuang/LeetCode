class Solution:
    # Time Complexity: O(N * M)
    # Space Complexity: O(N * M)
    def numDistinctIslands(self, grid: List[List[int]]) -> int:
        def dfs(grid: List[List[int]], i: int,  j: int, dir: int, shape: List[int]):
            if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]): return
            if grid[i][j] == 1:
                grid[i][j] = 0
                shape.append(dir)
                for index, direction in enumerate([[-1, 0], [0, 1], [1, 0], [0, -1]]):
                    next_i, next_j = i + direction[0], j + direction[1]
                    # use direction to reqpresent unique path of this island
                    dfs(grid, next_i, next_j, index + 1, shape)
                shape.append(0)

        uniques = set()
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                shape = []
                if grid[i][j] == 1:
                    dfs(grid, i, j, 0, shape)
                    if tuple(shape) not in uniques:
                        uniques.add(tuple(shape))
                    shape = []
        return len(uniques)

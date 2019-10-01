class Solution:
    # Time Complexity: O(m * n)
    # Space Complexity: O(m * n)
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        # apply dfs by propagating values from the end node
        def dfs(matrix, i, j, cache):
            if cache[i][j] != 0:   # indicates visited
                return cache[i][j]
            for dx, dy in [[-1, 0], [0, 1], [1, 0], [0, -1]]:
                x, y = i + dx, j + dy
                if 0 <= x < len(matrix) and 0 <= y < len(matrix[0]) and matrix[x][y] > matrix[i][j]:
                    cache[i][j] = max(cache[i][j], dfs(matrix, x, y, cache))

            cache[i][j] += 1
            return cache[i][j]

        if not matrix or not matrix[0]: return 0
        M, N = len(matrix), len(matrix[0])
        cache = [[0 for _ in range(N)] for _ in range(M)]
        ans = 0
        for i in range(M):
            for j in range(N):
                ans = max(ans, dfs(matrix, i, j, cache))
        return ans


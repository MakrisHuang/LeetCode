class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        # apply bfs
        q = collections.deque()
        q.append((0, 0, 1))
        M, N = len(grid), len(grid[0])
        if grid[0][0] == 1: return -1

        dirs = [[-1, -1], [-1, 0], [-1, 1], [0, -1], [0, 1], [1, -1], [1, 0], [1,1]]
        visited = [[False for _ in range(N)] for _ in range(M)]
        visited[0][0] = True

        while q:
            curr_x, curr_y, steps = q.popleft()

            if curr_x == M - 1 and curr_y == N - 1:
                return steps

            for dx, dy in dirs:
                x, y = curr_x + dx, curr_y + dy
                if 0 <= x < M and 0 <= y < N and not visited[x][y] and grid[x][y] == 0:
                    q.append((x, y, steps + 1))
                    visited[x][y] = True

        return -1


class Solution:
    def pacificAtlantic(self, matrix: List[List[int]]) -> List[List[int]]:
        # apply bfs from a border to another border
        def bfs(q, matrix: List[List[int]], visited: List[List[bool]]):
            n, m = len(matrix), len(matrix[0])
            while q:
                i, j = q.popleft()
                for dx, dy in [(-1, 0), (0, 1), (1, 0), (0, -1)]:
                    x, y = i + dx, j + dy
                    if x < 0 or x >= n or y < 0 or y >= m or visited[x][y] or matrix[x][y] < matrix[i][j]:
                        continue
                    visited[x][y] = True
                    q.append((x, y))


        if not matrix or not matrix[0]:
            return []
        N, M = len(matrix), len(matrix[0])
        pacific_visited = [[False for _ in range(M)] for _ in range(N)]
        atlantic_visited = [[False for _ in range(M)] for _ in range(N)]
        pacific_q = collections.deque()
        atlantic_q = collections.deque()
        for j in range(M):  # horizontal border
            pacific_visited[0][j] = True
            atlantic_visited[N - 1][j] = True
            pacific_q.append((0, j))
            atlantic_q.append((N - 1, j))

        for i in range(N): # vertical border
            pacific_visited[i][0] = True
            atlantic_visited[i][M - 1] = True
            pacific_q.append((i, 0))
            atlantic_q.append((i, M - 1))

        bfs(pacific_q, matrix, pacific_visited)
        bfs(atlantic_q, matrix, atlantic_visited)

        res = []
        for i in range(N):
            for j in range(M):
                if pacific_visited[i][j] and atlantic_visited[i][j]:
                    res.append([i, j])
        return res



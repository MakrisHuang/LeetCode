class Solution:
    def allCellsDistOrder(self, R: int, C: int, r0: int, c0: int) -> List[List[int]]:
        """
        0 0 0
        1 0 1
        0 1 0
        """
        q = collections.deque()
        q.append((r0, c0))

        res = []
        visited = [[False for _ in range(C)] for _ in range(R)]
        while q:
            i, j = q.popleft()
            if visited[i][j]:
                continue
            visited[i][j] = True

            res.append([i, j])

            for dx, dy in [[-1, 0], [0, 1], [1, 0], [0, -1]]:
                x, y = i + dx, j + dy
                if 0 <= x < R and 0 <= y < C and not visited[x][y]:
                    q.append((x, y))
        return res

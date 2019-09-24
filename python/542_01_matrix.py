class Solution:
    # Time Complexity: O(m * n)
    # Space Complexity: O(1)
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        # apply bfs search for each 0 cell
        q = collections.deque()
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 0:
                    q.append((i, j))
                else:
                    matrix[i][j] = float('inf')

        M, N = len(matrix), len(matrix[0])
        while q:
            x, y = q.popleft()
            next_val = matrix[x][y] + 1

            for dx, dy in [[-1, 0], [0, 1], [1, 0], [0, -1]]:
                next_x, next_y = x + dx, y + dy
                if 0 <= next_x < M and 0 <= next_y < N and matrix[next_x][next_y] > next_val:
                    q.append((next_x, next_y))
                    matrix[next_x][next_y] = next_val
        return matrix

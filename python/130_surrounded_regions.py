class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # since we know that any node connected by the border won't be changed into "X"
        # so we can traverse from any O in the border and mark the connected ones as non-changable (visited)
        # after that, flip all unvisited O (within the border) into X

        def dfs(board: List[List[str]], i: int, j: int, visited: List[List[bool]], M: int, N: int):
            if i < 0 or i >= M or j < 0 or j >= N: return
            if board[i][j] == "O" and not visited[i][j]:
                visited[i][j] = True
                for dx, dy in [[0, -1], [1, 0], [0, 1], [-1, 0]]:
                    x, y = i + dx, j + dy
                    dfs(board, x, y, visited, M, N)

        if not board or not board[0]: return
        M, N = len(board), len(board[0])
        visited = [[False for j in range(N)] for i in range(M)]
        # first and last row
        for i in [0, M - 1]:
            for j in range(N):
                dfs(board, i, j, visited, M, N)
        # first and last column
        for i in range(1, M - 1):
            for j in [0, N - 1]:
                dfs(board, i, j, visited, M, N)
        # flip the non-visited ones into "X"
        for i in range(1, M - 1):
            for j in range(1, N - 1):
                if board[i][j] == "O" and not visited[i][j]:
                    board[i][j] = "X"


class Solution:
    # Time Complexity: O(mn), Space Complexity: O(1)
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # specify the transition { dead -> alive } as 2
        # the transition from { alive -> dead } as -1
        # no changes will be made if the cell keeps the same status
        M, N = len(board), len(board[0])
        for i in range(M):
            for j in range(N):
                dead, alive = 0, 0
                for dx, dy in [[-1,-1], [0, -1], [1, -1], [-1, 0], [1, 0], [-1, 1], [0, 1], [1, 1]]:
                    x, y = i + dx, j + dy
                    if x >= 0 and x < M and y >= 0 and y < N:
                        if board[x][y] == 0 or board[x][y] == 2:
                            dead += 1
                        elif board[x][y] == 1 or board[x][y] == -1:
                            alive += 1
                if board[i][j] == 1 and (alive < 2 or alive > 3):  # alive -> dead
                    board[i][j] = -1
                elif board[i][j] == 0 and (alive == 3): # dead -> alive
                    board[i][j] = 2
        for i in range(M):
            for j in range(N):
                if board[i][j] == 2:
                    board[i][j] = 1
                elif board[i][j] == -1:
                    board[i][j] = 0


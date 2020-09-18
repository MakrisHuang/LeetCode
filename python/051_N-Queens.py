class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        board = [['.' for _ in range(n)] for _ in range(n)]
        res = []
        self.backtrace(board, 0, res)
        return res

    def backtrace(self, board: List[List[str]], row: int, res: List[List[str]]):
        if row == len(board):
            ans = ["".join(row) for row in board]
            res.append(ans)
            return
        N = len(board[row])
        for col in range(N):
            if not self.isValid(board, row, col):
                continue
            board[row][col] = 'Q'
            self.backtrace(board, row + 1, res)
            board[row][col] = '.'

    def isValid(self, board: List[List[str]], row: int, col: int) -> bool:
        # check upper vertical direction
        for i in range(row - 1, -1, -1):
            if board[i][col] == 'Q': return False
        # check upper right corner
        i, j = row - 1, col + 1
        while i >= 0 and j < len(board[0]):
            if board[i][j] == 'Q': return False
            i -= 1
            j += 1
        p, q = row - 1, col - 1
        while p >= 0 and q >= 0:
            if board[p][q] == 'Q': return False
            p -= 1
            q -= 1
        return True

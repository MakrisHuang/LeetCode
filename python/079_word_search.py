class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        def dfs(board: List[List[str]], i: int, j: int, word: str) -> bool:
            if len(word) == 0: return True
            if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]) or board[i][j] != word[0]:
                return False
            res = False
            board[i][j] = '#'
            for dx, dy in [[-1, 0], [0, 1], [1, 0], [0, -1]]:
                x, y = i + dx, j + dy
                res = dfs(board, x, y, word[1:])
                if res: break
            board[i][j] = word[0]
            return res

        if not board or not board[0]: return False
        for i in range(len(board)):
            for j in range(len(board[0])):
                if dfs(board, i, j, word):
                    return True
        return False

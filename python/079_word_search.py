class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        for i in range(len(board)):
            for j in range(len(board[0])):
                if self.dfs(board, word, 0, i, j):
                    return True
        return False

    def dfs(self, board: List[List[str]], word: str, word_idx: int, i: int, j: int) -> bool:
        if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]):
            return False

        res = False
        if board[i][j] == word[word_idx]:
            word_idx += 1
            if word_idx == len(word):
                return True

            temp = board[i][j]
            board[i][j] = '#'
            res = self.dfs(board, word, word_idx, i - 1, j) or self.dfs(board, word, word_idx, i, j + 1) \
                or self.dfs(board, word, word_idx, i + 1, j) or self.dfs(board, word, word_idx, i, j - 1)
            board[i][j] = temp
        return res


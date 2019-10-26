class TrieNode:
    def __init__(self):
        self.children = [None for _ in range(26)]
        self.word = None

class Solution:
    def buildTree(self, words: List[str]) -> TrieNode:
        root = TrieNode()
        for word in words:
            curr = root
            for c in word:
                index = ord(c) - ord('a')
                if not curr.children[index]:
                    curr.children[index] = TrieNode()
                curr = curr.children[index]
            curr.word = word
        return root

    def dfs(self, board: List[List[str]], res: List[str], root: TrieNode, i: int, j: int) -> None:
        c = board[i][j]
        if c == '#' or not root.children[ord(c) - ord('a')]:
            return

        root = root.children[ord(c) - ord('a')]
        if root.word:
            res.append(root.word)
            root.word = None

        temp = board[i][j]
        board[i][j] = '#'
        if i - 1 >= 0: self.dfs(board, res, root, i - 1, j)
        if i + 1 < len(board): self.dfs(board, res, root, i + 1, j)
        if j - 1 >= 0: self.dfs(board, res, root, i, j - 1)
        if j + 1 < len(board[0]): self.dfs(board, res, root, i, j + 1)

        board[i][j] = temp

    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        root = self.buildTree(words)
        res = []
        for i in range(len(board)):
            for j in range(len(board[0])):
                self.dfs(board, res, root, i, j)
        return res

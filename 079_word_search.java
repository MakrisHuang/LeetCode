class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, 0, word, i, j)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int wordIdx, String word, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }

        boolean result = false;
        if (board[i][j] == word.charAt(wordIdx)) {
            wordIdx++;
            if (wordIdx == word.length()) {
                return true;
            }
            char temp = board[i][j];
            board[i][j] = '#';
            result = dfs(board, wordIdx, word, i - 1, j) || dfs(board, wordIdx, word, i + 1, j) ||
                    dfs(board, wordIdx, word, i, j - 1) || dfs(board, wordIdx, word, i, j + 1);
            board[i][j] = temp;
        }
        return result;
    }
}

class Solution {
    public void gameOfLife(int[][] board) {

        // Follow-up: in-place -> can use multiple codes to represent different living status
        int rows = board.length, cols = board[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = (nextStatus(board, i, j) == true) ? 1 : 0;
            }
        }

        for (int p = 0; p < rows; p++) {
            for (int q = 0; q < cols; q++) {
                board[p][q] = result[p][q];
            }
        }
    }

    private int numOfNeis(int[][] board, int i, int j) {
        int rows = board.length, cols = board[0].length;
        int numOfNei = 0;
        if (i - 1 >= 0 && j - 1 >= 0) {
            numOfNei += (board[i - 1][j - 1] == 1) ? 1 : 0;
        }
        if (i - 1 >= 0) {
            numOfNei += (board[i - 1][j] == 1) ? 1 : 0;
        }
        if (i - 1 >= 0 && j + 1 < cols) {
            numOfNei += (board[i - 1][j + 1] == 1) ? 1 : 0;
        }
        if (j + 1 < cols) {
            numOfNei += (board[i][j + 1] == 1) ? 1 : 0;
        }
        if (i + 1 < rows && j + 1 < cols) {
            numOfNei += (board[i + 1][j + 1] == 1) ? 1 : 0;
        }
        if (i + 1 < rows) {
            numOfNei += (board[i + 1][j] == 1) ? 1 : 0;
        }
        if (i + 1 < rows && j - 1 >= 0) {
            numOfNei += (board[i + 1][j - 1] == 1) ? 1 : 0;
        }
        if (j - 1 >= 0) {
            numOfNei += (board[i][j - 1] == 1) ? 1 : 0;
        }
        return numOfNei;
    }

    private boolean nextStatus(int[][] board, int i, int j) {
        if (board[i][j] == 1) {
            int neighbors = numOfNeis(board, i, j);
            if (neighbors < 0) return false;
            else if (neighbors == 2 || neighbors == 3) return true;
            else return false;
        } else {
            if (numOfNeis(board, i, j) == 3) {
                return true;
            }
            return false;
        }
    }
}

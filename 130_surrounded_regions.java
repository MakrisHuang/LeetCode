class Solution {
    // dealing with first/last row and first/last column to change them from O to *
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        if (board.length < 2 || board[0].length < 2)
            return;
        int m = board.length, n = board[0].length;
        //Any 'O' connected to a boundary can't be turned to 'X', so ...
        //Start from first and last column, turn 'O' to '*'.
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                boundaryDFS(board, i, 0);
            if (board[i][n-1] == 'O')
                boundaryDFS(board, i, n-1);
        }
        //Start from first and last row, turn '0' to '*'
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O')
                boundaryDFS(board, 0, j);
            if (board[m-1][j] == 'O')
                boundaryDFS(board, m-1, j);
        }
        //post-prcessing, turn 'O' to 'X', '*' back to 'O', keep 'X' intact.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
    }
    //Use DFS algo to turn internal however boundary-connected 'O' to '*';
    private void boundaryDFS(char[][] board, int i, int j) {
        if (i < 0 || i > board.length - 1 || j <0 || j > board[0].length - 1)
            return;
        if (board[i][j] == 'O')
            board[i][j] = '*';
        if (i > 1 && board[i-1][j] == 'O')
            boundaryDFS(board, i-1, j);
        if (i < board.length - 2 && board[i+1][j] == 'O')
            boundaryDFS(board, i+1, j);
        if (j > 1 && board[i][j-1] == 'O')
            boundaryDFS(board, i, j-1);
        if (j < board[i].length - 2 && board[i][j+1] == 'O' )
            boundaryDFS(board, i, j+1);
    }
//     public void solve(char[][] board) {
//         if (board == null || board.length == 0 || board[0].length == 0) return;
//         int M = board.length, N = board[0].length;
//         for (int i = 1; i < M - 1; i++) {
//             for (int j = 1; j < N - 1; j++) {
//                 System.out.println("i = " + i + ", j = " + j);
//                 flip(board, M, N, i, j);
//             }
//         }
//     }

//     public void flip(char[][] board, int M, int N, int i, int j) {
//         if (i <= 0 || i >= M - 1 || j <= 0 || j >= N - 1) {
//             return;
//         }
//         if (board[i][j] == 'O' && !((isBoard(M, N, i - 1, j) && board[i - 1][j] == 'O') ||
//                                     (isBoard(M, N, i, j + 1) && board[i][j + 1] == 'O') ||
//                                     (isBoard(M, N, i + 1, j) && board[i + 1][j] == 'O') ||
//                                     (isBoard(M, N, i, j - 1) && board[i][j - 1] == 'O'))) {
//             board[i][j] = 'X';
//             flip(board, M, N, i - 1, j);
//             flip(board, M, N, i, j + 1);
//             flip(board, M, N, i + 1, j);
//             flip(board, M, N, i, j - 1);
//         }
//     }

//     private boolean isBoard(int M, int N, int i, int j) {
//         if (i <= 0 || i >= M - 1 || j <= 0 || j >= N - 1) {
//             return true;
//         }
//         return false;
//     }
}

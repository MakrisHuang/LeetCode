class Solution {
    // Time Complexity: C(m + n, m), Space Complexity: O(m * n)
    public int uniquePaths(int m, int n) {
       int[][] mat = new int[m + 1][n + 1];
       mat[m - 1][n] = 1;
       for (int r = m - 1; r >= 0; r--) {
          for (int c = n - 1; c >= 0; c--) {
             mat[r][c] = mat[r + 1][c] + mat[r][c + 1];
          } 
       }
       return mat[0][0];
    }
    
    // TLE
//     public int uniquePaths(int m, int n) {
//         int[][] dp = new int[m][n];
//         dp[0][0] = 1;
//         backtrace(dp, 0, 0, m, n);
//         return dp[m - 1][n - 1];
//     }
    
//     public void backtrace(int[][] dp, int i, int j, int rows, int cols) {
//         if (i < 0 || j < 0 || i >= rows || j >= cols) {
//             return;
//         }
//         if (i - 1 >= 0 && j == 0) {
//             dp[i][j] = dp[i - 1][j];
//         }
//         if (i == 0 && j - 1 >= 0) {
//             dp[i][j] = dp[i][j - 1];
//         }
//         if (i - 1 >= 0 && j - 1 >= 0) {
//             dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//         }
//         backtrace(dp, i + 1, j, rows, cols);
//         backtrace(dp, i, j + 1, rows, cols);
//     }
}
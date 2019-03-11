class Solution {
    // Time Complexity: O(N^2 * K)
    // Space Complexity: O(N^2 * K)
    public double knightProbability(int N, int K, int r, int c) {
        double moves = 0;
        double[][][] dp = new double[N][N][K + 1];
        // initialization
        dp[r][c][0] = 1.0;

        for (int step = 1; step <= K; step++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i - 2 >= 0 && j + 1 < N) {
                        dp[i][j][step] += dp[i - 2][j + 1][step - 1] / 8;
                    }
                    if (i - 1 >= 0 && j + 2 < N) {
                        dp[i][j][step] += dp[i - 1][j + 2][step - 1] / 8;
                    }
                    if (i + 1 < N && j + 2 < N) {
                        dp[i][j][step] += dp[i + 1][j + 2][step - 1] / 8;
                    }
                    if (i + 2 < N && j + 1 < N) {
                        dp[i][j][step] += dp[i + 2][j + 1][step - 1] / 8;
                    }
                    if (i + 2 < N && j - 1 >= 0) {
                        dp[i][j][step] += dp[i + 2][j - 1][step - 1] / 8;
                    }
                    if (i + 1 < N && j - 2 >= 0) {
                        dp[i][j][step] += dp[i + 1][j - 2][step - 1] / 8;
                    }
                    if (i - 1 >= 0 && j - 2 >= 0) {
                        dp[i][j][step] += dp[i - 1][j - 2][step - 1] / 8;
                    }
                    if (i - 2 >= 0 && j - 1 >= 0) {
                        dp[i][j][step] += dp[i - 2][j - 1][step - 1] / 8;
                    }
                    // System.out.println("dp[" + i + "][" + j + "][" + step + "] = " + dp[i][j][step]);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                moves += dp[i][j][K];
            }
        }
        return moves;
    }
}

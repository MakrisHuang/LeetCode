class Solution {
    // Time Complexity: O(N^2 * K)
    // Space Complexity: O(N^2 * K)
    public double knightProbability(int N, int K, int r, int c) {
        double moves = 0;
        double[][][] dp = new double[N][N][K + 1];
        int[] dr = new int[] {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dc = new int[] {1, 2, 2, 1, -1, -2, -2, -1};

        // initialization
        dp[r][c][0] = 1.0;

        for (int step = 1; step <= K; step++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int d = 0; d < 8; d++) {
                        int cr = i + dr[d];
                        int cc = j + dc[d];
                        if (cr >= 0 && cr < N && cc >= 0 && cc < N) {
                            dp[i][j][step] += dp[cr][cc][step - 1] / 8;
                        }
                    }
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

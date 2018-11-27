class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int max = n * n, start = 1;
        int M = n, N = n;
        int row = 0, col = -1;
        while (start <= max) {
            // move right
            for (int i = 0; i < N; i++) {
                res[row][++col] = start++;
            }
            if (--M == 0) break;

            // move down
            for (int i = 0; i < M; i++) {
                res[++row][col] = start++;
            }
            if (--N == 0) break;

            // move left
            for (int i = 0; i < N; i++) {
                res[row][--col] = start++;
            }
            if (--M == 0) break;

            // move up
            for (int i = 0; i < M; i++) {
                res[--row][col] = start++;
            }
            if (--N == 0) break;
        }
        return res;
    }
}

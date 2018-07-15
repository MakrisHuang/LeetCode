class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        int len = A.length;
        double[] P = new double[len + 1];
        for (int i = 0; i < len; ++i) {
            P[i + 1] = P[i] + A[i];
        }

        double[] dp = new double[len];
        for (int i = 0; i < len; ++i) {
            dp[i] = (P[len] - P[i]) / (len - i);
        }

        for (int k = 0; k < K - 1; ++k) {
            for (int i = 0; i < len; ++i) {
                for (int j = i + 1; j < len; ++j) {
                    dp[i] = Math.max(dp[i], (P[j] - P[i]) / (j - i) + dp[j]);
                }
            }
        }

        return dp[0];
    }
}

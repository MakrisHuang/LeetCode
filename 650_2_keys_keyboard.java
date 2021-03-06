class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        dp[0] = -1;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            // check it is prime. If not, find the largest factor
            int largestFactor = 1;
            for (int factor = i - 1; factor >= 1; factor--) {
                if (i % factor == 0 && factor > largestFactor) {
                    largestFactor = factor;
                    break;
                }
            }
            if (largestFactor != 1) {   // not a prime
                // dp[largestFactor]: 最大因數組合次數
                // i / largestFactor: copy dp[largestFactor] 所需要的複製次數
                // 因此是相加
                dp[i] = dp[largestFactor] + (int)(i / largestFactor);
            } else {
                dp[i] = i;
            }
        }

        return dp[n];
    }
}

class Solution {
    public int minCost(int[][] costs) {
        int[][] dp = new int[costs.length + 1][3];
        int houses = costs.length;
        for (int i = 1; i <= houses; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i - 1][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i - 1][1];
            dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + costs[i - 1][2];
        }
        return Math.min(dp[costs.length][0], Math.min(dp[costs.length][1], dp[costs.length][2]));
    }
}

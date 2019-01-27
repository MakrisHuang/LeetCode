class Solution {
    // Time Complexity: O(len(coins) * amount)
    // Space Complexity: O(1)
    public int change(int amount, int[] coins) {
        int [] dp = new int [amount + 1];
        dp[0] = 1;
        for (int coin: coins) {
            for (int i = 1; i < dp.length; i++) {
                if (i >= coin) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }
}

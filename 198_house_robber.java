class Solution {
    public int rob(int[] nums) {
        int [][]dp = new int[nums.length + 1][2];
        for (int i = 1; i <= nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]); // 比較不搶和搶的獲利
            dp[i][1] = nums[i - 1] + dp[i - 1][0]; // 前一間搶 + 前一間不搶的最大獲利
        }
        return Math.max(dp[nums.length][0], dp[nums.length][1]);
    }
}

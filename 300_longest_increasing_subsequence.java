class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            int pos = Arrays.binarySearch(dp, 0, len, nums[i]);
            if (pos < 0) {
                pos = -(pos + 1);
                dp[pos] = nums[i];
                if (pos == len) {
                    len++;
                }
            }
        }
        return len;
    }
}

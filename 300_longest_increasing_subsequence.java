class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // use dynamic programming (only memorization here)
        // for faster solution, use binary search
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int maxLen = 1;
        for (int i = 1; i < len; i++) {
            int currMax = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    currMax = Math.max(currMax, dp[j]);
                }
            }
            dp[i] = currMax + 1;    // confirm that we encounter this character
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    // follow up: improve time complexity with O(nlogn) by using binary search
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

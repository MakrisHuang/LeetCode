class Solution {
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int pivotIndex(int[] nums) {
        // 先排除個數為1的
        if (nums == null || nums.length == 0) return -1;

        // 初始化使兩邊為0
        int leftSum = 0, rightSum = 0;
        // 讓 rightSum 從 index = 1 開始累加
        for (int i = 1; i < nums.length; i++) {
            rightSum += nums[i];
        }

        int ans = 0;
        while (ans < nums.length) {
            if (leftSum == rightSum) return ans;
            leftSum += nums[ans];   // 增加左邊元素
            ans++;
            if (ans < nums.length) {    // 由於 ans++，需檢查這邊
                rightSum -= nums[ans];  // 移除 rightSum 最左邊的元素
            }

        }
        return -1;
    }
}

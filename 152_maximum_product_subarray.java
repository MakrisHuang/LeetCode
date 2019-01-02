class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int max = nums[0], min = nums[0], maxAns = nums[0];

        /*
        考慮有正有負的情況，必須設定 max, min。當 A[i] < 0 時，
        max, min 會交換（因為大數 * 負數 => 變小；小數 * 負數 => 變大）
        */
        for (int i = 1; i < nums.length; i++) {
            int mx = max, mn = min;
            max = Math.max(Math.max(nums[i], mx * nums[i]), mn * nums[i]);
            min = Math.min(Math.min(nums[i], mx * nums[i]), mn * nums[i]);
            maxAns = Math.max(max, maxAns);
        }
        return maxAns;
    }
}

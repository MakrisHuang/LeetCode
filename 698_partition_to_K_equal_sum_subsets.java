class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return false;
        Arrays.sort(nums);
        int sum = 0;
        for (int n: nums) sum += n;
        if (sum % k != 0 || sum < k) return false;
        sum /= k;
        return partition(sum, new int[k], nums, nums.length - 1);
    }

    private boolean partition(int sum, int[] accumulates, int[] nums, int idx){
        if (idx == -1) {
            // examine each accumulation equals to sum or not
            for (int s: accumulates) if (s != sum) return false;
            return true;
        }
        int num = nums[idx];
        for (int i = 0; i < accumulates.length; i++) {
            if (accumulates[i] + num <= sum) {
                accumulates[i] += num;
                if (partition(sum, accumulates, nums, idx - 1)) return true;
                accumulates[i] -= num;
            }
        }
        return false;
    }
}

class Solution {
    // Time Complexity: O(n^2)
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            int sum = 0;
            for (int val: nums) sum += val;
            return sum;
        }

        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                    if (target == ans) return ans;
                }
                if (sum > target) {
                    hi--;
                } else {
                    lo++;
                }
            }
        }
        return ans;
    }
}

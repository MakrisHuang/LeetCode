class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int lo = i + 1, hi = nums.length - 1, diff = target - nums[i];
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (nums[mid] == diff) {
                    return new int[] {i + 1, mid + 1};
                } else if (nums[mid] > diff) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return null;
    }
}

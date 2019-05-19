class Solution {
    // Time Complexity: O(nlogn + n^2 * logn) = O(n^2 * logn)
    // Space Complexity: O(1)
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            // if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 1; j++) {
                // if (j > 0 && nums[j] == nums[j - 1]) continue;
                int lo = j + 1, hi = nums.length - 1;
                while (lo <= hi) {
                    int mid = lo + (hi - lo) / 2;
                    int sum = nums[i] + nums[j] + nums[mid];
                    closest = (Math.abs(sum - target) < Math.abs(closest - target)) ? sum : closest;

                    if (sum == target) {
                        return sum;
                    } else if (sum > target) {
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                }
            }
        }
        return closest;
    }
}

class Solution {
    // Time Complexity: O(n ^ 3)
    // Space Complexity: O( C(n, 4) ) => O(n ^ 3)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) return res;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            if (nums[i] * 4 > target) break;    // too large
            if (nums[i] + 3 * nums[nums.length - 1] < target) continue; // too small

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) continue;

                if (nums[j] * 3 > target - nums[i]) break;  // too large
                if (nums[j] + 2 * nums[nums.length - 1] < target - nums[i]) continue; // too small

                int low = j + 1, high = nums.length - 1, sum = target - nums[i] - nums[j];

                while (low < high) {
                    int currSum = nums[low] + nums[high];
                    if (currSum == sum) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));

                        low++;
                        high--;
                        while (low < high && nums[low - 1] == nums[low]) low++;
                        while (low < high && nums[high] == nums[high + 1]) high--;
                    } else if (currSum < sum) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return res;
    }
}

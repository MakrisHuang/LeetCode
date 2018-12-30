class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;  // skip duplicated

            int low = i + 1, high = nums.length - 1, sum = 0 - nums[i];
            while (low < high) {
                int currSum = nums[low] + nums[high];
                if (currSum == sum) {
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;      // move forward
                    high--;     // move backward

                    // prevent duplicate elements
                    while (low < high && nums[low - 1] == nums[low]) low++;
                    while (low < high && nums[high] == nums[high + 1]) high--;
                } else if (currSum < sum) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return res;
    }
}

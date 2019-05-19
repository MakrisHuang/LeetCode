class Solution {
    // Time Complexity: O(n * twoSumSmalller) = O(n ^ 2)
    // Space Complexity: O(1)
    public int threeSumSmaller(int[] nums, int target) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            sum += twoSumSmaller(nums, i + 1, target - nums[i]);
        }
        return sum;
    }

    // Time Complexity: O(n) (because two pointer with n steps)
    // Space Complexity: O(1)
    private int twoSumSmaller(int[] nums, int startIdx, int target) {
        int sum = 0;
        int left = startIdx, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                sum += right - left;
                left++;
            } else {
                right--;
            }
        }
        return sum;
    }
}

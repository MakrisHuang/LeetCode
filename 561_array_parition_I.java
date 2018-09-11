class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for (int leftIdx = 0; leftIdx < nums.length; leftIdx += 2) {
            max += nums[leftIdx];
        }
        return max;
    }
}

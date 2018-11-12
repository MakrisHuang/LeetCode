class Solution {
    public int removeDuplicates(int[] nums) {
        int dupIdx = 0, origIdx = 0;
        while (dupIdx < nums.length) {
            while (dupIdx + 1 < nums.length &&
                   nums[dupIdx] == nums[dupIdx + 1]) {
                dupIdx++;
            }
            nums[origIdx++] = nums[dupIdx];
            dupIdx++;
        }
        return origIdx;
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n: nums) {
            // i < 2: cover lower cases
            // n > nums[i - 2]: if the current num is not equal, then assign current n to nums[i]
            // then increase i
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;
        }
        return i;
    }
}
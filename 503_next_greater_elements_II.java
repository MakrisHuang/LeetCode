class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            // search for all next greater number circularly
            int greater = Integer.MIN_VALUE;
            for (int start = i + 1; start < nums.length; start++) {
                if (nums[start] > num && greater == Integer.MIN_VALUE) {
                    greater = nums[start];
                    break;
                }
            }
            for (int start = 0; start < i; start++) {
                if (nums[start] > num && greater == Integer.MIN_VALUE) {
                    greater = nums[start];
                    break;
                }
            }
            res[i] = (greater == Integer.MIN_VALUE) ? -1 : greater;
        }
        return res;
    }
}

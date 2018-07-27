class Solution {
//     public void rotate(int[] nums, int k) {
//         int len = nums.length;
//         k = k % len;
//         if (k == 0) return;

//         for (int moveIdx = len - k, origIdx = 0; moveIdx < len; moveIdx++, origIdx++) {
//             int temp = nums[moveIdx];
//             for (int i = moveIdx - 1; i >= origIdx; i--) {
//                 nums[i + 1] = nums[i];
//             }
//             nums[origIdx] = temp;
//         }
//     }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

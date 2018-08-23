class Solution {
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 1) {
                if (nums[i - 1] > nums[i]) swap(nums, i);
            } else if (i != 0 && nums[i - 1] < nums[i]) swap(nums, i);
        }

//         int len = nums.length;
//         if (len == 1) return;

//         Arrays.sort(nums);
//         int[] res = new int[len];
//         int start = 0, end = len - 1, idx = 0;
//         while (start <= end && idx < len) {
//             res[idx++] = nums[start++];
//             if (idx >= len) break;
//             res[idx++] = nums[end--];
//         }

//         for (int i = 0; i < len; i++) {
//             nums[i] = res[i];
//         }
    }

    private void swap(int[] nums, int i) {
        int temp = nums[i];
        nums[i] = nums[i - 1];
        nums[i - 1] = temp;
    }
}

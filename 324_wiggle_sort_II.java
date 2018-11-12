class Solution {
    // L L M M S S
    // re-arrange:
    // M S S
    //  L L M
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        // handle M S S
        int lastIdx = (len % 2 == 0 ? len - 2 : len - 1);
        for (int j = 0, i = lastIdx; i >= 0; i -= 2, j++) {
            nums[i] = sorted[j];
        }
        // handle L L M
        for (int j = len - 1, i = 1; i < nums.length; i += 2, j--) {
            nums[i] = sorted[j];
        }
    }
}
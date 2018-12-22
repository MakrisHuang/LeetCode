class Solution {
    public int findDuplicate(int[] nums) {
        int hi = nums.length - 1, lo = 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0;
            for (int val: nums) {
                if (val <= mid) {   // compare index ??
                    count++;
                }
            }

            if (count <= mid) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}

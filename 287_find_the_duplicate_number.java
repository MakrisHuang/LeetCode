class Solution {
    // Use binary search and pigeonhole theory
    // ex. nums = [2,3,4,5,6,7,1,1,1,1], low = 1, high = 9, mid = 5
    // counting num <= 5 is 8, which means there are duplications below 5
    // so search with (low, mid), otherwise search (mid + 1, hi)

    // not searching index, but value
    public int finDuplicate(int[] nums) {
        int hi = nums.length - 1, lo = 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0;
            for (int val: nums) {
                if (val <= mid) {
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

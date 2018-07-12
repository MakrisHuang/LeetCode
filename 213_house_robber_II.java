class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        // 可以想成是排除掉某兩個 consecutive houses 都沒有搶，然後去比較這兩種 cases 下搶房子的最大利潤
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int lo, int hi) {
        int include = 0, exclude = 0;
        for (int j = lo; j <= hi; j++) {
            int i = include, e = exclude;
            include = e + nums[j];
            exclude = Math.max(e, i);
        }
        return Math.max(include, exclude);
    }
}

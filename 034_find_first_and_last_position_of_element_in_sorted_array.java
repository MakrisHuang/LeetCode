class Solution {
    public int findLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // eventually right will be smaller than left to break the loop
        return left;
    }

    public int findRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {  // <= for remove duplicate values
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // eventually left will be larger than right to break the loop
        return right;
    }

    public int[] searchRange(int[] nums, int target) {
        int left = findLeft(nums, target);
        int right = findRight(nums, target);
        if (left <= right) {
            return new int[] {left, right};
        } else {
            return new int[] {-1, -1};
        }
    }
}

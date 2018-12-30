iclass Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid;
            } else if (nums[mid] < target){
                low = mid + 1;
            } else {
                low = mid;
                break;
            }
        }
        while (low > 1 && nums[low] == nums[low - 1]) {
            low--;
        }
        return (nums[low] < target) ? nums.length: low;
        // int result = -1;
        // for (int i = 0; i < nums.length; i++){
        //     if (target <= nums[i]){
        //         result = i;
        //         break;
        //     }
        // }
        // if (result == -1) result = nums.length;
        // return result;
    }
}

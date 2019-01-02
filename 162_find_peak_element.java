class Solution {
    // Version 3: binary search by pruning left or right part
    public int findPeakElement(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    public int binarySearch(int[] nums, int l, int r) {
        if (l == r) {
            return l;
        }
        int mid = l + (r - l) / 2;
        if (nums[mid] > nums[mid + 1]) {
            return binarySearch(nums, l, mid);
        } else {
            return binarySearch(nums, mid + 1, r);
        }
    }

    // Version 2: linear scan with clean code
    // public int findPeakElement(int[] nums) {
    //     for (int i = 0; i < nums.length - 1; i++) {
    //         if (nums[i] > nums[i + 1]) {
    //             return i;
    //         }
    //     }
    //     return nums.length - 1; // not find -> it's a ascending slope, return the last one
    // }

    // Version 1: linear scan, but not clean
    // public int findPeakElement(int[] nums) {
    //     if (nums.length < 2 || nums == null) return 0;
    //     if (nums.length == 2){
    //         return (nums[0] > nums[1]) ? 0 : 1;
    //     }
    //     int index = 0;
    //     for (int i = 0; i < nums.length; i++){
    //         if (i == 0){
    //             if (nums[i] > nums[i + 1]) {
    //                 index = i;
    //                 break;
    //             }
    //         }
    //         else if (i == nums.length - 1){
    //             if (nums[i] > nums[i - 1]) {
    //                 index = i;
    //                 break;
    //             }
    //         }
    //         else{
    //             if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]){
    //                 index = i;
    //                 break;
    //             }
    //         }
    //     }
    //     return index;
    // }
}

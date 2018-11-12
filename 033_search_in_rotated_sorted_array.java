class Solution {
    public int search(int[] nums, int target) {
        int offset = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] < nums[offset]){
                offset = i;
                break;
            }
        }

        Arrays.sort(nums);
        int low = 0, high = nums.length - 1, mid;
        while(low <= high){
            mid = (low + high) / 2;
            if (target < nums[mid]){
                high = mid - 1;
            }else if (target > nums[mid]){
                low = mid + 1;
            }else{
                int index = mid - (nums.length - offset);
                if (index < 0) index = nums.length + index;
                return index;
            }
        }
        return -1;
    }
}

class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length < 2 || nums == null) return 0;
        if (nums.length == 2){
            return (nums[0] > nums[1]) ? 0 : 1;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++){
            if (i == 0){
                if (nums[i] > nums[i + 1]) {
                    index = i;
                    break;
                }
            }
            else if (i == nums.length - 1){
                if (nums[i] > nums[i - 1]) {
                    index = i;
                    break;
                }
            }
            else{
                if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]){
                    index = i;
                    break;
                }
            }
        }
        return index;
    }
}
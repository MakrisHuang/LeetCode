class Solution {
    public int[] productExceptSelf(int[] nums) {
        int pivot = 1;
        int len = nums.length;
        int result[] = new int[len];
        for (int i = 0; i < len; i++){
            result[i] = pivot;
            pivot *= nums[i];
        }

        pivot = 1;
        // backtrace from end of output
        for (int j = len - 1;j >= 0; j--){
            result[j] *= pivot;
            pivot *= nums[j];
        }
        return result;
    }
}

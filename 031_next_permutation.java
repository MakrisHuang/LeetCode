class Solution {
    // Time Complexity: O(n). 
    // In worst case, only two scans of the whole array are needed.
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        
        if (i >= 0) {
            // find the one who is larger the nums[i]
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) { // if smaller, keep going until find the one who is larger
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);   // reverse the remaining part for next permutation
    }
    
    // reverse the remaining part
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        if (nums != null){
            while (i < j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        if (nums != null) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
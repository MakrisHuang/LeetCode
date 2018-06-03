class Solution {
//     public void moveZeroes(int[] nums) {
//         int idxNot0 = 0;
//         int len = nums.length;
//         int numOf0 = 0;
//         for (int i = 0; i < len; i++){
//             if (nums[i] == 0) numOf0++;
//         }

//         for (int i = 0; i < len; i++){
//             if (nums[i] != 0 && numOf0 >= 0){
//                 nums[idxNot0++] = nums[i];
//                 nums[i] = 0;
//                 numOf0--;
//             }
//             print(nums);
//         }
//     }

    public void moveZeroes(int[] nums) {
        int zeroPointer = 0;
        for(int i = 0; i < nums.length; i++){
           if(nums[i] != 0){
               int tmp = nums[i];
               nums[i] = nums[zeroPointer];
               nums[zeroPointer] = tmp;
               zeroPointer++;
           }
        }
    }

    private void print(int[] nums){
        for (int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}

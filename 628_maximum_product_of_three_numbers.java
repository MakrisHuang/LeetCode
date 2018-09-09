class Solution {
    public int maximumProduct(int[] nums) {
//         Arrays.sort(nums);
//         if (nums.length == 3) return nums[0] * nums[1] * nums[2];

//         List<Integer> negInts = new ArrayList<>();
//         List<Integer> posInts = new ArrayList<>();
//         for (int num: nums) {
//             if (num < 0) negInts.add(num);
//             else posInts.add(num);
//         }
//         int negLen = negInts.size();
//         int posLen = posInts.size();

//         // case 1
//         if (negLen <= 1 && posLen >= 3) {
//             return posInts.get(posLen - 1) * posInts.get(posLen - 2) * posInts.get(posLen - 3);
//         }
//         else {  //  negLen > 1
//             int negMul = negInts.get(0) * negInts.get(1);
//             if (posLen >= 3) {  // case 2
//                 int posMul = posInts.get(posLen - 2) * posInts.get(posLen - 3);
//                 return posInts.get(posLen - 1) * (negMul > posMul ? negMul : posMul);
//             } else {    // case 3
//                 return negMul * posInts.get(posLen - 1);
//             }
//         }


         Arrays.sort(nums);
         //One of the Three Numbers is the maximum value in the array.

         int a = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
         int b = nums[0] * nums[1] * nums[nums.length - 1];
         return a > b ? a : b;
    }
}

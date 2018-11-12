class Solution {
    public int findMin(int[] A) {
//         if (nums.length == 0) return -1;
//         if (nums.length == 1) return nums[0];
//         if (nums.length == 2) return Math.min(nums[0], nums[1]);
        
//         int start = 0, end = nums.length - 1, result = 0;
//         while (start < end) {
//             System.out.println("start: " + start + ", end: " + end);
//             int midIdx = (start + end) / 2;
//             if (nums[start] > nums[end] && nums[midIdx] > nums[end]) { // search right
//                 System.out.println("search right");
//                 start = midIdx + 1;
//             } else {  // search left
//                 System.out.println("search left");
//                 end = midIdx - 1;
//             }
//             result = Math.min(nums[midIdx], nums[start]);
//         }
//         return result;
        int L = 0, R = A.length - 1;
        while (L < R && A[L] >= A[R]) {
            int M = (L + R) / 2;
            if (A[M] > A[R]) {
                L = M + 1;
            } else {
                R = M;
            }
        }
        return A[L];
    }
}
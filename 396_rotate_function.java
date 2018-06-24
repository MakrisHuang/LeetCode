class Solution {
    public int maxRotateFunction(int[] A) {
//         if (A.length == 0) return 0;

//         int max = Integer.MIN_VALUE;
//         for (int offset = 0; offset < A.length; offset++) {
//             int[] arr = rotate(A, offset);
//             int sum = calF(arr);
//             if (sum >= max) max = sum;
//         }
//         return max;

        int allSum = 0;
        int len = A.length;
        int F = 0;
        for (int i = 0; i < len; i++) {
            F += i * A[i];
            allSum += A[i];
        }
        int max = F;
        for (int i = len - 1; i >= 1; i--) {
            F = F + allSum - len * A[i];
            max = Math.max(F, max);
        }
        return max;
    }

//     private int[] rotate(int[] A, int offset) {
//         int len = A.length;
//         int[] newArr = new int[len];
//         int idx = 0;
//         while (idx < len) {
//             for (int right = len - offset; right < len; right++, idx++)
//                 newArr[idx] = A[right];
//             for (int left = 0; left < len - offset; left++, idx++)
//                 newArr[idx] = A[left];
//         }
//         return newArr;
//     }

//     private int calF(int[] arr) {
//         int len = arr.length;
//         int sum = 0;
//         for (int i = 0; i < len; i++) {
//             sum += (i * arr[i]);
//         }
//         return sum;
//     }
}

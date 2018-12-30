class Solution {
    // Time Complexity: O(logn)
    // Space Complexity: O(1)
    public int peakIndexInMountainArray(int[] A) {
        int low = 0, high = A.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (A[mid] < A[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
        // int maxIdx = 0;
        // for (int i = 1; i < A.length; i++) {
        //     if (A[i] > A[maxIdx]) maxIdx = i;
        // }
        // return maxIdx;
    }
}

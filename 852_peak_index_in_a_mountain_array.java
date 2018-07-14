class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int maxIdx = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[maxIdx]) maxIdx = i;
        }
        return maxIdx;
    }
}

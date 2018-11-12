class Solution {
    // time complexity: O(nlogn)
    // public boolean isMonotonic(int[] A) {
    //     int[] copyA = Arrays.copyOf(A, A.length);
    //     Arrays.sort(copyA);
    //     for (int i = 0; i < A.length; i++) {
    //         if (A[i] != copyA[i]) return false;
    //     }
    //     return true;
    // }
    
    // time complexity: O(n)
    public boolean isMonotonic(int[] A) {
        if (A.length == 1 || A.length == 2) return true; 
        boolean isIncreasing = (A[0] <= A[A.length - 1]);
        for (int i = 1; i < A.length; i++) {
            if (isIncreasing) {
                if (A[i - 1] > A[i]) {
                    return false;
                }
            } else {
                if (A[i - 1] < A[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
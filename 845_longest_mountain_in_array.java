class Solution {
    // Time Complexity: O(len(A)), Space Complexity: O(1)
    public int longestMountain(int[] A) {
        int len = A.length;
        int ans = 0, base = 0;

        while (base < len) {
            int end = base;
            // need to check whether end is left-boundary
            if (end + 1 < len && A[end] < A[end + 1]) {
                while (end + 1 < len && A[end] < A[end + 1]) {
                    end++;
                }

                if (end + 1 < len && A[end] > A[end + 1]) {
                    // record potential mountain

                    // find potential valley
                    while (end + 1< len && A[end] > A[end + 1]) {
                        end++;
                    }
                    ans = Math.max(ans, end - base + 1);
                }
            }

            base = Math.max(end, base + 1);
        }
        return ans;
    }
}

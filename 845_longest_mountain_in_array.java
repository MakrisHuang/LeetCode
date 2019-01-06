class Solution {
    // Time Complexity: O(len(A)), Space Complexity: O(1)
    public int longestMountain(int[] A) {
        int len = A.length;
        int ans = 0, base = 0;

        while (base < len) {
            int end = base;
            // 1. need to check whether end is left-boundary
            if (end + 1 < len && A[end] < A[end + 1]) {
                // 2. keep find the peak
                while (end + 1 < len && A[end] < A[end + 1]) {
                    end++;
                }

                // 3. check if it's the peak
                if (end + 1 < len && A[end] > A[end + 1]) {

                    // 4. find potential valley
                    while (end + 1 < len && A[end] > A[end + 1]) {
                        end++;
                    }
                    ans = Math.max(ans, end - base + 1);
                }
            }

            // update base position
            base = Math.max(end, base + 1);
        }
        return ans;
    }
}

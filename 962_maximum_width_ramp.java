class Solution {
    // Time Complexity: O(nlogn)
    // Space Complexity: O(n)
    public int maxWidthRamp(int[] A) {
        Integer[] indexes = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            indexes[i] = i;
        }
        Arrays.sort(indexes, (i1, i2) -> A[i1] - A[i2]);

        int ans = 0, m = A.length - 1;
        for (int index: indexes) {
            ans = Math.max(ans, index - m);
            m = Math.min(m, index);
        }
        return ans;
        // int max = 0;
        // for (int i = 0; i < A.length; i++) {
        //     int last = A.length - 1;
        //     while (last - i > max) {
        //         if (A[last] >= A[i]) {
        //             max = Math.max(max, last - i);
        //         }
        //         last--;
        //     }
        // }
        // return max;
    }
}

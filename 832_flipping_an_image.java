class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int size = A.length;
        for (int i = 0; i < size; i++) {
            // reverse each row
            int start = 0, end = size - 1;
            while (start < end) {
                int temp = A[i][start];
                A[i][start] = A[i][end];
                A[i][end] = temp;
                start++;
                end--;
            }

            // invert each row
            for (int j = 0; j < size; j++) {
                A[i][j] = (A[i][j] == 1) ? 0 : 1;
            }
        }
        return A;
    }
}

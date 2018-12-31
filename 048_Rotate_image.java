class Solution {
    public void rotate(int[][] matrix) {
        // 1. exchange row with row
        int start = 0, end = matrix.length - 1;
        while (start < end) {
            int[] tempRow = matrix[start];
            matrix[start] = matrix[end];
            matrix[end] = tempRow;
            start++;
            end--;
        }

        // 2. exchange elements with anti-diagonal line
        for (int i = 0; i < matrix.length; i++) {
            // j = i + 1 => only exchange upper-right triangle part
            for (int j = i + 1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;

        int max = 0;
        int[][] f = new int[matrix.length][matrix[0].length];
        // initialize values with f[i][0] = matrix[i][0], f[0][j] = matrix[0][j]
        // since we use equal size as auxiliary space, our space complexity is O(m * n)
        for (int i = 0; i < matrix.length; i++) {
            f[i][0] = Character.getNumericValue(matrix[i][0]);
            max = Math.max(max, f[i][0]);
        }
        for (int j = 0; j < matrix[0].length; j++) {
            f[0][j] = Character.getNumericValue(matrix[0][j]);
            max = Math.max(max, f[0][j]);
        }

        // since we iterate each elements, our time complexity is O(m * n)
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    // here we try to find the minimum length for f[i][j] can be
                    f[i][j] = Math.min(f[i - 1][j - 1], Math.min(f[i - 1][j], f[i][j - 1])) + 1;
                } else{
                    f[i][j] = 0;
                }
                max = Math.max(max, f[i][j]);
            }
        }
        return max * max;
    }
}

class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];

        int row = matrix.length, col = matrix[0].length, total = row * col;
        int i = 0, j = 0, count = 1;
        boolean isUpper = true;
        int[] result = new int[total];
        while (count <= total) {
            result[count - 1] = matrix[i][j];
            if (isUpper) {
                if (i - 1 < 0 && j + 1 < col) {   // move to right ele
                    j += 1;
                    isUpper = false;
                } else if (i - 1 < 0 && j + 1 == col) {  // move to down ele
                    i += 1;
                    isUpper = false;
                } else if (i - 1 >= 0 && j + 1 >= col) {  // move to down ele
                    i += 1;
                    isUpper = false;
                } else {
                    i -= 1;
                    j += 1;
                }
            } else {
                if (i + 1 < row && j - 1 < 0) { // move to down ele
                    i += 1;
                    isUpper = true;
                } else if (i + 1 == row && j - 1 < 0) {  // move to right ele
                    j += 1;
                    isUpper = true;
                } else if (i + 1 >= row && j - 1 >= 0) {  // move to right ele
                    j += 1;
                    isUpper = true;
                } else {
                    i += 1;
                    j -= 1;
                }
            }
            count ++;
        }
        return result;
    }
}

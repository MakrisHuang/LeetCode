class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        int numCol = matrix[0].length;
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][numCol - 1] >= target) {
                for (int col = numCol - 1; col >= 0; col--) {
                    if (matrix[row][col] == target) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
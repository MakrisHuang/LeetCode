class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> eles = new ArrayList<>();
        if (matrix.length == 0) return eles;
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = -1;
        while (true){
            // move right
            for (int i = 0; i < n; i++){
                eles.add(matrix[row][++col]);
            }
            if (--m == 0) break; // --m 代表 row 的數量扣一，扣到零為止代表已經走完

            // move down
            for (int i = 0; i < m; i++){
                eles.add(matrix[++row][col]);
            }
            if (--n == 0) break; // --n 代表 col 的數量扣一，扣到零為止代表已經走完

            // move left
            for (int i = 0; i < n; i++){
                eles.add(matrix[row][--col]);
            }
            if (--m == 0) break;

            // move up
            for (int i = 0; i < m; i++){
                eles.add(matrix[--row][col]);
            }
            if (--n == 0) break;
        }
        return eles;
    }
}

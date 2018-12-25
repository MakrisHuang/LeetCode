class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int rows = nums.length, cols = nums[0].length;
        if (rows * cols != r * c) return nums;

        int[][] ans = new int[r][c];
        int x = 0, y = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ans[x][y] = nums[i][j];
                y++;
                if (y % c == 0) {
                    y = 0;
                    x++;
                }
            }
        }
        return ans;
    }
}

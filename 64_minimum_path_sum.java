class Solution {
    public int minPathSum(int[][] grid) {
        int numRows = grid.length;
        int numCols = grid[0].length;
        for (int row = 0; row < numRows; row++){
            for (int col = 0; col < numCols; col++){
                if (row == 0 && col == 0){
                    grid[row][col] = grid[row][col];
                }
                else if (row != 0 && col == 0){
                    grid[row][col] = grid[row][col] + grid[row - 1][col];
                }else if (row == 0 && col != 0){
                    grid[row][col] = grid[row][col] + grid[row][col - 1];
                }else{
                    grid[row][col] = Math.min(grid[row - 1][col], grid[row][col - 1]) + grid[row][col];
                }
            }
        }
        return grid[numRows - 1][numCols - 1];
    }
}

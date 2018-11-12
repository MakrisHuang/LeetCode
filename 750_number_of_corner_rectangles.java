class Solution {
    public int countCornerRectangles(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int rows = grid.length, cols = grid[0].length;
        int counter = 0;
        for (int row = 0; row < grid.length; row++) {
            // select 2 1s in the row
            for (int firstOne = 0; firstOne < cols; firstOne++) {
                // find the first 1
                if (grid[row][firstOne] == 1) {
                    // find the second 1
                    for (int secondOne = firstOne + 1; secondOne < cols; secondOne++) {
                        if (grid[row][secondOne] == 1) {
                            // search elements in cols, row by row
                            for (int searchRow = row + 1; searchRow < rows; searchRow++) {
                                if (grid[searchRow][firstOne] == 1 && grid[searchRow][secondOne] == 1) {
                                    counter++;
                                }
                            }
                        }
                    }
                }
            }
        }
        return counter;
    }
}
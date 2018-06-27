class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += countNumSidesUntouched(grid, i, j);
                }
            }
        }

        return perimeter;
    }

    private int countNumSidesUntouched(int[][] grid, int x, int y) {
        int rows = grid.length, cols = grid[0].length;
        int remaining = 4;
        if (x - 1 >= 0) {
            remaining -= (grid[x - 1][y] == 1) ? 1 : 0;
        }
        if (y - 1 >= 0) {
            remaining -= (grid[x][y - 1] == 1) ? 1 : 0;
        }
        if (x + 1 < rows) {
            remaining -= (grid[x + 1][y] == 1) ? 1 : 0;
        }
        if (y + 1 < cols) {
            remaining -= (grid[x][y + 1] == 1) ? 1 : 0;
        }
        return remaining;
    }
}

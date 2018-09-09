class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        if (grid.length == 0 || grid[0].length == 0) return 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 0) continue;

                int area = getIslandArea(grid, row, col);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    private int getIslandArea(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length) {
            return 0;
        }

        if (grid[row][col] == 1) {
            grid[row][col] = 0;
            return 1 + getIslandArea(grid, row + 1, col) +
                getIslandArea(grid, row - 1, col) +
                getIslandArea(grid, row, col - 1) +
                getIslandArea(grid, row, col + 1);
        } else {
            return 0;
        }
    }
}

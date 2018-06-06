class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') continue;
                num++;
                dfs(grid, i, j);
            }
        }
        return num;
    }

    private void dfs (char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return;
        }
        if (grid[x][y] == '1') {
            grid[x][y] = '0';
            dfs(grid, x - 1, y);
            dfs(grid, x, y + 1);
            dfs(grid, x + 1, y);
            dfs(grid, x, y - 1);
        }
    }
}

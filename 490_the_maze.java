class Solution {
    // Time Complexity: O(rows * cols (nodes) + (n-1) * (m - 1) (edges))
    // Space Complexity: O(rows * cols)
    int[][] directions = new int[][] {
        {-1, 0},    // up
        {0, 1},     // right
        {1, 0},     // down
        {0, -1}     // left
    };

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, visited, start[0], start[1], destination);
    }

    public boolean dfs(int[][] maze, boolean[][] visited, int i, int j, int[] dest) {
        if (visited[i][j]) {
            return false;
        }

        if (i == dest[0] && j == dest[1]) {
            return true;
        }

        visited[i][j] = true;
        int rows = maze.length, cols = maze[0].length;
        for (int[] step: directions) {
            int dx = i;
            int dy = j;
            // keep going with the same step to avoid TLE
            while (dx + step[0] >= 0 && dx + step[0] < rows && dy + step[1] >= 0 && dy + step[1] < cols && maze[dx + step[0]][dy + step[1]] != 1) {
                dx += step[0];
                dy += step[1];
            }
            if (dfs(maze, visited, dx, dy, dest)) {
                return true;
            }
        }
        return false;
    }
}

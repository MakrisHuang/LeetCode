class Solution {
    int[][] steps = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        //DFS + cache
        int rows = maze.length;
        int cols = maze[0].length;
        boolean[][] visited = new boolean[rows][cols];

        return dfs(maze, start, destination, visited, rows, cols);
    }

    private boolean dfs(int[][] maze, int[] start, int[] des, boolean[][] visited, int rows, int cols) {
        if (visited[start[0]][start[1]]) {
            return false;
        }
        if (start[0] == des[0] && start[1] == des[1]) {
            return true;
        }

        visited[start[0]][start[1]] = true;
        for (int[] step : steps) {
            int dx = start[0];
            int dy = start[1];
            while (dx + step[0] >= 0 && dx + step[0] < rows && dy + step[1] >= 0 && dy + step[1] < cols && maze[dx + step[0]][dy + step[1]] != 1) {
                dx += step[0];
                dy += step[1];
            }
            if (dfs(maze, new int[]{dx, dy}, des, visited, rows, cols)) {
                return true;
            }
        }
        return false;
    }
//     public boolean hasPath(int[][] maze, int[] start, int[] destination) {
//         // go with 4 directions
//         boolean[][] visited = new boolean[maze.length][maze[0].length];
//         for (int i = 0; i < maze.length; i++) {
//             for (int j = 0; j < maze[0].length; j++) {
//                 if (maze[i][j] == 1) {
//                     visited[i][j] = true;
//                 }
//             }
//         }
//         return dfs(maze, visited, start[0], start[1], 0, destionation);
//     }

//     public boolean dfs(int[][] maze, boolean[][] visited, int x, int y, int prevDir, int[] dest) {
//         // check wall with prev direction
//         if (prevDir == 1 && ) { // prev is up
//         }
//         int rows = maze.length, cols = maze[0].length;

//         visited[x][y] = true;

//         boolean res = false;
//         // go up: if up is not at top and up is not a wall
//         if ((x != 0) && !visited[x - 1][y]) {
//             res |= dfs(maze, visited, x - 1, y, 1, dest);
//         }
//         // go right: if right is not at right and right is not a wall
//         if ((y != cols - 1) && !visited[x - 1][y]) {
//             res |= dfs(maze, visited, x, y + 1, 2, dest);
//         }
//         // go down: if down is not at bottom and down is not a wall
//         if ((x != rows - 1) && !visited[x - 1][y]) {
//             res |= dfs(maze, visited, x - 1, y, 3, dest);
//         }
//         // go left: if left is not at left and left is not a wall
//         if ((y != 0) && !visited[x][y - 1]) {
//             res |= dfs(maze, visited, x, y - 1, 4, dest);
//         }

//         return res;
//     }
}

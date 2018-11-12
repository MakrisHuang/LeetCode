class Solution {
    public int numDistinctIslands(int[][] grid) {
        List<List<int[]>> res = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    List<int[]> candidate = new ArrayList<>();
                    dfs(grid, candidate, i, j);
                    validateAnswer(res, candidate);
                }
            }
        }
        return res.size();
    }

    public void validateAnswer(List<List<int[]>> res, List<int[]> cand) {
        cand.sort((i1, i2) -> i1[0] - i2[0]);
        if (res.size() == 0) {
            res.add(cand); return;
        }

        // find list with identical offset
        for (List<int[]> prev: res) {
            if (prev.size() == cand.size()) {
                int xOffset = prev.get(0)[0] - cand.get(0)[0];
                int yOffset = prev.get(0)[1] - cand.get(0)[1];
                // compare the remaining part
                boolean matchX = true, matchY = true;
                for (int pos = 1; pos < cand.size(); pos++) {
                    matchX = matchX && (prev.get(pos)[0] - cand.get(pos)[0]) == xOffset;
                    matchY = matchY && (prev.get(pos)[1] - cand.get(pos)[1]) == yOffset;
                }
                if (matchX && matchY) {
                    return;
                }
            }
            if (prev.size() == 1 && cand.size() == 1) {
                return;
            }
        }
        res.add(cand);
    }

    public void dfs(int[][] grid, List<int[]> temp, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }

        if (grid[i][j] == 1) {
            grid[i][j] = -1;
            temp.add(new int[] {i, j});
            dfs(grid, temp, i - 1, j);
            dfs(grid, temp, i, j + 1);
            dfs(grid, temp, i + 1, j);
            dfs(grid, temp, i, j - 1);
        }
    }
}


class Solution {
    int[][] grid;
    boolean[][] seen;
    ArrayList<Integer> shape;

    public void explore(int r, int c, int di) {
        if (0 <= r && r < grid.length && 0 <= c && c < grid[0].length &&
                grid[r][c] == 1 && !seen[r][c]) {
            seen[r][c] = true;
            shape.add(di);
            explore(r+1, c, 1);
            explore(r-1, c, 2);
            explore(r, c+1, 3);
            explore(r, c-1, 4);
            shape.add(0);
        }
    }
    public int numDistinctIslands(int[][] grid) {
        this.grid = grid;
        seen = new boolean[grid.length][grid[0].length];
        Set shapes = new HashSet<ArrayList<Integer>>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                shape = new ArrayList<Integer>();
                explore(r, c, 0);
                if (!shape.isEmpty()) {
                    shapes.add(shape);
                }
            }
        }

        return shapes.size();
    }
}
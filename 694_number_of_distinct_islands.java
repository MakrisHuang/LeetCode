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

class Solution {
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length < 1 || grid[0].length < 1)
			return 0;
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int cnt = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (!visited[i][j] && grid[i][j] == '1') {
					cnt++;
					bfs(grid, visited, i, j);
				}
			}
		}
		return cnt;
	}

	void bfs(char[][] grid, boolean[][] visited, int i, int j) {
		Queue<V> queue = new LinkedList<>();
		V v = new V(i, j);
		visited[i][j] = true;
		queue.offer(v);
		while (!queue.isEmpty()) {
			v = queue.poll();
			if (v.x + 1 < grid.length && grid[v.x + 1][v.y] == '1' && !visited[v.x + 1][v.y]) {
				visited[v.x + 1][v.y] = true;
				queue.offer(new V(v.x + 1, v.y));
			}
			if (v.x - 1 >= 0 && grid[v.x - 1][v.y] == '1' && !visited[v.x - 1][v.y]) {
				visited[v.x - 1][v.y] = true;
				queue.offer(new V(v.x - 1, v.y));
			}
			if (v.y + 1 < grid[0].length && grid[v.x][v.y + 1] == '1' && !visited[v.x][v.y + 1]) {
				visited[v.x][v.y + 1] = true;
				queue.offer(new V(v.x, v.y + 1));
			}
			if (v.y - 1 >= 0 && grid[v.x][v.y - 1] == '1' && !visited[v.x][v.y - 1]) {
				visited[v.x][v.y - 1] = true;
				queue.offer(new V(v.x, v.y - 1));
			}
		}
	}

	class V {
		int x;
		int y;

		public V(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

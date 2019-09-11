class Solution:
    def maxDistance(self, grid: List[List[int]]) -> int:
        """
        Basic idea:
        keep searching for nearest water
        at the end, the last one will be the farest one among all islands
        """
        dis = 0
        m,n = len(grid),len(grid[0])
        queue = collections.deque()
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    queue.append((i,j))
        if len(queue) == 0 or len(queue) == m*n:
            return -1
        directions = [(0,1),(1,0),(-1,0),(0,-1)]
        while queue:
            print('queue', queue)
            i,j= queue.popleft()
            dis = grid[i][j]
            for dx,dy in directions:
                x,y = i+dx,j+dy
                if 0 <= x < m and 0 <= y < n and grid[x][y] == 0:
                    for row in grid:
                        print(row)
                    print()
                    grid[x][y] = dis + 1
                    queue.append((x,y))
        return dis - 1

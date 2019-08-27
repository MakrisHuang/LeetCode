class Solution:
    def hasPath_dfs(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        visited = [[False] * len(maze[0]) for _ in range(len(maze))]
        return self.dfs(maze, visited, start[0], start[1], destination)

    def dfs(self, maze: List[List[int]], visited: List[List[bool]], i: int, j: int, dest: List[int]) -> bool:
        if visited[i][j]:
            return False
        if i == dest[0] and j == dest[1]:
            return True

        visited[i][j] = True
        rows = len(maze)
        cols = len(maze[0])
        for step in ([-1,0], [0,1], [1,0], [0,-1]):
            dx = i
            dy = j
            while dx + step[0] >= 0 and dx + step[0] < rows and \
                dy + step[1] >= 0 and dy + step[1] < cols and \
                maze[dx + step[0]][dy + step[1]] != 1:
                dx += step[0]
                dy += step[1]
            if self.dfs(maze, visited, dx, dy, dest):
                return True
        return False

    def hasPath_bfs(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        from queue import Queue
        visited = [[False] * len(maze[0]) for _ in range(len(maze))]
        i = start[0]
        j = start[1]
        q = Queue()

        rows = len(maze)
        cols = len(maze[0])
        q.put((i, j))
        visited[i][j] = True
        while q.qsize() > 0:
            x, y = q.get()
            if x == destination[0] and y == destination[1]:
                return True
            for step in ([-1, 0], [0, 1], [1, 0], [0, -1]):
                dx = x
                dy = y
                while dx + step[0] >= 0 and dx + step[0] < rows and \
                    dy + step[1] >= 0 and dy + step[1] < cols and \
                    maze[dx + step[0]][dy + step[1]] == 0:
                    dx += step[0]
                    dy += step[1]
                if not visited[dx][dy]:
                    q.put((dx, dy))
                    visited[dx][dy] = True
        return False

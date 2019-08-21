class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adj = [[0] * numCourses for _ in range(numCourses)]
        indegree = [0] * numCourses

        for i, val in enumerate(prerequisites):
            ready = val[0]
            pre = val[1]
            if adj[pre][ready] == 0:
                indegree[ready] += 1
            adj[pre][ready] = 1

        q = collections.deque()
        for i in range(numCourses):
            if indegree[i] == 0:
                q.append(i)

        count = 0
        while len(q) > 0:
            course = q.popleft()
            count += 1
            for i in range(numCourses):
                if adj[course][i] != 0:
                    indegree[i] -= 1
                    if indegree[i] == 0:
                        q.append(i)

        return count == numCourses

# DFS version
class Solution(object):
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph = [[] for _ in range(numCourses)]
        visited = [0 for _ in range(numCourses)]
        # create graph
        for pair in prerequisites:
            x, y = pair
            graph[x].append(y)
        # visit each node
        for i in range(numCourses):
            if not self.dfs(graph, visited, i):
                return False
        return True

    def dfs(self, graph, visited, i):
        # if ith node is marked as being visited, then a cycle is found
        if visited[i] == -1:
            return False
        # if it is done visted, then do not visit again
        if visited[i] == 1:
            return True
        # mark as being visited
        visited[i] = -1
        # visit all the neighbours
        for j in graph[i]:
            if not self.dfs(graph, visited, j):
                return False
        # after visit all the neighbours, mark it as done visited
        visited[i] = 1
        return True

class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        indegree = [0] * numCourses
        neigh = collections.defaultdict(set)
        for x, y in prerequisites:
            indegree[x] += 1
            neigh[y].add(x)

        starters = [i for i in range(numCourses) if indegree[i] == 0]
        q = collections.deque(starters)
        res = []
        while q:
            node = q.popleft()
            res.append(node)
            for i in neigh[node]:
                indegree[i] -= 1
                if indegree[i] == 0:
                    q.append(i)
        for degree in indegree:
            if degree > 0: return []
        return res

    def findOrder_dfs(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        graph = [[] for _ in range(numCourses)]
        visited_status = [0 for _ in range(numCourses)]
        for pre, after in prerequisites:
            graph[pre].append(after)
        stack = []
        for i in range(numCourses):
            if visited_status[i] == 0:
                if not self.dfs(i, graph, visited_status, stack):
                    return []
        return stack

    def dfs(self, curr, graph, visited_status, stack) -> bool:
        if visited_status[curr] == -1:  # visiting, and cycle found
            return False
        if visited_status[curr] == 1:   # done visiting, do not visit again
            return True

        visited_status[curr] = -1   # mark as visiting

        for nei in graph[curr]:
            if not self.dfs(nei, graph, visited_status, stack):
                return False

        visited_status[curr] = 1    # done visiting

        stack.append(curr)

        return True

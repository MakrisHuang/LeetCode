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

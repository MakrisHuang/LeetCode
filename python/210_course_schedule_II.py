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

class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        indegree = [0] * numCourses
        neigh = collections.defaultdict(set)
        for x, y in prerequisites:
            indegree[x] += 1
            neigh[y].add(x)

        stack = [i for i in range(numCourses) if indegree[i] == 0]
        res = []
        while stack:
            node = stack.pop()
            res.append(node)
            for i in neigh[node]:
                indegree[i] -= 1
                if indegree[i] == 0:
                    stack.append(i)
        for degree in indegree:
            if degree > 0: return []
        return res

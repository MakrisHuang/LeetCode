class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        # apply bfs
        letters = set()
        for a, b in equations:
            letters.add(a)
            letters.add(b)
        N = len(letters)
        letters = list(letters)
        mapping = {} # key: letter, value: index in the matrix
        for i in range(N):
            mapping[letters[i]] = i
        # create matrix
        matrix = [[None for i in range(N)] for j in range(N)]
        for i in range(len(equations)):
            a, b = equations[i]
            matrix[mapping[a]][mapping[b]] = values[i]
            matrix[mapping[b]][mapping[a]] = 1 / values[i]
        res = []
        for query in queries:
            start, end = query
            if start not in mapping or end not in mapping:
                res.append(-1.0)
                continue
            if start == end:
                res.append(1.0)
                continue
            q = [(start, 1)]
            visited = [False for i in range(N)]
            while q:
                curr, multi = q.pop(0)
                visited[mapping[curr]] = True
                if curr == end:
                    res.append(multi)
                    break
                # push neighbors
                for nei in letters:
                    num = matrix[mapping[curr]][mapping[nei]]
                    if not visited[mapping[nei]] and nei != curr and num is not None:
                        q.append((nei, multi * num))
            if not q and not visited[mapping[end]]:
                res.append(-1.0)
        return res


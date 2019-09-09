class Solution:
    def isEscapePossible(self, blocked: List[List[int]], source: List[int], target: List[int]) -> bool:
        if not blocked: return True
        blocked = set(map(tuple, blocked))

        def bfs(blocked, source, target):
            si, sj = source
            ti, tj = target
            level = 0
            q = collections.deque([(si, sj)])
            visited = set()
            while q:
                for _ in range(len(q)):
                    i, j = q.popleft()
                    if i == ti and j == tj: return True
                    for x, y in ((i + 1, j), (i - 1, j), (i, j + 1), (i, j - 1)):
                        if 0 <= x < 10**6 and 0 <= y < 10**6 and (x, y) not in visited and (x, y) not in blocked:
                            visited.add((x, y))
                            q.append((x, y))
                # if we found all nodes are visited, and number of nodes visted equals to
                # length of blocked, indicating we are consuming all nodes in this area
                # so we are able to go out this area to find out target node
                level += 1
                if level == len(blocked): break
            else:
                return False
            return True

        return bfs(blocked, source, target) and bfs(blocked, target, source)

class Solution:
    def numSquares(self, n: int) -> int:
        # apply bfs by trying large number to small
        # why using bfs? because for finding shortest route
        # since we want to try all combination, start with 0
        q = collections.deque([0])
        visited = set()
        res = 0
        while q:
            # every time capture a node, increase steps
            res += 1
            size = len(q)
            for _ in range(size):
                curr = q.popleft()
                j = 1
                # simulate visiting nodes
                while curr + j*j <= n:
                    temp = curr + j*j
                    if temp == n:
                        return res
                    j += 1
                    if temp in visited:
                        continue
                    q.append(temp)
                    visited.add(temp)
        return -1

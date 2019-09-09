class Solution:
    """
    Time Complexity: O(len(blocked) ^ 2)
    Space Complexity: O(len(blocked) ^ 2)
    """
    def isEscapePossible(self, blocked: List[List[int]], source: List[int], target: List[int]) -> bool:
        """
        :type blocked: List[List[int]]
        :type source: List[int]
        :type target: List[int]
        :rtype: bool
        """
        if not blocked: return True
        blocked = set(map(tuple, blocked))

        def bfs(blocked, source, target):
            si, sj = source
            ti, tj = target
            level = 0
            q = collections.deque([(si,sj)])
            vis = set()
            while q:
                for _ in range(len(q)):
                    i,j = q.popleft()
                    if i == ti and j == tj: return True
                    for x,y in ((i+1,j),(i-1,j),(i,j+1),(i,j-1)):
                        if 0 <= x < 10**6 and 0 <= y < 10**6 and (x,y) not in vis and (x,y) not in blocked:
                            vis.add((x,y))
                            q.append((x,y))
                level += 1
                if level == len(blocked): break
            else:
                return False
            return True

        return bfs(blocked, source, target) and bfs(blocked, target, source)

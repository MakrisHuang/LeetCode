# https://leetcode.com/problems/minimum-jumps-to-reach-home/discuss/935419/Python-deque-BFS-O(max(x-max(forbidden))%2Ba%2Bb)
from collections import deque
class Solution:
    def minimumJumps(self, forbidden: List[int], a: int, b: int, x: int) -> int:
        max_val = max([x] + forbidden) + a + b

        jumps = [0] + [math.inf] * max_val
        for pos in forbidden: jumps[pos] = -1
        queue = deque([0])

        while queue:
            pos = queue.popleft()
            # current steps is less, so need to enqueue
            if pos + a <= max_val and jumps[pos + a] > jumps[pos] + 1:
                queue.append(pos + a)
                jumps[pos + a] = jumps[pos] + 1
            if pos - b > 0 and jumps[pos - b] > jumps[pos] + 1:
                # since we cannot backforware twice, no need to enqueue again
                jumps[pos - b] = jumps[pos] + 1
                if pos - b + a <= max_val and jumps[pos - b + a] > jumps[pos] + 2:
                    queue.append(pos - b + a)
                    jumps[pos - b + a] = jumps[pos] + 2

        return jumps[x] if jumps[x] < math.inf else -1

class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        # apply bfs to find minimum number of turns to open it
        # question: how to break through deadend?
        invalid = set(deadends)
        if "0000" in invalid:
            return -1
        q = collections.deque([("0000", 0)])
        visited = set()
        res = -float('inf')
        while q:
            curr, step = q.popleft()
            # print('curr', curr)
            # print('step', step)
            if curr not in visited:
                visited.add(curr)
                if curr == target:
                    return step

                # find neighbor
                for i in range(len(curr)):
                    for offset in [1, -1]:
                        values = list(map(int, curr))
                        values[i] = (values[i] + offset) % 10
                        new_key = "".join(map(str, values))
                        if new_key not in visited and new_key not in invalid:
                            q.append((new_key, step + 1))
        return -1



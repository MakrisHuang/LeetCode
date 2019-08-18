class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        N = len(costs)
        if N == 0:
            return 0

        now = [0] * 3
        prev = costs[0][:]

        for i in range(N - 1):
            now[0] = min(prev[1], prev[2]) + costs[i + 1][0]
            now[1] = min(prev[0], prev[2]) + costs[i + 1][1]
            now[2] = min(prev[0], prev[1]) + costs[i + 1][2]
            prev[:] = now[:]
        return min(prev)


from heapq import heappush, heappop
class Solution:
    # Time Complexity: O(ElogE) (logE: for heap doing heapify, E: for iterating all edges)
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, K: int) -> int:
        graph = collections.defaultdict(dict)
        for u, v, w in flights:
            graph[u][v] = w

        best = dict()
        q = [(0, 0, src)]   # cost, k, city
        while q:
            cost, k, place = heappop(q)
            if k > K + 1: continue
            if place == dst: return cost

            for nei, wt in graph[place].items():
                newcost = cost + wt
                if newcost < best.get((k + 1, nei), float('inf')):
                    heappush(q, (newcost, k + 1, nei))
                    best[(k + 1), nei] = newcost
        return -1





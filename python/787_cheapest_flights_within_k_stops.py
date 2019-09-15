class Solution:
    # Time Complexity: O(E + nlogn), E = total number of flights, n = number of cities
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, K: int) -> int:
        cost = [float('inf') for _ in range(n)]
        cost[src] = 0
        q = collections.deque([src])

        stops = 0
        while q:
            q_size = len(q)
            for i in range(q_size):
                city = q.popleft()
                for flight in flights:
                    u, v, new_cost = flight
                    if stops == K and v != dst:
                        continue
                    if city == u and cost[v] > cost[u] + new_cost:
                        cost[v] = cost[u] + new_cost
                        q.append(v)
            stops += 1
        return cost[dst] if cost[dst] != float('inf') else -1


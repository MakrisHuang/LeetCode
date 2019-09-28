class Solution:
    # Time Complexity: O(N ^ 2 + E)
    # Space Complexity: O(N)
    def networkDelayTime(self, times: List[List[int]], N: int, K: int) -> int:
        # apply Dijkstra algorithm by calculate all traveling
        # from K to all end nodes
        # and find out the largest traveling time as the longest delay time
        def findMinDistanceIndex(dist: List[int], sptSet: List[bool]) -> int:
            N = len(sptSet)
            min = float('inf')
            min_idx = -1
            for v in range(N):
                if dist[v] < min and not sptSet[v]:
                    min = dist[v]
                    min_idx = v
            return min_idx

        def dijkstra(graph: List[List[int]], src: int) -> List[int]:
            N = len(graph)
            dist = [float('inf')] * N
            dist[src] = 0
            sptSet = [False for _ in range(N)]

            for _ in range(N):
                u = findMinDistanceIndex(dist, sptSet)

                sptSet[u] = True

                for v in range(N):
                    if graph[u][v] > -1 and sptSet[v] == False \
                        and dist[v] > dist[u] + graph[u][v]:
                        dist[v] = dist[u] + graph[u][v]
            return dist

        graph = [[-1 for _ in range(N)] for _ in range(N)]
        for start, end, weight in times:
            graph[start - 1][end - 1] = weight
        distances = dijkstra(graph, K - 1)
        longest = max(distances)
        return longest if longest != float('inf') else -1

class Solution:
    # Complexity: O(N * logK) (N = number of nodes, K = K cloest)
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        heap = []

        for (x, y) in points:
            dist = -(x * x + y * y)
            if len(heap) == k:
                heapq.heappushpop(heap, (dist, x, y))
            else:
                heapq.heappush(heap, (dist, x, y))

        return [[x, y] for (heap, x, y) in heap ]

    # O(K + N*logN)
    def kClosest(self, points: List[List[int]], K: int) -> List[List[int]]:
        q = []
        for x, y in points:
            dist = x ** 2 + y ** 2
            q.append((dist, (x, y)))
        q.sort(key=lambda x: x[0])
        k_closest = q[:K]
        return [item[1] for item in k_closest]

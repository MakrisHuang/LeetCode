class Solution:
    def kClosest(self, points: List[List[int]], K: int) -> List[List[int]]:
        q = []
        for x, y in points:
            dist = x ** 2 + y ** 2
            q.append((dist, (x, y)))
        q.sort(key=lambda x: x[0])
        k_closest = q[:K]
        return [item[1] for item in k_closest]

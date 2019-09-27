class Solution:
    # Time Complexity: O(N)
    # Space Complexity: O(N)
    def kClosest(self, points: List[List[int]], K: int) -> List[List[int]]:
        def compare(p1, p2) -> int:
            return (p1[0] ** 2 + p1[1] ** 2) - (p2[0] ** 2 + p2[1] ** 2)

        def quickSelect(points: List[List[int]], l: int, r: int) -> int:
            pivot = points[l]
            while l < r:
                while l < r and compare(points[r], pivot) >= 0:
                    r -= 1
                points[l] = points[r]
                while l < r and compare(points[l], pivot) <= 0:
                    l += 1
                points[r] = points[l]
            points[l] = pivot
            return l

        l, r = 0, len(points) - 1
        while (l <= r):
            mid = quickSelect(points, l, r)
            if mid == K:
                break
            if mid < K:
                l = mid + 1
            else:
                r = mid - 1
        return points[:K]

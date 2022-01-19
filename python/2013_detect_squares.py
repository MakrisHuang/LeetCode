# https://leetcode.com/problems/detect-squares/discuss/1471958/C%2B%2BJavaPython-2-approaches-using-HashMap-with-Picture-Clean-and-Concise
class DetectSquares:

    def __init__(self):
        self.points = Counter()

    def add(self, point: List[int]) -> None:
        self.points[tuple(point)] += 1

    def count(self, point: List[int]) -> int:
        # check any diagonal points by checking this
        # abs(p1.x - p3.x) = abs(p1.y - p3.y) && abs(p1.x-p3.x) > 0
        # if we find one, the p2 in upper left is (p3.x, p1.y) and
        # p4 in down right is (p1.x, p3.y)
        # if both points exist, we get the mulitply of them since we allow duplications
        ans = 0
        p1x, p1y = point
        for (p3x, p3y), count in self.points.items():
            if abs(p1x - p3x) == abs(p1y - p3y) and abs(p1x - p3x) > 0:
                p2Point = (p3x, p1y)
                p4Point = (p1x, p3y)
                if p2Point in self.points and p4Point in self.points:
                    ans += count * self.points[p2Point] * self.points[p4Point]
        return ans


# Your DetectSquares object will be instantiated and called as such:
# obj = DetectSquares()
# obj.add(point)
# param_2 = obj.count(point)

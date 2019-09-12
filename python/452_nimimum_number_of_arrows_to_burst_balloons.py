class Solution:
    # Time Complexity: O(NlogN)
    # Space Complexity: O(1)
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        # greedy for each range, and find out bursted ballons
        # to maximum the number of ballon we shot, we can always shot at the end position
        # sort the range by the end
        if not points:
            return 0
        points.sort(key=lambda x: x[1])
        first_end = points[0][1]
        arrows = 1
        for i in range(1, len(points)):
            # ex balloons = [[2,4], [1,4], [1,5], [3,6], [7,10]]
            # shoot at 4, and we can burst first 4 ballons
            # and then move to another range
            if first_end >= points[i][0]:
                continue
            arrows += 1
            first_end = points[i][1]

        return arrows

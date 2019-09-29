class Solution:
    # Version 2: consider active overlapping set
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        if not points: return 0
        points.sort(key=lambda x: x[0])

        # minEnd : Key parameter "active set" for overlapping intervals,
        # e.g. the minimum ending point among all overlapping intervals;
        minEnd = float('inf')
        count = 1
        for start, end in points:
            # If the changing some states, record some information, and start a new active set "new arrow"
            if start > minEnd:
                count += 1
                minEnd = end
            else:
                # renew key parameters of the active set
                minEnd = min(minEnd, end)
        return count

class Solution:
    # Time Complexity: O(NlogN)
    # Space Complexity: O(1)
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        # [1,2], [1,3], [2,3], [3,4]
        # [1,2], [1,2], [1,2]
        if not intervals:
            return 0
        intervals.sort(key=lambda x: x[1])
        first_end = intervals[0][1]
        num_to_removed = 0
        for i in range(1, len(intervals)):
            # if first end is larger, which means current interval is overlapped
            # and need to be removed, so increase num_to_removed
            if first_end > intervals[i][0]:
                num_to_removed += 1
                continue
            first_end = intervals[i][1]
        return num_to_removed

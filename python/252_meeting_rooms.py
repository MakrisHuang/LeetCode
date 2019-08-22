class Solution:
    def canAttendMeetings(self, intervals: List[List[int]]) -> bool:
        from operator import itemgetter
        intervals = sorted(intervals, key=itemgetter(0))

        for i in range(len(intervals) - 1):
            if intervals[i][1] > intervals[i + 1][0]: return False
        return True

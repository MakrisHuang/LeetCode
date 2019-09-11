class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        if not intervals: return 0

        free_rooms = []

        # since we want to check next available room
        # sort the intervals by start time
        intervals.sort(key=lambda x: x[0])

        # add the first meeting. We have to give a new room to the first meeting
        heapq.heappush(free_rooms, intervals[0][1])

        for interval in intervals[1:]:
            if free_rooms[0] <= interval[0]:
                # previous meeting is finished, need to be removed
                heapq.heappop(free_rooms)

            # then push a new meeting no matter previous meetings are finished
            heapq.heappush(free_rooms, interval[1])

        return len(free_rooms)

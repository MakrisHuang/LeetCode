/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        // sort them by start time
        List<Interval> intervalList = Arrays.asList(intervals);
        intervalList.sort((interval1, interval2) -> {
           return interval1.start - interval2.start;
        });

        // use end time to ensure next interval will overpass it
        PriorityQueue<Integer> allocator = new PriorityQueue<Integer>((end1, end2) -> {
            return end1 - end2;
        });

        allocator.offer(intervalList.get(0).end);

        for (int i = 1; i < intervalList.size(); i++) {
            // If the room due to free up the earliest is free, assign that room to this meeting.
            if (intervalList.get(i).start >= allocator.peek()) {
                allocator.poll();
            }

            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with updated end time.
            allocator.offer(intervalList.get(i).end);
        }

        return allocator.size();
    }
}

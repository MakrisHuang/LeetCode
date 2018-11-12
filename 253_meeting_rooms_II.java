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
        Collections.sort(intervalList, (interval1, interval2) -> {
           return interval1.start - interval2.start;
        });
        
        PriorityQueue<Integer> allocator = new PriorityQueue<Integer>((end1, end2) -> {
            return end1 - end2; 
        });
        
        allocator.offer(intervalList.get(0).end);
        
        for (int i = 1; i < intervalList.size(); i++) {
            if (intervalList.get(i).start >= allocator.peek()) {
                allocator.poll();
            }
            
            allocator.offer(intervalList.get(i).end);
        }
        
        return allocator.size();
    }
}
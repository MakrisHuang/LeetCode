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
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return true;
        
        List<Interval> intervalsList = Arrays.asList(intervals);
        Collections.sort(intervalsList, (interval1, interval2) -> {
            return interval1.start - interval2.start;
        });
           
        for (int i = 0; i < intervalsList.size() - 1; i++) {
            if (intervalsList.get(i).end > intervalsList.get(i + 1).start) {
                return false;
            }
        }
        return true;
    }
}
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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) return res;
        
        intervals.sort((i1, i2) -> i1.start - i2.start);
        
        Iterator<Interval> curr = intervals.iterator();
        Interval prev = null;
        while (curr.hasNext()) {
            if (prev == null) {
                prev = curr.next();
            } else {
                Interval next = curr.next();
                if (prev.end >= next.start) {
                    prev.end = Math.max(prev.end, next.end);
                } else {
                    res.add(prev);
                    prev = next;
                }
            }
        }
        if (prev != null) {
            res.add(prev);
        }
        
        return res;
    }
}
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
    // Time Complexity: O(n)
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        int i = 0;
        int start = newInterval.start;
        int end = newInterval.end;


        while (i < intervals.size() && intervals.get(i).end < start) {
            result.add(intervals.get(i++));
        }

        // find interval in the middle of list
        // where the new interval is shorter in end, compared to start from current interval
        while (i < intervals.size() && intervals.get(i).start <= end) {
            start = Math.min(start, intervals.get(i).start);
            end = Math.max(end, intervals.get(i).end);
            i++;
        }
        result.add(new Interval(start,end));

        while (i < intervals.size()) result.add(intervals.get(i++));
        return result;

//         List<Interval> part = new ArrayList<>();
//         List<Integer> mid = new ArrayList<>();

//         for (int i = 0; i < intervals.size(); i++) {
//             Interval iv = intervals.get(i);
//             if ((iv.end >= newInterval.start && iv.start <= newInterval.start) ||
//                 (iv.end >= newInterval.end && iv.start <= newInterval.end) ||
//                 (iv.start >= newInterval.start && iv.end <= newInterval.end)) {
//                 part.add(iv);
//                 mid.add(i);
//             }
//         }

//         if (part.size() == 0) {
//             // no overlapping, find the right position to insert the interval
//             for (int i = 0; i < intervals.size(); i++) {
//                 if (i == 0 && newInterval.start < intervals.get(i).start) {
//                     intervals.add(0, newInterval);
//                     return intervals;
//                 } else if (i > 0 && newInterval.start < intervals.get(i).start &&
//                     newInterval.start > intervals.get(i - 1).start) {
//                     intervals.add(i, newInterval);
//                     return intervals;
//                 }
//             }
//             intervals.add(newInterval);
//             return intervals;

//         } else {
//             List<Interval> res = new ArrayList<>();
//             part.add(newInterval);
//             List<Interval> merged = merge(part);

//             // copy the front part
//             for (int i = 0; i < mid.get(0); i++) {
//                 res.add(intervals.get(i));
//             }

//             res.addAll(merged);

//             // copy the back part
//             for (int j = mid.get(mid.size() - 1) + 1; j < intervals.size(); j++) {
//                 res.add(intervals.get(j));
//             }
//             return res;
//         }
    }

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

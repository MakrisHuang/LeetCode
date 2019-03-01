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
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        List<Interval> res = new ArrayList<>();
        int i = 0, j = 0;

        while (i < A.length && j < B.length) {
            int start = Math.max(A[i].start, B[j].start);
            int end = Math.min(A[i].end, B[j].end);
            if (start <= end) {
                res.add(new Interval(start, end));
            }

            if (A[i].end < B[j].end) {
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new Interval[res.size()]);
    }
}

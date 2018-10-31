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
		if(intervals ==null || intervals.isEmpty()) return intervals;

		intervals.sort((i1,i2)-> i1.start-i2.start);
		List<Interval> res = new LinkedList<>();
		Iterator<Interval> it = intervals.iterator();
		Interval cur = null;
		while (it.hasNext()) {
			if (null == cur)
				cur = it.next();
			else {
				Interval iv = it.next();
				if (cur.end >= iv.start) {
					cur.end = Math.max(cur.end, iv.end);
				} else {
					res.add(cur);
					cur = iv;
				}
			}
		}
		if (null != cur)
			res.add(cur);
		return res;
	}
}



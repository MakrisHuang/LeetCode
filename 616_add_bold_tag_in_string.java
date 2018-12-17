class Solution {
    class Interval {
        int start;
        int end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public String addBoldTag(String s, String[] dict) {
        List<Interval> intervals = new ArrayList<>();
        // find our index of given string
        for (String word: dict) {
            // find all occurence
            int start = s.indexOf(word);
            while (start >= 0) {
                int end = start + word.length() - 1;
                Interval iv = new Interval(start, end);
                intervals.add(iv);

                // renew start index
                start = s.indexOf(word, start + 1);
            }
        }
        intervals = mergeIntervals(intervals);
        List<String> splitWords = new ArrayList<>();

        // append word
        int prev = 0;
        StringBuilder sb = new StringBuilder();
        for (Interval interval : intervals) {
        	sb.append(s.substring(prev, interval.start));
        	sb.append("<b>");
        	sb.append(s.substring(interval.start, interval.end + 1));
        	sb.append("</b>");
        	prev = interval.end + 1;
        }
        if (prev < s.length()) {
        	sb.append(s.substring(prev));
        }

        // remove consecutive bold tag
        String ans = sb.toString();
        ans = ans.replace("</b><b>", "");

        return ans;
    }

    public List<Interval> mergeIntervals(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        intervals.sort((i1, i2) -> i1.start - i2.start);

        Iterator<Interval> it = intervals.iterator();
        Interval prev = null;
        while (it.hasNext()) {
            if (prev == null) {
                prev = it.next();
            } else {
                Interval next = it.next();
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

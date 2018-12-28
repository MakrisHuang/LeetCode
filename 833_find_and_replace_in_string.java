class Solution {
    class Segment {
        int start;
        int end;
        String str;
        Segment(int start, int end, String str) {
            this.start = start;
            this.end = end;
            this.str = str;
        }
    }

    // Time Complexity: O(nlogn)
    // Space Complexity: O(n)
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        List<Segment> replaced = new ArrayList<>();
        for (int i = 0; i < indexes.length; i++) {
            int idx = indexes[i];
            String src = sources[i];
            String tar = targets[i];
            if (S.substring(idx, idx + src.length()).equals(src)) {
                Segment seg = new Segment(idx, idx + src.length(), tar);
                replaced.add(seg);
            }
        }
        replaced.sort((s1, s2) -> s1.start - s2.start);

        StringBuilder sb = new StringBuilder();
        int prev = 0;
        for (Segment seg: replaced) {
            sb.append(S.substring(prev, seg.start));
            sb.append(seg.str);
            prev = seg.end;
        }
        sb.append(S.substring(prev, S.length()));
        return sb.toString();
    }
}

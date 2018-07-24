class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();
        int idx = 0, len = s.length();
        while (idx < len) {
            char c = s.charAt(idx);
            if (c == '+') {
                if (idx + 1 < len && s.charAt(idx + 1) == '+') {
                    StringBuilder sb = new StringBuilder(s);
                    sb.setCharAt(idx, '-');
                    sb.setCharAt(idx + 1, '-');
                    result.add(sb.toString());
                }
            }
            idx++;
        }
        return result;
    }
}

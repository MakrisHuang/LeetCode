class Solution {
    public List<List<String>> groupStrings(String[] strings) {

        Map<String, List<String>> map = new HashMap<>();
        for (String s: strings) {
            String alignStr = alignHead(s);
            List<String> content;
            if (! map.containsKey(alignStr)) {
                content = new ArrayList<>();
                content.add(s);
                map.put(alignStr, content);
            } else {
                content = map.get(alignStr);
                content.add(s);
            }
        }

        // flatten map to list
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry: map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    private String alignHead(String s) {
        if (s.length() == 0) return s;
        StringBuilder sb = new StringBuilder(s);
        int distToA = s.charAt(0) - 'a';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            c = (char)((c - distToA) % 26);
            sb.setCharAt(i, c);
        }
        return sb.toString();
    }
}

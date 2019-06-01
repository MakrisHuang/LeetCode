class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anaMap = new HashMap<>();
        for (String s: strs) {
            String countedStr = countAlph(s);
            List<String> anaGroup = anaMap.getOrDefault(countedStr, new ArrayList<>());
            anaGroup.add(s);
            anaMap.put(countedStr, anaGroup);
        }
        return new ArrayList<>(anaMap.values());
    }

    private String countAlph(String s) {
        int[] count = new int[26];
        for (char c: s.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int times: count) {
            sb.append(times);
            sb.append("#");
        }
        return sb.toString();
    }
}

class Solution {
    public String mostCommonWord(String para, String[] banned) {
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        String[] words = para.replaceAll("\\pP", " ").split("\\s+");

        Map<String, Integer> map = new HashMap<>();
        String highestFreqWord = null;
        int count = Integer.MIN_VALUE;
        for (int i = 0; i < words.length; i++) {
            String str = words[i].toLowerCase();
            if (! set.contains(str)) map.put(str, map.getOrDefault(str, 0) + 1);
            if (map.containsKey(str) && map.get(str) > count) {
                count = map.get(str);
                highestFreqWord = str;
            }
        }
        return highestFreqWord;
    }
}

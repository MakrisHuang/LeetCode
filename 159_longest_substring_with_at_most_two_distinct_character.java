class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>(); // character, latest index
        int begin = 0, end = 0, ans = 0;
        int len = s.length();
        while (end < len) {
            char c = s.charAt(end);
            if (map.size() < 3) {
                map.put(c, end++);
            }

            if (map.size() == 3) {
                int removeIdx = Collections.min(map.values());
                map.remove(s.charAt(removeIdx));
                begin = removeIdx + 1;
            }

            ans = Math.max(ans, end - begin);
        }
        return ans;
    }
}

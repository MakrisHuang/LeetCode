class Solution {
    // Time Complexity: O(N)
    // Space Complexity: O(k)
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int begin = 0, end = 0, ans = 0;
        int len = s.length();
        while (end < len) {
            char c = s.charAt(end);
            if (map.size() <= k) {
                map.put(c, end++);
            }

            if (map.size() == k + 1) {
                int removeIdx = Collections.min(map.values());
                map.remove(s.charAt(removeIdx));
                begin = removeIdx + 1;
            }

            ans = Math.max(ans, end - begin);
        }
        return ans;
    }
}

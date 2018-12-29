class Solution {
    // using sliding windows with hashset as auxiliary storage
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int ans = 0, begin = 0, end = 0;
        while (begin < s.length() && end < s.length()) {
            if (! set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end++;
                ans = Math.max(ans, end - begin);
            } else {
                set.remove(s.charAt(begin));
                begin++;
            }
        }
        return ans;
    }
}

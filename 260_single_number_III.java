class Solution {
    private Map<Character, Integer> map = new HashMap<>();

    public int firstUniqChar(String s) {
        if (s.length() == 0 || s == null) return -1;

        // read all elements into map and count the times they appear
        for (int i = 0; i < s.length(); i++) {
            if (! map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }

        // read again and see the first char whose times = 1
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}

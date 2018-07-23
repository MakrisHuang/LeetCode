class Solution {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int appearOnceCount = 0;
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            int appearTimes = entry.getValue();
            appearTimes %= 2;
            if (appearTimes == 1) appearOnceCount++;
        }
        if (appearOnceCount >= 2) return false;

        return true;
    }
}

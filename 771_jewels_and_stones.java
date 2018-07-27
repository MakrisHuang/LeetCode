class Solution {
    public int numJewelsInStones(String J, String S) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < J.length(); i++) {
            char c = J.charAt(i);
            map.put(c, c);
        }
        int count = 0;
        for (int j = 0; j < S.length(); j++) {
            if (map.containsKey(S.charAt(j))) {
                count++;
            }
        }
        return count;
    }
}

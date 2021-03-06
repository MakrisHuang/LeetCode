class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Object, Integer> m = new HashMap<>();
        for (Integer i = 0; i < s.length(); i++) {
            // t.chatAt(i) + "" is for different object type
            // therefore, if we have the same character, we still get null
            Integer sValue = m.put(s.charAt(i), i);
            Integer tValue = m.put(t.charAt(i) + "", i);
            if (sValue != tValue) {
                return false;
            }
        }
        return true;
    }
}

class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || (s1.length() != s2.length())) {
            return false;
        }
        if (s1.equals(s2)) return true;

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        String newS1 = new String(c1);
        String newS2 = new String(c2);
        if (!newS1.equals(newS2)) return false;

        for (int i = 1; i < s1.length(); i++) {
            // compare the identical offset part
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
               isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            // compare the opposite part (cross-side)
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) &&
               isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) {
                return true;
            }
        }
        return false;
    }
}

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int L, int R) {
        while (L >= 0 && R < s.length()
               && Character.toLowerCase(s.charAt(L)) == Character.toLowerCase(s.charAt(R))) {
            L--;
            R++;
        }
        return R - L - 1;   // because L and R are outside of boundary character
                            // it should be (R - 1) - (L - 1) + 1 = R - L - 1
    }
}

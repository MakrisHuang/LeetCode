class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for (int len = 1; len < s.length(); len++) {
            if (s.length() % len == 0) {
                String sub = s.substring(0, len);

                int start = len;
                while (start + len <= s.length()) {
                    if (! s.substring(start, start + len).equals(sub)) {
                        break;
                    } else {
                        start += len;
                    }
                }
                if (start == s.length()) {
                    return true;
                }
            }            
        }
        return false;
    }
}
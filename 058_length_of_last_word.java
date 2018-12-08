class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        int start = s.length() - 1;
        while (start >= 0 && s.charAt(start) == ' ') {
            start--;
        }
        int length = 0;
        for (int i = start; i >= 0; i--) {
            if (s.charAt(i) == ' ') break;
            else length++;
        }
        return length;
    }
}

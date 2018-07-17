class Solution {
    public boolean checkRecord(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int absentCount = 0;
        boolean noLates = true;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == 'A'){
                absentCount++;
                i++;
            }
            else if (c == 'L') {
                int j = i + 1;
                while (j < s.length() && s.charAt(j) == 'L') j++;
                if (j - i > 2) {
                    noLates = false;
                }
                i = j;
            } else {
                i++;
            }
        }
        boolean noAbsent = absentCount <= 1;

        return noAbsent && noLates;
    }
}

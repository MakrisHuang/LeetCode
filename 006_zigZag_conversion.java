class Solution {
    public String convert(String s, int numRows) {
        if (numRows < 1) return null;
        if (numRows == 1) return s;

        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int row = 1; row <= numRows; row++) {
            // use index to complete a row
            int index = row - 1;
            int interval = numRows - 2;
            int range = numRows + interval;
            while (index < len) {
                sb.append(s.charAt(index));
                if (row == 1 || row == numRows) {
                    index += range;
                } else {  // row in middle
                    int multiply = 2;
                    int endRange = (row - 1) * multiply; // ex. 2
                    int frontRange = range - endRange; // ex .6
                    index += frontRange;  // ex. 1 + 6 = 7
                    if (index >= len) break;
                    sb.append(s.charAt(index));
                    index += endRange;
                }
            }
        }
        return sb.toString();
    }
}

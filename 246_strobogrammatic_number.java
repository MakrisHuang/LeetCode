class Solution {
    public boolean isStrobogrammatic(String num) {
        int start = 0, end = num.length() - 1;
        while (start <= end) {
            char leftChar = num.charAt(start);
            char rightChar = num.charAt(end);
            if ( ! ((leftChar == '6' && rightChar == '9') ||
                   (leftChar == '9' && rightChar == '6') || 
                   (leftChar == '8' && rightChar == '8') ||
                   (leftChar == '1' && rightChar == '1') ||
                   (leftChar == '0' && rightChar == '0'))
             ) {
                return false;
            } else {
                start++; end--;
            }
        }
        return true;
    }
}
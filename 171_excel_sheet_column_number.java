class Solution {
    public int titleToNumber(String s) {
        int sum = 0;
        int len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            int val = s.charAt(i) - 64;
            sum += Math.pow(26, len - i - 1) * val;
        }
        return sum;
    }
}

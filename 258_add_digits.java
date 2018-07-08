class Solution {
    public int addDigits(int num) {

        // How to calculate time complexity
        String s = String.valueOf(num);
        while (s.length() > 1) {
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                sum += Character.getNumericValue(s.charAt(i));
            }
            num = sum;
            s = String.valueOf(num);
        }
        return num;
    }
}

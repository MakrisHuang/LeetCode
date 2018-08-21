class Solution {
    public boolean isPowerOfThree(int n) {
        return n > 0 && n <= Integer.MAX_VALUE && 1162261467 % n == 0;
//         if (n == 1) return true;
//         if (n % 2 == 0) return false;

//         int sumOfDigits = 0;
//         String s = String.valueOf(n);
//         for (int i = 0; i < s.length(); i++) {
//             sumOfDigits += Character.getNumericValue(s.charAt(i));
//         }
//         if (sumOfDigits % 3 != 0) return false;

//         int mul = 1;
//         while (mul < n) {
//             mul *= 3;
//         }
//         if (mul != n) return false;

//         return true;
    }
}

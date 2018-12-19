class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        // use long array to prevent overflow
        long[] lShifts = new long[shifts.length];
        for (int i = 0; i < lShifts.length; i++) {
            lShifts[i] = shifts[i];
        }

        // accumulate values from back
        for (int i = lShifts.length - 2; i >= 0; i--) {
            lShifts[i] += lShifts[i + 1];
        }

        // mod 26 to get shift times
        for (int i = 0; i < lShifts.length; i++) {
            lShifts[i] %= 26;
        }

        // shift each character
        StringBuilder sb = new StringBuilder(S);
        for (int i = 0; i < lShifts.length; i++) {
            int curr = S.charAt(i) - 'a';
            curr = ((int)lShifts[i] + curr) % 26;
            sb.setCharAt(i, (char)(curr + 97));
        }

        return sb.toString();
    }
}

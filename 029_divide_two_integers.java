class Solution {
    public int divide(int dividend, int divisor) {
        boolean isNegative = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);

        long longDividend = dividend;
        long longDivisor = divisor;

        longDividend = Math.abs(longDividend);
        longDivisor = Math.abs(longDivisor);

        if (longDivisor == 0) return Integer.MAX_VALUE;
        if ((longDividend == 0) || (longDividend < longDivisor)) return 0;

        long quotient = ldivide(longDividend, longDivisor);

        int ans = 0;
        if (quotient > Integer.MAX_VALUE) {
            ans = (isNegative) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        } else {
            ans = (isNegative) ? (int) -quotient : (int) quotient;
        }
        return ans;
    }

    private long ldivide(long longDividend, long longDivisor) {
        // Recursion exit condition
        if (longDividend < longDivisor) return 0;

        //  Find the largest multiple so that (divisor * multiple <= dividend),
        //  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
        //  Think this as a binary search.
        long tempDivisor = longDivisor;
        long quotient = 1;
        while ((tempDivisor << 1) <= longDividend) {
            tempDivisor = tempDivisor << 1;
            quotient = quotient << 1;
        }
        //Look for additional value for the multiple from the reminder (dividend - sum) recursively.
        return quotient + ldivide(longDividend - tempDivisor, longDivisor);
    }
}

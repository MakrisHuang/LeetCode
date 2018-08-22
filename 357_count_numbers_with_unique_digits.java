class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int res = 1;
        for (int i = n; i > 0; i--) {
            int mul = 9;
            for (int digits = i - 1, remaining = mul; digits > 0; digits--, remaining--) {
                mul *= remaining;
            }
            res += mul;
        }

        return res;
    }
}

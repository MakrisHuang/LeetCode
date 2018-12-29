class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int curr = left; curr <= right; curr++){
            if (isSelfDivided(curr)) {
                res.add(curr);
            }
        }
        return res;
    }

    public boolean isSelfDivided(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        for (char c: digits) {
            if (c == '0') return false;

            int digit = c - '0';
            if (num % digit != 0) return false;
        }
        return true;
    }
}

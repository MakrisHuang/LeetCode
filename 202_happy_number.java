class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            int sum = calculateHappy(n);
            if (sum == 1) {
                return true;
            } else {
                n = sum;
                if (set.contains(sum)) {
                    break;
                }
                set.add(sum);
            }
        }
        return false;
    }

    private int calculateHappy(int val) {
        int sum = 0;
        while (val > 0) {
            int digit = val % 10;
            sum += digit * digit;
            val /= 10;
        }
        return sum;
    }
}

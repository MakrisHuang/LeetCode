class Solution {
    public int findMaxForm(String[] strs, int zeros, int ones) {
        int[][] dp = new int[zeros + 1][ones + 1];

        for (String str: strs) {
            int[] count = calZerosOnes(str, zeros, ones);
            for (int zero = zeros; zero >= count[0]; zero--) {
                for (int one = ones; one >= count[1]; one--) {
                    dp[zero][one] = Math.max(1 + dp[zero - count[0]][one - count[1]], dp[zero][one]);
                }
            }
        }

        return dp[zeros][ones];
    }

    private int[] calZerosOnes(String s, int zeros, int ones) {
        int[] c = new int[2];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - '0']++;
        }
        return c;
    }
}

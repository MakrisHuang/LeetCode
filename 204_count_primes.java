class Solution {
    public int countPrimes(int n) {
        if (n == 0 || n == 1) return 0;

        boolean visit[] = new boolean[n + 1];
        for (int i = 1; i < visit.length; i++) visit[i] = true;
        visit[1] = false;

        int max = (int)Math.sqrt(n);
        for (int i = 2; i <= max; i++) {
            if (visit[i]) {
                for (int multiply = i * 2; multiply <= n; multiply += i) {
                    visit[multiply] = false;
                }
            }
        }

        int count = 0;
        for (int i = 1; i < n; i++) {
            if (visit[i]) count++;
        }

        return count;
    }
}

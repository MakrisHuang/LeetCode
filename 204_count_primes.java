class Solution {
    // apply method Sieve of Eratosthenes
    // https://zh.wikipedia.org/wiki/埃拉托斯特尼筛法
    public int countPrimes(int n) {
        if (n == 0 || n == 1) return 0;

        boolean visit[] = new boolean[n + 1];
        for (int i = 1; i < visit.length; i++) visit[i] = true;
        visit[1] = false;

        int max = (int)Math.sqrt(n);
        for (int i = 2; i <= max; i++) {
            if (visit[i]) {
                // find the multiplication of current `i`

                // init multiply with 2 times of i because i is prime so do not mark it as false
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

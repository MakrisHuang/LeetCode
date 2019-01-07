class Solution {
    /*
    T[7]: 73
    warmIdx: 2147483647
    T[6]: 76
    warmIdx: 2147483647
    T[5]: 72
    next[73]: 7
    next[76]: 6
    warmIdx: 6
    T[4]: 69
    next[72]: 5
    warmIdx: 5
    T[3]: 71
    next[72]: 5
    warmIdx: 5
    T[2]: 75
    next[76]: 6
    warmIdx: 6
    T[1]: 74
    next[75]: 2
    warmIdx: 2
    T[0]: 73
    next[74]: 1
    warmIdx: 1
    */
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);
        for (int i = T.length - 1; i >= 0; --i) {
            int warmer_index = Integer.MAX_VALUE;
            System.out.println("T[" + i + "]: " + T[i]);
            for (int t = T[i] + 1; t <= 100; ++t) {
                if (next[t] < warmer_index) {
                    System.out.println("next[" + t + "]: " + next[t]);
                    warmer_index = next[t];
                }
            }
            System.out.println("warmIdx: " + warmer_index);
            if (warmer_index < Integer.MAX_VALUE)
                ans[i] = warmer_index - i;
            next[T[i]] = i;
        }
        return ans;
    }
}

class Solution {
    public String reorganizeString(String S) {
        int N = S.length();
        int[] counts = new int[26];
        for (char c: S.toCharArray()) {
            counts[c - 'a'] += 100;
        }
        for (int i = 0; i < 26; i++) {
            counts[i] += i;
        }
        Arrays.sort(counts);

        char[] ans = new char[N];
        int t = 1;
        for (int code: counts) {
            int codeCount = code / 100;
            char ch = (char) ('a' + (code % 100));
            if (codeCount > (N + 1) / 2) return ""; // no possible outupt since more than half of characters
            for (int i = 0; i < codeCount; i++) {
                if (t >= N) t = 0;  // from even position
                ans[t] = ch;
                t += 2;
            }
        }
        return String.valueOf(ans);
    }
}

class Solution {
    /*
    There can be three conditions:
1, word1[i] == word2[j] : then no operation needed. dp[i][j] == dp[i-1][j-1]

2, Do one operation on word1[i-1][j]. dp[i][j] = dp[i-1][j] + 1
3, Do one operation on word2[i][j-1]. dp[i][j] = dp[i][j-1] + 1

for 2 and 3, the reason it works is that we know the optimal ways to transfrom word1(0,i) to word2(0,j-1) and word1(0,i-1) to word(0,j) ( Delete ("abc" to "ab") or Insert ("ab" to "abc") ). Now all we need to one more operation.

    Time Complexity: O(len(word1) * len(word2))
    Space Complexity: O(len(word1) * len(word2))
    */
    public int minDistance(String word1, String word2) {
        if (word1.equals(word2)) {
            return 0;
        }
        if (word1.length() == 0 || word2.length() == 0) {
            return Math.abs(word1.length() - word2.length());
        }
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}

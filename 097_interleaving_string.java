class Solution {
    // Time Complexity: O(m * n) to fill dp array
    // Space Complexity: O(m * n)
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

//     public boolean recursiveCheck (String s1, int i, String s2, int j, String res, String s3) {
//         if (res.equals(s3) && i == s1.length() && j == s2.length()) {
//             return true;
//         }
//         boolean ans = false;
//         if (i < s1.length()) {
//             ans |= recursiveCheck(s1, i + 1, s2, j, res + s1.charAt(i), s3);
//         }
//         if (j < s2.length()) {
//             ans |= recursiveCheck(s1, i, s2, j + 1, res + s2.charAt(j), s3);
//         }
//         return ans;
//     }

//     public boolean isInterleave(String s1, String s2, String s3) {
//         return recursiveCheck(s1, 0, s2, 0, "", s3);
//     }
}

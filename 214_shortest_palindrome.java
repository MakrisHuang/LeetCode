class Solution {
    // Time complexity: O(n ^ 2)
    public String shortestPalindrome(String s) {
        // find the longst palindrome substring in s
        int len = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < s.length(); i++) {
            // ex. s = aacecaaa
            //   rev = aaacecaa
            // when i = 1, we found out the longest palindrome
            // hence, return remaining segment of rev and s
            if (s.substring(0, len - i).equals(rev.substring(i, len))) {
                return rev.substring(0, i) + s;
            }
        }
        return "";
    }
}
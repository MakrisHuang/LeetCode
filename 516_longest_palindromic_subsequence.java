class Solution {
    // use memorization to record the number of characters in subsequence
    // given left and right indexes
    // n = len(s) => Time Complexity: O(n^2), Space Complexity: O(n^2);
    public int longestPalindromeSubseq(String s) {
        Integer[][] mem = new Integer[s.length()][s.length()];
        return findLongestPalindromeSeq(0, s.length() - 1, s, mem);
    }

    public int findLongestPalindromeSeq(int left, int right, String s, Integer[][] mem) {
        if (left == right) return 1;
        if (left > right) return 0;
        if (mem[left][right] != null) return mem[left][right];

        return mem[left][right] = ((s.charAt(left) == s.charAt(right)) ?
            2 + findLongestPalindromeSeq(left + 1, right - 1, s, mem) :
            Math.max(findLongestPalindromeSeq(left + 1, right, s, mem), findLongestPalindromeSeq(left, right - 1, s, mem)));
    }
}

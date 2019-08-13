class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        i, r, d = 0, 0, {}
        for index, c in enumerate(s):
            # use dict to record last occurrence of character
            i, r, d[c] = max(i, d.get(c, -1) + 1), max(r, index - i), index
        return max(r, len(s) - i)

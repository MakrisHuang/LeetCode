class Solution:
    def maxLengthBetweenEqualCharacters(self, s: str) -> int:
        charToMinPos = {}
        charToMaxPos = {}
        for index, c in enumerate(s):
            if c not in charToMinPos:
                charToMinPos[c] = index
            else:
                charToMaxPos[c] = index
        longest = -1
        for c in s:
            if c in charToMinPos and c in charToMaxPos:
                length = charToMaxPos[c] - charToMinPos[c] - 1
                longest = max(longest, length)
        return longest

class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        last = len(s)
        while last > 0 and s[last - 1] == ' ':
            last = last - 1
        length = 0
        while last > 0 and s[last - 1] != ' ':
            last = last - 1
            length = length + 1
        return length

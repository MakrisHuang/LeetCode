class Solution:
    def titleToNumber(self, s: str) -> int:
        res = 0
        for num in s:
            res = res * 26 + (ord(num) - ord('A') + 1)
        return res

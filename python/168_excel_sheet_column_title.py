class Solution:
    def convertToTitle(self, n: int) -> str:
        res = ""
        while n:
            res = chr((n - 1) % 26 + ord('A')) + res
            n = int((n - 1) / 26)
        return res


class Solution:
    def addBinary(self, a: str, b: str) -> str:
        num = int(a, 2) + int(b, 2)
        new_bin = bin(num)
        return new_bin[2:]

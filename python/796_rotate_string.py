class Solution:
    def rotateString(self, A: str, B: str) -> bool:
        if len(A) != len(B): return False
        BB = B + B
        return BB.find(A) != -1

class Solution:
    # apply fast power: conduct square every time
    # if it's too large, reduce it
    # Time Complexity: O(logn)
    # Space Complexity: O(logn) (because recursion)
    def myPow(self, x: float, n: int) -> float:
        def pow(cand: float, n: int):
            if n == 0:
                return 1.0
            else:
                return pow(cand * cand, n // 2) if n % 2 == 0 else \
                    cand * pow(cand * cand, n // 2)

        if n == 0:
            return 1.0
        if n < 0:
            x = 1.0 / x
            n = -n
        return pow(x, n)

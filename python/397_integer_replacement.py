class Solution:
    def integerReplacement(self, n: int) -> int:
        res = 0
        while n > 1:
            res += 1
            if n % 2 == 0:              # f(1) = 0, f(2n) = 1 + f(n), f(2n + 1) = min(f(2n) + 1, f(2n + 2) + 1)
                n = n // 2              # f(2n + 1) = min(f(2n) + 1, f(n + 1) + 2)
            elif n % 4 == 1 or n == 3:  # n % 4 = 3 and n != 3,then f(n) = f(n+1)+1.
                n -= 1                  # If n % 4 = 1 or n = 3, then f(n) = f(n - 1) + 1.
            else:
                n += 1
        return res


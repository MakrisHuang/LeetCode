class Solution:
    def reverse(self, x: int) -> int:
        num = -x if x < 0 else x
        res = 0
        while num > 0:
            res = res * 10 + num % 10
            num = int(num / 10)
        if res > 0x7fffffff:
            return 0
        return res if x > 0 else -res

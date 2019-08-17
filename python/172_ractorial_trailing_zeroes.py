class Solution:
    # def trailingZeroes(self, n: int) -> int:
    #     r = 0
    #     while n:
    #         n = int(n / 5)
    #         r += n
    #     return r

    def trailingZeroes(self, n: int) -> int:
        r = 0
        poly = 5
        while int(n / poly) > 0:
            r += int(n / poly)
            poly *= 5
        return r


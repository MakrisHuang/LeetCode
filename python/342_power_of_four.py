from math import log2
class Solution:
    # if x = 4 ^ a, then a = log_4 x = (log_2 x) / 2
    # so check if log2(num) is an even number will be enough
    def isPowerOfFour(self, num: int) -> bool:
        return num > 0 and log2(num) % 2 == 0

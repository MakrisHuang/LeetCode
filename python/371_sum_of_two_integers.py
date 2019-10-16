class Solution:
    def getSum(self, a: int, b: int) -> int:
        # 32 bits integer max
        MAX = 0x7FFFFFFF
        # 32 bits interger min
        MIN = 0x80000000
        # mask to get last 32 bits
        mask = 0xFFFFFFFF

        while b != 0:
            # ^ get different bits and & gets double 1s, << moves carry
            a, b = (a ^ b) & mask, ((a & b) << 1) & mask
        # if a is negative, get a's 32 bits complement positive first
        # then get 32-bit positive's Python complement negative
        return a if a <= MAX else ~(a ^ mask)
        """
        1.Why carry is a&b:
If a and b are both 1 at the same digit, it creates one carry.
Because you can only use 0 and 1 in binary, if you add 1+1 together, it will roll that over to the next digit, and the value will be 0 at this digit.
if they are both 0 or only one is 1, it doesn't need to carry.
        """

        """
        Use ^ operation between a and b to find the different bit
In my understanding, using ^ operator is kind of adding a and b together (a+b) but ignore the digit that a and b are both 1,
because we already took care of this in step1.
        """

        """
        every time we have two 1's in the same position
        we can generate a carry
        and a carry is applied to next left position
        if next time no carry is generate, we know that the addition
        is always valid, and then we can leave the loop
        """

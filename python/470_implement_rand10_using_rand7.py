# The rand7() API is already defined for you.
# def rand7():
# @return a random integer in the range 1 to 7

class Solution:
    # apply rejection sampling
    def rand10(self):
        """
        :rtype: int
        """
        x, y ,ret = 0, 0, 0
        while True:
            x = rand7()
            y = rand7()
            ret = (x-1) * 7 + y
            if ret<=40:
                break
        return ret % 10 + 1

# The knows API is already defined for you.
# @param a, person a
# @param b, person b
# @return a boolean, whether a knows b
# def knows(a, b):

class Solution(object):
    def findCelebrity(self, n):
        """
        :type n: int
        :rtype: int
        """
        celebrity = 0
        for i in range(1, n):
            if knows(celebrity, i):
                celebrity = i

        for i in range(n):
            if celebrity != i:
                if knows(celebrity, i):
                    return -1
                if not knows(i, celebrity):
                    return -1

        return celebrity


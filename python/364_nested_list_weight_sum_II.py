# """
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
#class NestedInteger:
#    def __init__(self, value=None):
#        """
#        If value is not specified, initializes an empty list.
#        Otherwise initializes a single integer equal to value.
#        """
#
#    def isInteger(self):
#        """
#        @return True if this NestedInteger holds a single integer, rather than a nested list.
#        :rtype bool
#        """
#
#    def add(self, elem):
#        """
#        Set this NestedInteger to hold a nested list and adds a nested integer elem to it.
#        :rtype void
#        """
#
#    def setInteger(self, value):
#        """
#        Set this NestedInteger to hold a single integer equal to value.
#        :rtype void
#        """
#
#    def getInteger(self):
#        """
#        @return the single integer that this NestedInteger holds, if it holds a single integer
#        Return None if this NestedInteger holds a nested list
#        :rtype int
#        """
#
#    def getList(self):
#        """
#        @return the nested list that this NestedInteger holds, if it holds a nested list
#        Return None if this NestedInteger holds a single integer
#        :rtype List[NestedInteger]
#        """

class Solution:
    def __init__(self):
        self.deepest = 0

    def depthSumInverse(self, nestedList: List[NestedInteger]) -> int:

        def findDeepest(nestedList: List[NestedInteger], depth: int):
            for integer in nestedList:
                if integer.isInteger():
                    self.deepest = max(self.deepest, depth)
                else:
                    findDeepest(integer.getList(), depth + 1)

        def getWeightSum(nestedList: List[NestedInteger], level: int):
            res = 0
            for integer in nestedList:
                if integer.isInteger():
                    res += integer.getInteger() * level
                else:
                    res += getWeightSum(integer.getList(), level - 1)
            return res

        findDeepest(nestedList, 1)
        return getWeightSum(nestedList, self.deepest)



import operator

class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        seen = {}
        for i in nums:
            seen.setdefault(i, 0)
            seen[i] += 1
        return max(seen.items(), key=operator.itemgetter(1))[0]

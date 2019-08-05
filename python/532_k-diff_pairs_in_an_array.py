class Solution:
    def findPairs(self, nums: List[int], k: int) -> int:
        if k > 0:
            return len(set(nums) & set(n + k for n in nums))
        elif k == 0:
            return sum(v > 1 for v in collections.Counter(nums).values())
        else:
            return 0

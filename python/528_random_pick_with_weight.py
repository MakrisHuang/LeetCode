class Solution:
    import random
    import bisect

    def __init__(self, w: List[int]):
        self.range = w
        for i in range(1, len(w)):
            self.range[i] = self.range[i - 1] + w[i]

    def pickIndex(self) -> int:
        rand_val = random.randrange(0, self.range[-1])
        return bisect.bisect(self.range, rand_val)

# Your Solution object will be instantiated and called as such:
# obj = Solution(w)
# param_1 = obj.pickIndex()

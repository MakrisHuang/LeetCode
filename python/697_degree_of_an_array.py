import operator
class Solution:
    # Time Complexity: O(N)
    # Space Complexity: O(N)
    def findShortestSubArray(self, nums: List[int]) -> int:
        s = collections.defaultdict(lambda: (-1,-1))
        for i, num in enumerate(nums):
            start, end = s[num]
            if start == -1:
                end = start = i
            else:
                end = i
            s[num] = (start, end)

        count_map = collections.Counter(nums)
        max_freq = max(count_map.items(), key=operator.itemgetter(1))[1]
        cands = []
        for key, value in count_map.items():
            if value == max_freq:
                cands.append(key)

        shortest = len(nums)
        for key in cands:
            start, end = s[key]
            dist = end - start + 1
            shortest = min(shortest, dist)
        return shortest

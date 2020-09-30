class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        countMap = dict(collections.Counter(words))
        from heapq import heappush, heappop
        q = []
        for key, value in countMap.items():
            heappush(q, [-value, key]) # first compare times, and compare key if the same frequency
        res = []
        while k > 0 and q:
            res.append(heappop(q)[1])
            k -= 1
        return res


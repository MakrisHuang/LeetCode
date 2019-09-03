from heapq import heappush, heappop

class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        d = collections.defaultdict(int)
        for word in words:
            d[word] += 1

        q = []
        for key, value in d.items():
            heappush(q, [-value, key])

        res = []
        while k > 0:
            res.append(heappop(q)[1])
            k -= 1

        return res



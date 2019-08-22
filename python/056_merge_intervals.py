class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        from operator import itemgetter
        intervals = sorted(intervals, key=itemgetter(0))

        res = []
        prev = None
        for next in intervals:
            if not prev:
                prev = next
            else:
                if prev[1] >= next[0]:
                    prev[1] = max(prev[1], next[1])
                else:
                    res.append(prev)
                    prev = next
        if prev:
            res.append(prev)
        return res


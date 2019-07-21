class Solution:
    def longestWPI(self, hours: List[int]) -> int:
        res = score = 0
        seen = {}
        for i, val in enumerate(hours):
            score = score + 1 if val > 8 else score - 1
            if score > 0:
                res = i + 1
            else:
                seen.setdefault(score, i)
                if score - 1 in seen:
                    res = max(res, i - seen[score - 1])
        return res

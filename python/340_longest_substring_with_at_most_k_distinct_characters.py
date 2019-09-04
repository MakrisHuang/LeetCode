class Solution:
    def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
        d = collections.defaultdict(int)

        begin = end = 0
        res = 0
        while end < len(s):
            end_c = s[end]
            d[end_c] += 1
            end += 1

            while len(d) > k:
                begin_c = s[begin]
                d[begin_c] -= 1
                if d[begin_c] == 0:
                    del d[begin_c]
                begin += 1

            if len(d) <= k:
                res = max(res, end - begin)
        return res

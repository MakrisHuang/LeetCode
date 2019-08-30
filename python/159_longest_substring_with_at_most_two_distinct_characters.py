class Solution:
    def lengthOfLongestSubstringTwoDistinct(self, s: str) -> int:
        if not s: return 0
        from collections import defaultdict
        m = defaultdict(int)

        begin = end = counter = 0
        max_len = 0
        while end < len(s):
            # add right character
            end_char = s[end]
            m[end_char] += 1
            end += 1

            while len(m) > 2:
                begin_char = s[begin]
                m[begin_char] -= 1
                if m[begin_char] == 0:
                    del m[begin_char]
                begin += 1

            if len(m) <= 2:
                max_len = max(max_len, end - begin)

        return max_len

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        from collections import defaultdict
        repeat_map = defaultdict(int)
        begin = end = counter = dist = 0

        while end < len(s):
            end_char = s[end]
            repeat_map[end_char] += 1
            if repeat_map[end_char] > 1:
                counter += 1
            end += 1

            while counter > 0:
                begin_char = s[begin]
                if repeat_map[begin_char] > 1:
                    counter -= 1
                repeat_map[begin_char] -= 1
                begin += 1

            dist = max(dist, end - begin)
        return dist

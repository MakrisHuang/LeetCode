class Solution:
    def firstUniqChar(self, s: str) -> int:
        counter_map = dict(collections.Counter(s))
        for i in range(len(s)):
            if counter_map[s[i]] == 1:
                return i
        return -1

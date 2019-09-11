class Solution:
    def minWindow(self, s: str, t: str) -> str:
        map = dict(collections.Counter(t))
        counter = len(map)

        head = begin = end = 0
        min_len = float('inf')
        while end < len(s):
            temp = s[end]
            if temp in map:
                map[temp] = map[temp] - 1
                if map[temp] == 0:
                    counter -= 1

            end += 1

            while counter == 0:
                temp_b = s[begin]
                if temp_b in map:
                    map[temp_b] = map[temp_b] + 1
                    if map[temp_b] > 0:
                        counter += 1
                if end - begin < min_len:
                    min_len = end - begin
                    head = begin
                begin += 1

        if min_len == float('inf'): return ""
        return s[head:head + min_len]

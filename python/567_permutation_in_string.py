class Solution:
    def checkInclusion_checkLength(self, s1: str, s2: str) -> bool:
        map = dict(collections.Counter(s1))
        counter = len(map)

        begin = end = 0
        min_len = float('inf')
        while end < len(s2):
            cand = s2[end]
            if cand in map:
                map[cand] -= 1
                if map[cand] == 0:
                    counter -= 1
            end += 1

            while counter == 0:
                temp = s2[begin]
                if temp in map:
                    map[temp] += 1
                    if map[temp] > 0:
                        counter += 1

                if end - begin < min_len:
                    min_len = end - begin
                begin += 1
        return min_len == len(s1)

    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2): return False
        s1_map = [0 for _ in range(26)]
        s2_map = [0 for _ in range(26)]
        for i in range(len(s1)):
            s1_map[ord(s1[i]) - ord('a')] += 1
            s2_map[ord(s2[i]) - ord('a')] += 1
        for i in range(len(s2) - len(s1)):
            if self.matches(s1_map, s2_map):
                return True
            s2_map[ord(s2[i]) - ord('a')] -= 1
            s2_map[ord(s2[i + len(s1)]) - ord('a')] += 1
        return self.matches(s1_map, s2_map)

    def matches(self, s1_map: List[int], s2_map: List[int]):
        for i in range(26):
            if s1_map[i] != s2_map[i]:
                return False
        return True

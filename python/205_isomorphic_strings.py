class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        s_map, t_map = dict(), dict()
        if len(s) != len(t):
            return False
        for i in range(0, len(s)):
            if (s[i] in s_map and s_map[s[i]] != t[i]) or (t[i] in t_map and t_map[t[i]] != s[i]):
                return False
            else:
                s_map[s[i]] = t[i]
                t_map[t[i]] = s[i]
        return True


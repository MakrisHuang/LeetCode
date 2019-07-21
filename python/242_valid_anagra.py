class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        seen = dict()
        for c in s:
            seen.setdefault(c, 0)
            seen[c] += 1

        for c in t:
            if c in seen:
                seen[c] -= 1
                if seen[c] == 0:
                    del seen[c]
            else:
                seen.setdefault(c, 0)

        return len(seen) == 0

class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        if not p:
            return s == ""
        first_match = (s != "" and (p[0] == s[0] or p[0] == "."))

        if len(p) >= 2 and p[1] == "*": # able to match more
            # no match
            return self.isMatch(s, p[2:]) or (first_match and self.isMatch(s[1:], p))  # match first, but can keep match
        else:   # only left 1 to match
            return first_match and self.isMatch(s[1:], p[1:])

class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g.sort()
        s.sort()
        content_children = 0
        cookie_idx = 0
        while content_children < len(g) and cookie_idx < len(s):
            content_children += (s[cookie_idx] >= g[content_children])
            cookie_idx += 1
        return content_children

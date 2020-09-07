class Solution:
    def licenseKeyFormatting(self, S: str, K: int) -> str:
        if not S:
            return ''
        s = S.replace('-', '').upper()
        start = len(s) % K
        res = s[:start]
        for i in range(start, len(s), K):
            res += ('-' if i > 0 else '') + s[i:i+K]
        return res

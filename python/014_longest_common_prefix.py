class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not strs: return ""
        prefix = strs[0]
        for index, cand in enumerate(strs):
            while not strs[index].startswith(prefix):
                prefix = prefix[0:len(prefix) - 1]
                if len(prefix) <= 0: return ""
        return prefix

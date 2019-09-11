class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not strs:
            return ""
        prefix = strs[0]
        while True:
            is_prefix = True
            for index, cand in enumerate(strs):
                if not cand.startswith(prefix):
                    prefix = prefix[0:len(prefix) - 1]
                    is_prefix = False
                    break
            if is_prefix:
                break
        return prefix


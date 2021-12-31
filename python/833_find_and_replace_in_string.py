class Solution:
    def findReplaceString(self, s: str, indices: List[int], sources: List[str], targets: List[str]) -> str:
        new_s = list(s)
        for i, source, target in sorted(zip(indices, sources, targets)):
            if not s[i:].startswith(source):
                continue
            else:
                new_s[i] = target
                for j in range(i + 1, i + len(source)):
                    new_s[j] = ""
        return "".join(new_s)

class Solution:
    def diStringMatch(self, S: str) -> List[int]:
        num_I = 0
        num_D = len(S)
        res = []
        for c in S:
            if c == 'I':
                res.append(num_I)
                num_I += 1
            elif c == 'D':
                res.append(num_D)
                num_D -= 1
        res.append(num_I)
        return res


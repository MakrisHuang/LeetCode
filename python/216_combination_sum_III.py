class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        # each combinataion should have unique numbers
        # so we know the max length of a combination is 9 (given 1 to 9 are used)
        # and the max n would be 1 + 2 + 3 ... + 9 = 45
        # any n > 45 will return [] regardless k
        # on the other hand, any k > 9, we will return []
        if k > 9 or n > 45: return []

        def backtrace(res: List[List[int]], ans: List[int], curr: int, accum: int,
                      k: int, n: int, cand: List[int]):
            if len(ans) == k and accum == n:
                res.append(list(ans))
            if accum < n:
                for i in range(curr, len(cand)):
                    ans.append(cand[i])
                    accum += cand[i]
                    backtrace(res, ans, i + 1, accum, k, n, cand)
                    ans.pop()
                    accum -= cand[i]

        res = []
        cand = [i for i in range(1, 10)]
        backtrace(res, [], 0, 0, k, n, cand)
        return res

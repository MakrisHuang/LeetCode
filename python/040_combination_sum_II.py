class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        def backtrace(cand: List[int], res: List[List[int]], temp: List[int], curr: int, target: int, start: int):
            if curr > target:
                return
            if curr == target:
                res.append(list(temp))
            for i in range(start, len(cand)):
                if i > start and cand[i] == cand[i - 1]: continue
                temp.append(cand[i])
                backtrace(cand, res, temp, curr + cand[i], target, i + 1)
                temp.pop()

        candidates.sort()
        res = []
        backtrace(candidates, res, [], 0, target, 0)
        return res

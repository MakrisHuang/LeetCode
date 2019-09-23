class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        # apply backtrace

        def backtrace(cand: List[int], res: List[List[int]], temp: List[int], curr: int, target: int, start: int):
            if curr > target:
                return
            if curr == target:
                res.append(list(temp))
                return
            for i in range(start, len(cand)):
                temp.append(cand[i])
                backtrace(cand, res, temp, curr + cand[i], target, i)
                temp.pop()

        res = []
        backtrace(candidates, res, [], 0, target, 0)
        return res


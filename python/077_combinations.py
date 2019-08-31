class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        res = []
        self.backtrace(res, [], n, k, 1)
        return res

    def backtrace(self, res: List[List[int]], temp: List[int], n: int, k: int, start: int):
        if len(temp) == k:
            res.append(list(temp))
            return
        for i in range(start, n + 1):
            temp.append(i)
            self.backtrace(res, temp, n, k, i + 1)
            temp.pop()


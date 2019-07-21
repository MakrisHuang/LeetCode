class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        self.backtrace(n, 0, 0, "", res)
        return res

    def backtrace(self, n, open_count, close_count, ans: str, res: List[str]):
        if len(ans) == 2 * n:
            res.append(ans)
            return

        if open_count < n:
            self.backtrace(n, open_count + 1, close_count, ans + "(", res)
        if close_count < open_count:
            self.backtrace(n, open_count, close_count + 1, ans + ")", res)

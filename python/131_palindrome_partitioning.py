class Solution:
    def partition(self, s: str) -> List[List[str]]:
        def isPalindrome(s: str, i: int, j: int):
            return all(s[k] == s[j - k + i] for k in range(i, j))

        def backtrace(s: str, res: List[List[str]], ans: List[str], curr: int):
            if curr == len(s):
                res.append(list(ans))
            for i in range(curr, len(s)):
                if isPalindrome(s, curr, i):
                    ans.append(s[curr:i + 1])
                    backtrace(s, res, ans, i + 1)
                    ans.pop()
        res = []
        backtrace(s, res, [], 0)
        return res

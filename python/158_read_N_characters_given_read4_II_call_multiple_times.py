# The read4 API is already defined for you.
# def read4(buf4: List[str]) -> int:
# reference: https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/discuss/193873/Most-elegant-and-simple-solution-in-Python
class Solution:
    def __init__(self):
        self.q = collections.deque()

    def read(self, buf: List[str], n: int) -> int:
        total = 0
        while total < n:
            if self.q:
                buf[total] = self.q.popleft()
                total += 1
            else:
                buf4 = [''] * 4
                num_read = read4(buf4)
                if num_read == 0:
                    break
                for i in range(num_read):
                    self.q.append(buf4[i])
        return total

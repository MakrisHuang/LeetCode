class RLEIterator:

    def __init__(self, A: List[int]):
        self.A = A
        self.idx = 0

    def next(self, n: int) -> int:
        while self.idx < len(self.A) and n > self.A[self.idx]:
            n -= self.A[self.idx]
            self.idx += 2

        if self.idx >= len(self.A):
            return -1

        self.A[self.idx] -= n
        return self.A[self.idx + 1]


# Your RLEIterator object will be instantiated and called as such:
# obj = RLEIterator(A)
# param_1 = obj.next(n)

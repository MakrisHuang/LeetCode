class MovingAverage:

    def __init__(self, size: int):
        """
        Initialize your data structure here.
        """
        self.sum = 0
        self.size = size
        self.q = []

    def next(self, val: int) -> float:
        if len(self.q) == self.size:
            self.sum -= self.q.pop(0)
        self.sum += val
        self.q.append(val)
        return self.sum / len(self.q)

# Your MovingAverage object will be instantiated and called as such:
# obj = MovingAverage(size)
# param_1 = obj.next(val)

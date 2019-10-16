class StockSpanner:

    def __init__(self):
        self.stack = []

    def next(self, price: int) -> int:
        # maintain a decreasing stack
        # for pushing an element, record the times of elements
        # which are smaller than curr
        res = 1
        while self.stack and self.stack[-1][0] <= price:
            res += self.stack.pop()[1]
        self.stack.append((price, res))
        return res

# Your StockSpanner object will be instantiated and called as such:
# obj = StockSpanner()
# param_1 = obj.next(price)

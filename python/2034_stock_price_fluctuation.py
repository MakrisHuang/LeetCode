import heapq
class StockPrice:

    """
    Use two heap to track the previous largest and smallest elements
    """
    def __init__(self):
        self.timestampToPrice = {}
        self.minHeap = []
        self.maxHeap = []
        self.curr_timestamp = None

    def update(self, timestamp: int, price: int) -> None:
        self.timestampToPrice[timestamp] = price
        if not self.curr_timestamp or timestamp >= self.curr_timestamp:
            self.curr_timestamp = timestamp
        heapq.heappush(self.maxHeap, (-price, timestamp))
        heapq.heappush(self.minHeap, (price, timestamp))

    def current(self) -> int:
        return self.timestampToPrice[self.curr_timestamp]

    def maximum(self) -> int:
        # since the first element in the max heap is the largest,
        # if we don't see the same price, then there must be updates after it
        # therefore pop the previous records
        while self.timestampToPrice[self.maxHeap[0][1]] != -self.maxHeap[0][0]: heapq.heappop(self.maxHeap)
        return -self.maxHeap[0][0]

    def minimum(self) -> int:
        # same logics for maximum()
        while self.timestampToPrice[self.minHeap[0][1]] != self.minHeap[0][0]: heapq.heappop(self.minHeap)
        return self.minHeap[0][0]


# Your StockPrice object will be instantiated and called as such:
# obj = StockPrice()
# obj.update(timestamp,price)
# param_2 = obj.current()
# param_3 = obj.maximum()
# param_4 = obj.minimum()

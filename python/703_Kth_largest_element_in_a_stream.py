class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        self.queue = nums
        self.k = k
        heapq.heapify(self.queue)
        print(self.queue)
        while len(self.queue) > k:
            heapq.heappop(self.queue)

    def add(self, val: int) -> int:
        if len(self.queue) < self.k:
            heapq.heappush(self.queue, val)
        else:
            heapq.heappushpop(self.queue, val)
        return self.queue[0]

# Your KthLargest object will be instantiated and called as such:
# obj = KthLargest(k, nums)
# param_1 = obj.add(val)

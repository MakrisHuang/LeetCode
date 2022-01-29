import heapq
class Solution:
    def connectSticks(self, sticks: List[int]) -> int:
        if len(sticks) == 1: return 0
        minHeap = []
        for s in sticks:
            heapq.heappush(minHeap, s)

        cost = 0
        while len(minHeap) > 1:
            stick1 = heapq.heappop(minHeap)
            stick2 = heapq.heappop(minHeap)
            new_stick = stick1 + stick2
            cost += new_stick
            heapq.heappush(minHeap, new_stick)
        return cost

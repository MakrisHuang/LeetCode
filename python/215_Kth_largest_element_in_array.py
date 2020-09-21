class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        from heapq import heappush, heappop
        queue = []
        for num in nums:
            heappush(queue, [-num, num])
        ans = None
        while k > 0:
            ans = heappop(queue)[1]
            k -= 1
        return ans

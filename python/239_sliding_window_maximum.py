class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        q = collections.deque()
        res = []
        for i, n in enumerate(nums):
            # ensure the largest is at the end of queue
            while q and nums[q[-1]] <= n:
                q.pop()

            q.append(i)

            if i - q[0] >= k:
                q.popleft()

            # means the queue is ready to provide answer
            if i + 1 >= k:
                res.append(nums[q[0]])

        return res

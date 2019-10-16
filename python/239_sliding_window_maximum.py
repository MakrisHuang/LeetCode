class Solution:
    # maintain a decreasing queue that the value in the left
    # is always the largest one during this window
    # Time Complexity: O(N)
    # Space Complexity: O(N)
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        q = collections.deque()
        res = []
        for i, n in enumerate(nums):
            # ensure the largest is at the end of queue
            while q and nums[q[-1]] <= n:
                q.pop()

            q.append(i)

            # ensure that q has the right size
            if i - q[0] >= k:
                q.popleft()

            # means the queue is ready to provide answer
            # window size must >= 1
            if i + 1 >= k:
                res.append(nums[q[0]])

        return res

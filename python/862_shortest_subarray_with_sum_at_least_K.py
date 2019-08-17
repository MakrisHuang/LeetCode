class Solution:
    def shortestSubarray(self, A: List[int], K: int) -> int:
        N = len(A)
        B = [0] * (N + 1)
        for i in range(N): B[i + 1] = B[i] + A[i]

        q = collections.deque()
        res = N + 1
        for i in range(N + 1):
            while q and B[i] - B[q[0]] >= K:
                res = min(res, i - q.popleft())
            """
            If B[i] <= B[d.back()] and moreover we already know that i > d.back(), it means that compared with d.back(), B[i] can help us make the subarray length shorter and sum bigger. So no need to keep d.back() in our deque.
            """
            while q and B[i] < B[q[-1]]:
                q.pop()
            q.append(i)
        return res if res <= N else -1

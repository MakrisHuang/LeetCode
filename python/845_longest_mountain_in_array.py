class Solution:
    def longestMountain(self, A: List[int]) -> int:
        base = 0
        ans = 0

        while base < len(A):
            end = base

            # check if is the left-boundary
            if end + 1 < len(A) and A[end] < A[end + 1]:
                # keep find the peak
                while end + 1 < len(A) and A[end] < A[end + 1]:
                    end += 1

                # check if is the right boundary
                if end + 1 < len(A) and A[end] > A[end + 1]:
                    # keep finding the valley
                    while end + 1 < len(A) and A[end] > A[end + 1]:
                        end += 1
                    ans = max(ans, end - base + 1)

            base = max(end, base + 1)
        return ans

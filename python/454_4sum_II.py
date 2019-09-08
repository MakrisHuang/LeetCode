class Solution:
    # Use a dict to keep sum of A, B
    # and iterate C and D to find out another sum equals to negative sum in the dict
    # Time Complexity: O(N ^ 2)
    # Space Complexity: O(4N)
    def fourSumCount(self, A: List[int], B: List[int], C: List[int], D: List[int]) -> int:
        d = collections.defaultdict(int)
        res = 0

        for i in range(len(A)):
            for j in range(len(B)):
                d[A[i] + B[j]] += 1

        for i in range(len(C)):
            for j in range(len(D)):
                target = C[i] + D[j]
                if -target in d:
                    res += d[-target]
        return res


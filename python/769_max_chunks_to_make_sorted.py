class Solution:
    def maxChunksToSorted(self, arr: List[int]) -> int:
        # check A[:k + 1] == [0, 1, 2 ... k]
        # k: 0 .. len(arr) - 1
        curr = 0
        chunks = 0
        while curr < len(arr):
            for k in range(curr, len(arr)):
                if set(arr[curr:k + 1]) == set([i for i in range(curr, k + 1)]):
                    curr = k + 1
                    chunks += 1
                    break
        return chunks

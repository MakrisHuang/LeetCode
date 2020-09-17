class Solution:
    def hIndex(self, citations: List[int]) -> int:
        """
        In the first code, suppose H-index is h, so we take h numbers from the end index which satisfy the constraints given in the question that h numbers must be at least h
In this case h = n-i
So we just need to check, if the smallest of them all which is at index n-h = i is >= h, the other numbers to the right of this index automatically satisfy this constraint because they are greater
So the index satisfying citations[i] >= h
i.e. citations[i] >= n - i
        """
        citations.sort()
        n = len(citations)
        for i in range(n):
            if citations[i] >= (n - i): # h = n - i, ensure the last one (at index i) has the citations >= h
                return n - i
        return 0


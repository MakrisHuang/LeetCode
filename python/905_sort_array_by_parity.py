class Solution:
    def sortArrayByParity(self, A: List[int]) -> List[int]:
        # return [e for e in A if e % 2 == 0] + [e for e in A if e % 2 == 1]
        return sorted(A, key=lambda x: x % 2 == 1)


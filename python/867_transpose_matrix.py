class Solution:
    def transpose(self, A: List[List[int]]) -> List[List[int]]:
        res = []
        for col in range(len(A[0])):
            temp = []
            for row in range(len(A)):
                temp.append(A[row][col])
            res.append(temp)
        return res


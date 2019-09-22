class Solution:
    # Time Complexity: O(n)
    # Space Complexity: O(n)
    def findDiagonalOrder(self, matrix: List[List[int]]) -> List[int]:
        if not matrix or not matrix[0]:
            return []

        M, N = len(matrix), len(matrix[0])
        total = M * N
        isUp = True
        res = []
        i = j = count = 0
        while count < total:
            res.append(matrix[i][j])
            if isUp:
                # at left up
                if i - 1 < 0 and j + 1 < N:
                    j += 1
                    isUp = False
                # just actually at right up corner
                elif i - 1 == -1 and j + 1 == N:
                    i += 1
                    isUp = False
                # at right down
                elif i - 1 >= 0 and j + 1 >= N:
                    i += 1
                    isUp = False
                # while increasing
                else:
                    i -= 1
                    j += 1
            else:
                if i + 1 < M and j - 1 < 0:
                    i += 1
                    isUp = True
                elif i + 1 == M and j - 1 == -1:
                    j += 1
                    isUp = True
                elif i + 1 >= M and j - 1 >= 0:
                    j += 1
                    isUp = True
                else:
                    i += 1
                    j -= 1
            count += 1
        return res






class Solution:
    # Time Complexity: O(n ^ 2)
    # Space Complexity: O(n ^ 2)
    def generateMatrix(self, n: int) -> List[List[int]]:
        res = [[0 for _ in range(n)] for _ in range(n)]
        M, N = n, n
        row, col = 0, -1
        num_eles = n ** 2
        curr_num = 1
        while curr_num <= num_eles:
            # move right
            for i in range(0, N):
                col += 1
                res[row][col] = curr_num
                curr_num += 1
            M -= 1
            if M == 0: break

            # move down
            for i in range(0, M):
                row += 1
                res[row][col] = curr_num
                curr_num += 1
            N -= 1
            if N == 0: break

            # move left
            for i in range(0, N):
                col -= 1
                res[row][col] = curr_num
                curr_num += 1
            M -= 1
            if M == 0: break

            # move up
            for i in range(0, M):
                row -= 1
                res[row][col] = curr_num
                curr_num += 1
            N -= 1
            if N == 0: break
        return res

class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        # double for loop
        M, N = len(num1), len(num2)
        res = [0] * (M + N)
        for i in range(M - 1, -1, -1):
            for j in range(N - 1, -1, -1):
                multi = int(num1[i]) * int(num2[j])
                left = i + j
                right = i + j + 1
                accum = res[right] + multi
                res[right] = accum % 10
                res[left] += int(accum / 10)
        num_leading_0 = 0
        for num in res:
            if num == 0:
                num_leading_0 += 1
            else: break
        non_0_arr = [str(n) for n in res[num_leading_0:]]
        return ''.join(non_0_arr) if len(non_0_arr) > 0 else "0"
